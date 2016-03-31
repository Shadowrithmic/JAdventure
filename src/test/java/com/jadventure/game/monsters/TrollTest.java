package com.jadventure.game.monsters;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by EntheoMac on 2/4/16.
 */
public class TrollTest {

    @Test
    public void createTest() {
        Troll troll = new Troll(4);
        assertEquals("Troll", troll.monsterType);
        assertEquals(16, troll.getArmour());
        assertEquals(114, troll.getHealthMax());
    }

    @Test
    public void checkEqual() {
        Troll troll1 = new Troll(4);
        Troll troll2 = new Troll(4);

        assertEquals(troll1, troll2);
    }
}