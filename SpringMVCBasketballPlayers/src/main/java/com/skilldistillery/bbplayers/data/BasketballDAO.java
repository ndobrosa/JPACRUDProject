package com.skilldistillery.bbplayers.data;

import java.util.List;

import com.skilldistillery.bbplayers.entities.Player;

public interface BasketballDAO {
	Player getPlayerById(int id);
	List<Player> findAll();
	Player add(Player player);
	Player update(Player player);
//	boolean delete(Player player);
	boolean deleteById(int id);
	List<Player> getPlayerByName(String Name);
	
}
