package com.skilldistillery.bbplayers.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.skilldistillery.bbplayers.entities.Player;


@Transactional
@Repository
public class BasketballDAOImpl implements BasketballDAO {
	
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Player getPlayerById(int id) {
		Player player = em.find(Player.class, id);
		return player;
	}
	
	@Override
	public List<Player> findAll() {
		
		String query = "select p from Player p";
		List<Player> players = em.createQuery(query, Player.class).getResultList();
		return players;
	}

	@Override
	public Player add(Player player) {
		em.persist(player);
		em.flush();
		
		return player;
		
	}

	@Override
	public Player update(Player inputPlayer) {
		
		Player editedPlayer = em.find(Player.class, inputPlayer.getId());
		
		editedPlayer.setAge(inputPlayer.getAge());
		editedPlayer.setFirstName(inputPlayer.getFirstName());
		editedPlayer.setLastName(inputPlayer.getLastName());
		editedPlayer.setNationality(inputPlayer.getNationality());
		editedPlayer.setPosition(inputPlayer.getPosition());
		editedPlayer.setTeam(inputPlayer.getTeam());
		
		return editedPlayer;
	}
	
	

//	@Override
//	public boolean delete(Player player) {
//		return false;
//	}

	@Override
	public boolean deleteById(int id) {
		Player player = em.find(Player.class, id);
		
		boolean isPlayerDeleted = false;
		if(player != null) {
			em.remove(player);
			if (em.find(Player.class, id) == null) {
				isPlayerDeleted = true;
			}
		}
		
		return isPlayerDeleted;
	}

	@Override
	public List<Player> getPlayerByName(String inputName) {
		String query = "select p from Player p where firstName like :name or lastName like :name";
		List<Player> players = em.createQuery(query, Player.class).setParameter("name", "%" +inputName + "%").getResultList();
		return players;
	}

}
