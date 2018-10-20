package com.skilldistillery.bbplayers.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlayerTests {
	private static EntityManagerFactory emf;
	private EntityManager em;

	@BeforeAll
	static void setUpAll() throws Exception {
		emf = Persistence.createEntityManagerFactory("BasketballPlayers");
	}
	
	@AfterAll
	static void tearDownAll() throws Exception {
		emf.close();
	}
	
	
	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
	}

	@Test
	void test_Player_mappings() {
		Player player = em.find(Player.class, 1);
		assertEquals("Alex", player.getFirstName());
		assertEquals("Abrines", player.getLastName());
		assertEquals("G", player.getPosition());
		assertEquals(25, player.getAge());
		assertEquals("Oklahoma City Thunder", player.getTeam());
		assertEquals("Spain", player.getNationality());
	}

}
