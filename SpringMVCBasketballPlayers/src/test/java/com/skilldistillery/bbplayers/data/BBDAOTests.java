package com.skilldistillery.bbplayers.data;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.skilldistillery.bbplayers.entities.Player;

public class BBDAOTests {
	private BasketballDAO bdao;
	

	@Before
	public void setUp() throws Exception {
		bdao = new BasketballDAOImpl();
	}

	@After
	public void tearDown() throws Exception {
		bdao = null;
	}

	@Test
	public void test_getPlayerById_returns_player_or_null() {
		Player player = bdao.getPlayerById(1);
		assertEquals("Alex", player.getFirstName());
		assertEquals("Abrines", player.getLastName());
		assertEquals("G", player.getPosition());
		assertEquals(25, player.getAge());
		assertEquals("Oklahoma City Thunder", player.getTeam());
		assertEquals("Spain", player.getNationality());
		
	}

}
