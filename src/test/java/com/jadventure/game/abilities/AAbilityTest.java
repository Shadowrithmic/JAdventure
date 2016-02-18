package com.jadventure.game.abilities;

import com.jadventure.game.entities.Entity;
import com.jadventure.game.entities.Player;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * superclass of all abilities
 */

public class AAbilityTest {
    AAbility a;
    @Before
    public void setUp() {
        a = new HeavySwing();
    }

    @After
    public void tearDown() {
        a = null;
    }

    @Test
    public void testCast() {
        Entity t = new Player();

        t.setHealthMax(10);
        t.setHealth(10);

        a.cast(t);

        assertEquals(5, t.getHealth());
    }

    @Test
    public void testGetDamage() {
        assertEquals(a.getDamage(), 5);
    }

    @Test
    public void testSetDamage() {
        a.setDamage(27);
        assertEquals(27, a.getDamage());
    }
}