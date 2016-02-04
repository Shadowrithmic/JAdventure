package com.jadventure.game.entities;

import com.jadventure.game.entities.Player;

import org.junit.Test;
import org.junit.Before;

import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.io.File;
import java.io.IOException;

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
<<<<<<< HEAD
    public void newVeteran(){
        Player player = Player.getInstance("veteran");
        int expected = 2;
        int actual = player.getArmour();
        assertEquals("Failure - new veteran not properly created", expected, actual);
=======
    public void setCharacterGetCharacter()
    {
        Player player = new Player();
        String expected ="test";
        player.setCurrentCharacterType(expected);
        String actual = player.getCurrentCharacterType();
        assertEquals("", expected, actual);
>>>>>>> 58e270301884aa8b2dadd7f000580ee495c9c313
    }
}
