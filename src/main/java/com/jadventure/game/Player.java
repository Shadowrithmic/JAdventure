package com.jadventure.game;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jadventure.game.navigation.ILocation;
import com.jadventure.game.navigation.LocationManager;
import com.jadventure.game.navigation.LocationType;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;

public class Player extends Entity {
    private ILocation location;
    
    private Player(){
        setBackpack(new ArrayList<Item>());
        Item milk = new Item(1);
        addItemToBackpack(milk);
    }

    protected static String getProfileFileName(String name) {
        return "json/profiles/" + name + "/" + name + "_profile.json";
    }

    public static boolean profileExists(String name) {
        File file = new File(getProfileFileName(name));
        return file.exists();
    }

    public static Player load(String name) {
        Player player = new Player();

        JsonParser parser = new JsonParser();
        String fileName = getProfileFileName(name);
        try {
            Reader reader = new FileReader(fileName);
            JsonObject json = parser.parse(reader).getAsJsonObject();

            player.setName(json.get("name").getAsString());
            player.setHealthMax(json.get("healthMax").getAsInt());
            player.setHealth(json.get("health").getAsInt());
            player.setArmour(json.get("armour").getAsInt());
            player.setDamage(json.get("damage").getAsInt());
            player.setLevel(json.get("level").getAsInt());
            player.setLocation(LocationManager.INSTANCE.getLocation(json.get("location").getAsInt()));

            reader.close();
        } catch (FileNotFoundException ex) {
            System.out.println( "Unable to open file '" + fileName + "'.");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return player;
    }

    // This is known as the singleton pattern. It allows for only 1 instance of a player.
    private static Player player;
    
    public static Player getInstance(){
        if(player == null){
            // Instead of having a huge constructor, this is much more readable.
            player =  new Player();
            player.setHealthMax(100);
            player.setHealth(100);
            player.setArmour(1);
            player.setDamage(50);
            player.setLevel(1);
            player.setLocation(LocationManager.INSTANCE.getInitialLocation());

            return player;
            
        }
        return player;
    }

    public void addItem(Item i){
        
    }

    public void getStats(){
        System.out.println("Player name: " + getName() +
                            "\nHealth/Max: " + getHealth() + "/" + getHealthMax() +
                            "\nDamage/Armour: " + getDamage() + "/" + getArmour() +
                            "\n" + getName() + "'s level: " + getLevel());
    }

    public void printBackPack() {
        System.out.println("\n--------------------------------------------------------------------");
        System.out.println("Backpack: ");

        if (getBackpack().isEmpty()) {
            System.out.println("--Empty--");
        }
        else {
            for (Item item : getBackpack()) {
                System.out.println("- " + item.getName());
            }
        }    System.out.println("\n--------------------------------------------------------------------");
    }

    public void save() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("name", getName());
        jsonObject.addProperty("healthMax", getHealthMax());
        jsonObject.addProperty("health", getHealthMax());
        jsonObject.addProperty("armour", getArmour());
        jsonObject.addProperty("damage", getDamage());
        jsonObject.addProperty("level", getLevel());
        jsonObject.addProperty("location", getLocation().getId());

        Gson gson = new Gson();
        String fileName = getProfileFileName(getName());
        new File(fileName).getParentFile().mkdirs();
        try {
            Writer writer = new FileWriter(fileName);
            gson.toJson(jsonObject, writer);
            writer.close();
            System.out.println("Your game data was saved.");
        } catch (IOException ex) {
            System.out.println("Unable to save to file '" + fileName + "'.");
        }
    }

    public ILocation getLocation() {
        return location;
    }

    public void setLocation(ILocation location) {
        this.location = location;
    }

    public LocationType getLocationType(){
    	return getLocation().getLocationType();
    }
}
