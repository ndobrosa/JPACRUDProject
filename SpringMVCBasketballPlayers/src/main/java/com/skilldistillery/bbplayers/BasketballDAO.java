package com.skilldistillery.bbplayers;

import java.util.List;

import com.skilldistillery.bbplayers.entities.Player;

public interface BasketballDAO {
	Player getPlayerById(int id);
	List<Player> findAll();
	Player add(Player player);
	Player update(Player player);
	boolean delete(Player player);
	boolean deleteById(int id);
	
}