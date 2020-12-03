package fantasy.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import fantasy.model.Team;
import fantasy.repo.TeamsRepo;

@Controller
public class TeamApi {

	@Autowired
	TeamsRepo teamsRepo;

	@GetMapping("/team/{teamId}")
	public ResponseEntity<Map<String, Object>> fetchTeam(@PathVariable("teamId") String teamId) {
		Team team = teamsRepo.fetchTeam(teamId);
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("data", team);
		response.put("status", "success");
		return ResponseEntity.ok(response);
 
	}

	@PostMapping("/team")
	public ResponseEntity<String> addTeam(@RequestBody Team team) {

		// teamService.addTeam(team);
		teamsRepo.insertWithQuery(team);
		return ResponseEntity.ok("Team added successfully");
	}
}
