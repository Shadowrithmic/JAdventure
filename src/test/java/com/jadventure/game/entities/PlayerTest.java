package com.jadventure.game.entities;

import com.jadventure.game.entities.Player;

import com.jadventure.game.items.Item;
import com.jadventure.game.navigation.Location;
import org.junit.Test;
import org.junit.Before;

import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    @Before
    public void copyFiles() {
        File source = new File("json/original_data/locations.json");
        File dest = new File("json/locations.json");
        try {
            Files.copy(source.toPath(), dest.toPath(),
                    StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void newRecruit() {
        Player player = Player.getInstance("recruit");
        int expected = 1;
        int actual = player.getArmour();
        assertEquals("Failure - new recruit not properly created", expected, actual);
    }
    
    @Test
    public void newSewerRat() {
        Player player = Player.getInstance("sewerrat");
        int expected = 0;
        int actual = player.getArmour();
        assertEquals("Failure - new recruit not properly created", expected, actual);
    }

    @Test
    public void oldPlayer() {
        Player player = Player.load("test");
        String expected = "test";
        String actual = player.getName();
        assertEquals("Failure - old player not properly loaded", expected, actual);
    }

    @Test
    public void checkPickEquip(){
        Item sword = createSword();
        Player masterP = Player.getInstance("recruit");
        Location field = new Location();
        field.addItem(sword);
        masterP.setLocation(field);
        masterP.pickAndEquip(sword.getName());
        assertEquals("wshs1", masterP.getWeapon());
    }

    private Item createSword() {
        Map<String, Integer> properties = new TreeMap<>();
        properties.put("damage", Integer.valueOf(7));
        properties.put("weight", Integer.valueOf(5));
        properties.put("value", Integer.valueOf(70));

        Item item = new Item("wshs1", "weapon", "shortsword", "a basic shortsword", 1, properties);
        return item;
    }



    /*
    @Test
    public void newVeteran() {
        Player player = Player.getInstance("veteran");
        int expected = 2;
        int actual = player.getArmour();
        assertEquals("Failure - new veteran not properly created", expected, actual);
    }
    public void setCharacterGetCharacter()
    {
        Player player = new Player();
        String expected ="test";
        player.setCurrentCharacterType(expected);
        String actual = player.getCurrentCharacterType();
        assertEquals("", expected, actual);
    }
    */
}
