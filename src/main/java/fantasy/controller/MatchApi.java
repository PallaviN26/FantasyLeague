package fantasy.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import fantasy.model.Match;
import fantasy.repo.MatchRepo;

public class MatchApi {
	@Autowired
	MatchRepo matchrepo;
	// i dont havae to store to match table from user ...
	// i just have to display
	// use get mapping 
	// printing on web is done in js
	// yes
	
	@GetMapping("/match")
	public ResponseEntity<Map<String, Object>> fetchTeam() {
		List<Match> match  = matchrepo.fetchMatches();
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("data", match);
		response.put("status", "success");
		return ResponseEntity.ok(response);
	}
}
