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

	@Autowired
	BasketballDAO bdao;

	@RequestMapping(path = "home.do", method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/views/index.jsp");
		return mv;
		// return "index"; // if using a ViewResolver.
	}

	@RequestMapping(path = "getPlayer.do", method = RequestMethod.GET)
	public ModelAndView getPlayer(@RequestParam(value = "pid") int aid) {
		ModelAndView mv = new ModelAndView();

		Player player = bdao.getPlayerById(aid);

		mv.addObject("player", player);
		mv.setViewName("WEB-INF/views/show.jsp");
		return mv;
	}

	@RequestMapping(path = "getAllPlayers.do", method = RequestMethod.GET)
	public String getAllPlayers(Model model) {

		List<Player> players = bdao.findAll();

		model.addAttribute("players", players);

		return "WEB-INF/views/show.jsp";

	}

	@RequestMapping(path = "startPlayerCreation.do", method = RequestMethod.GET)
	public String createPlayerPage() {
		return "WEB-INF/views/createPlayer.jsp";
	}

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

		System.out.println("***************************************************************************************************");
		System.out.println(player);
		player = bdao.add(player);

		mv.addObject("player", player);
		mv.setViewName("redirect:getPlayer.do?pid=" + player.getId());

		return mv;
	}


}
