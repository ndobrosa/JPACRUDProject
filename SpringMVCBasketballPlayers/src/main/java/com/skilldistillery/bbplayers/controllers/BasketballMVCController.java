package com.skilldistillery.bbplayers.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.skilldistillery.bbplayers.data.BasketballDAO;
import com.skilldistillery.bbplayers.entities.Player;


@Controller
public class BasketballMVCController {

	//@Autowired Used to autowire BasketballDAOImpl repository, which implements BasketballDAO
	@Autowired
	BasketballDAO bdao;

	//In web.xml homel.do is marked as the welcom file. The method below sets the homepage view to index.jsp
	@RequestMapping(path = "home.do", method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/views/index.jsp");
		return mv;
		// return "index"; // if using a ViewResolver.
	}

	// The method below handles the getPlayer.do request by taking a single parameter and returning a player object and setting a view to show.jsp.
	@RequestMapping(path = "getPlayer.do", method = RequestMethod.GET)
	public ModelAndView getPlayer(@RequestParam(value = "pid") int aid) {
		ModelAndView mv = new ModelAndView();

		//The player object is retrieved from a database by getPlayerById(int id) method method in the BasketballDAOImpl class.
		Player player = bdao.getPlayerById(aid);

		mv.addObject("player", player);
		
		
		mv.setViewName("WEB-INF/views/show.jsp");
		return mv;
	}

	
	/* 
	 * The method below retrieves a list of all rows (saved into player objects) from the database, passes the list to the  
	 * front end ad an attribute and sets the view to show.jsp.
	 */
	@RequestMapping(path = "getAllPlayers.do", method = RequestMethod.GET)
	public String getAllPlayers(Model model) {

		List<Player> players = bdao.findAll();

		model.addAttribute("players", players);

		return "WEB-INF/views/show.jsp";

	}

	/*
	 * When the startPlayerCreation.do action is requested, the method below sets the view to createPlayer.jsp which allows the user to input
	 * new player information. More info in the WEB-INF/views/createPlayer.jsp file. 
	 */
	@RequestMapping(path = "startPlayerCreation.do", method = RequestMethod.GET)
	public String createPlayerPage() {
		return "WEB-INF/views/createPlayer.jsp";
	}
	
	@RequestMapping(path = "editPlayer.do", method = RequestMethod.GET)
	public ModelAndView editPlayer(@RequestParam(value = "pid") int id) {
		ModelAndView mv = new ModelAndView();
		Player player = bdao.getPlayerById(id);

		mv.addObject("player", player);
		mv.setViewName("WEB-INF/views/createPlayer.jsp");
		return mv;
	}
	
	/*
	 * This method adds a new player to the database based on parameters collected from the form.
	 */
	@RequestMapping(path = "newplayer.do", method = RequestMethod.POST)
	public ModelAndView createPlayerResult(@RequestParam(value = "first_name") String firstName,
			@RequestParam(value = "last_name") String lastName,
			@RequestParam(value = "position", required = false) String position, @RequestParam(value = "age") int age,
			@RequestParam(value = "team", required = false) String team,
			@RequestParam(value = "nationality") String nationality) {
		ModelAndView mv = new ModelAndView();

		Player player = new Player();

		player.setFirstName(firstName);
		player.setLastName(lastName);
		player.setAge(age);
		player.setNationality(nationality);

		if (team != null && team != "") {
			player.setTeam(team);
		}
		if (position != null && position != "") {
			player.setPosition(position);
		}

		player = bdao.add(player);

		mv.addObject("player", player);
		mv.setViewName("redirect:getPlayer.do?pid=" + player.getId());

		return mv;
	}
	
	//This method edits a column values of a player in the database.
	@RequestMapping(path = "confirmedit.do", method = RequestMethod.POST)
	public ModelAndView updatePlayer(
			@RequestParam(value = "pid") int id,
			@RequestParam(value = "first_name") String firstName,
			@RequestParam(value = "last_name") String lastName,
			@RequestParam(value = "position", required = false) String position, @RequestParam(value = "age") int age,
			@RequestParam(value = "team", required = false) String team,
			@RequestParam(value = "nationality") String nationality) {
		ModelAndView mv = new ModelAndView();

		Player player = bdao.getPlayerById(id);

		player.setFirstName(firstName);
		player.setLastName(lastName);
		player.setAge(age);
		player.setNationality(nationality);

		if (team != null) {
			player.setTeam(team);
		}
		if (position != null) {
			player.setPosition(position);
		}


		player = bdao.update(player);

		mv.addObject("player", player);
		mv.setViewName("redirect:getPlayer.do?pid=" + player.getId());

		return mv;

	}
	
	// This method removes a player from the database.
	@RequestMapping(path = "deletePlayer.do", method = RequestMethod.POST)
	public ModelAndView deletePlayer(
			@RequestParam(value = "pid") int id) {
		ModelAndView mv = new ModelAndView();
		 
		Boolean wasPlayerDeleted = bdao.deleteById(id);
		
		System.out.println(wasPlayerDeleted);
		
//		mv.addObject("playerDeleted", wasPlayerDeleted);
		mv.setViewName("redirect:confirmDeletion.do?playerDeleted=" + wasPlayerDeleted.toString());
		
		return mv;
	}
	
	@RequestMapping(path = "confirmDeletion.do", method = RequestMethod.GET)
	public String confirmPlayerDelted(Model model,@RequestParam(value = "playerDeleted") boolean playerDeleted) {
		model.addAttribute("playerDeleted", playerDeleted);
		
		
		return "WEB-INF/views/index.jsp";
	}
	
	
	
	
	
	
}