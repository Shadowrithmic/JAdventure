package com.jadventure.game.monsters;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BugbearTest {
	private Bugbear bugbear;
	@Before
	public void setUp() throws Exception {
		bugbear = new Bugbear(5);
	}

	@After
	public void destroy(){
		bugbear = null;
	}
	
	@Test
	public void test_monster_type() {
		String type1 = bugbear.monsterType;
		assertEquals(type1, "Bugbear");
	}
	
	@Test
	public void test_attributes(){
		int max_hp = bugbear.getHealthMax();
		assertEquals(max_hp, (50 + 5 * 5));
		
		assertEquals(bugbear.getArmour(), 5);
		assertEquals(bugbear.getIntelligence(), 1);
		assertEquals(bugbear.getStealth(), 1);
		assertEquals(bugbear.getDexterity(), 1);
		assertEquals(bugbear.getXPGain(), (30 + 5 * 3));
		assertEquals(bugbear.getGold(), 15);
	}
}
