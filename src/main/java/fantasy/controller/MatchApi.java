package fantasy.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import fantasy.model.Match;
import fantasy.model.Team;
import fantasy.repo.MatchRepo;

@Controller
public class MatchApi {
	@Autowired
	MatchRepo matchrepo;
	
	@GetMapping("/match")
	public ResponseEntity<Map<String, Object>> fetchTeam() {
		List<Match> match  = matchrepo.fetchMatches();
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("data", match);
		response.put("status", "success");
		return ResponseEntity.ok(response);
	}
	
	@PostMapping("/match")
	public ResponseEntity<String> addTeam(@RequestBody Match match) {
		matchrepo.insertWithQuery(match);
		return ResponseEntity.ok("Team added successfully");
	}
}
