package com.jadventure.game.repository;

/**
 * Created by Jim on 2/2/2016.
 */
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import org.junit.Test;
import com.jadventure.game.items.Item;

public class ItemRepositoryTestApple {
    @Test
    public void addItem() throws IOException {
        ItemRepository itemRepo = new ItemRepository();

        itemRepo.addItem(createApple());

        Item item = itemRepo.getItem("apple");

        assertNotNull(item);
        assertEquals("apple", item.getId());
        assertEquals("apple", item.getName());
        assertEquals("Shiny Red Apple", item.getDescription());

        assertNotNull(item.getProperties());
        assertEquals(Integer.valueOf(2), item.getProperties().get("health"));
        assertEquals(Integer.valueOf(1), item.getProperties().get("weight"));
        assertEquals(Integer.valueOf(5), item.getProperties().get("value"));
    }
    private Item createApple() {
        Map<String, Integer> properties = new TreeMap<>();
        properties.put("health", Integer.valueOf(2));
        properties.put("weight", Integer.valueOf(1));
        properties.put("value", Integer.valueOf(5));

        Item item = new Item("apple", "food", "apple", "Shiny Red Apple", 1, properties);
        return item;
    }
}
