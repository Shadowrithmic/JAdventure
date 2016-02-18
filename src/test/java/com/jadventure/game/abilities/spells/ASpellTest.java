package com.jadventure.game.abilities.spells;

import com.jadventure.game.entities.Entity;
import com.jadventure.game.entities.Player;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ASpellTest {
    ASpell s;
    @Before
    public void setUp() throws Exception {
        s = new Fireball();
    }

    @After
    public void tearDown(){
        s = null;
    }

    @Test
    public void testASpell(){
        assertEquals(s.getDamage(),5);
        assertEquals(s.getManaCost(), 5);
    }

    @Test
    public void testSetManaCost(){
        s.setManaCost(11);
        assertEquals(s.getManaCost(), 11);
    }

    @Test
    public void testPayCost(){
        Entity caster = getCaster();
        assertTrue(s.payCost(caster));
        assertEquals(caster.getMana(), 45);
    }

    @Test
    public void testCast(){
        Entity caster = getCaster();
        Entity target = getTarget();

        s.cast(caster, target);
        assertEquals(target.getHealth(), 45);
        assertEquals(caster.getMana(), 45);
        
    }

    private Entity getTarget() {
        Entity target = new Player();
        target.setHealthMax(50);
        target.setHealth(50);
        return target;
    }

    private Entity getCaster() {
        Entity caster = new Player();
        caster.setManaMax(50);
        caster.setMana(50);
        return caster;
    }
}