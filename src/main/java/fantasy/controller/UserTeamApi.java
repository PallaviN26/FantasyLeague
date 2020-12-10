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

import fantasy.model.UserTeam;
import fantasy.repo.UserTeamRepo;

@Controller
public class UserTeamApi {
	
	@Autowired
	UserTeamRepo userTeamRepo;
	
	@PostMapping("/user-team")
	public ResponseEntity<String> addUser(@RequestBody UserTeam userTeam) {
		userTeamRepo.addUserTeam(userTeam);
		return ResponseEntity.ok("Team created successfully");
	}
	
	@GetMapping("/rank/{match_id}")
	public ResponseEntity<Map<String, Object>> rankTeams(@PathVariable int match_id) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("success", true);
		result.put("data", userTeamRepo.ranking(match_id));
		return ResponseEntity.ok(result);
	}
	

}
