package fantasy.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import fantasy.model.Match;
import fantasy.model.MatchContainer;
import fantasy.repo.MatchRepo;

@Controller
public class MatchApi {
	@Autowired
	MatchRepo matchrepo;
	
	@GetMapping("/match")
	public String fetchMatches(Map<String, Object> model) {
    	MatchContainer con = new MatchContainer();
    	con.setMatchList(matchrepo.fetchMatches());
        model.put("message",con);
        return "index";
    }
	
	@PostMapping("/match")
	public ResponseEntity<String> addTeam(@RequestBody Match match) {
		matchrepo.insertWithQuery(match);
		return ResponseEntity.ok("Team added successfully");
	}
}
