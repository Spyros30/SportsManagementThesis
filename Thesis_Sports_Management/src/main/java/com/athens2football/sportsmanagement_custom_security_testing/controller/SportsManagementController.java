/* In the SportsManagementController all the requests from the web application about tournaments and 
 * teams are developed in this class and delegated to the service. In order to delegate the call to
 *  the service a dependency injection has taken place(with the @Autowired annotation) so the 
 * sportsManagementService class can be used in this controller. After any method reaches the
 * end a return occurs where it delegates the call back to the correct view template.
 */

package com.athens2football.sportsmanagement_custom_security_testing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.athens2football.sportsmanagement_custom_security_testing.entity.Team;
import com.athens2football.sportsmanagement_custom_security_testing.entity.Tournament;
import com.athens2football.sportsmanagement_custom_security_testing.entity.User;
import com.athens2football.sportsmanagement_custom_security_testing.service.SportsManagementService;
import com.athens2football.sportsmanagement_custom_security_testing.service.UserService;


@Controller
@RequestMapping("/")
public class SportsManagementController {
	
	@Autowired
	private SportsManagementService sportsManagementService;
	
	@GetMapping("/tournaments/list") 
	public String tournamentsList(Model theModel){
		
		// get tournaments from db
		List<Tournament> theTournaments = sportsManagementService.findAllTournaments();
			
		// add to the spring model
		theModel.addAttribute("tournaments", theTournaments);
		
		return "tournaments/tournaments-list";
	}
	
	@GetMapping("/tournaments/showAddForm") 
	public String showAddForm(Model theModel) {
		
		// create model attribute to bind form data
		Tournament theTournament = new Tournament();
		
		theModel.addAttribute("tournament", theTournament);
		
		return "tournaments/tournaments-form";
	}
	
	@GetMapping("/tournaments/showUpdateForm")
	public String showUpdateForm(@RequestParam("tournamentId") int theId, 
			Model theModel) {
		
		
		Tournament theTournament = sportsManagementService.findById(theId);
		
		// set tournament as a model attribute to pre-populate the form
		theModel.addAttribute("tournament", theTournament);
		
		
		return "tournaments/tournaments-form";
		
	}
	
	@PostMapping("/tournaments/save")
	public String saveTournament(@ModelAttribute("tournament") Tournament theTournament) {
		
		
		sportsManagementService.save(theTournament);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/tournaments/list";
		
	}
	
	@GetMapping("/tournaments/delete")
	public String delete(@RequestParam("tournamentId") int theId) {
		
		
		sportsManagementService.deleteById(theId);
		
		
		return "redirect:/tournaments/list";
	}
	
	@GetMapping("/tournaments/teams")
	public String TeamListOnTournament(@RequestParam int tournamentId, Model theModel) {
		
		
				Tournament theTournament = sportsManagementService.findByTournamentId(tournamentId);
				
				List<Team> teamsTournament = theTournament.getTeams();
				
				theModel.addAttribute("tournament", teamsTournament);
				
				
		return "tournaments/teams/teams-list";
	}
	
}
	


