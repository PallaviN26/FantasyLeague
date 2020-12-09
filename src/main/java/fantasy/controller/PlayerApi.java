package fantasy.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import fantasy.model.PlayerList;
import fantasy.repo.PlayerRepo;

@Controller
public class PlayerApi {
	@Autowired
	PlayerRepo playerrepo;
	@GetMapping("/{user_team_id}/preview")
	public ResponseEntity<Map<String, Object>> fetchPlayers(@PathVariable int user_team_id) {
		List<PlayerList> u_players  = playerrepo.teamPlayers(user_team_id);
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("data", u_players);
		response.put("status", "success");
		return ResponseEntity.ok(response);
	}
//	@PostMapping("/user/{user_id}/match/{match_id}/players")
//	public ResponseEntity<String> addTeam(@RequestBody players) {
//
//		// teamService.addTeam(team);
//		teamsRepo.insertWithQuery();
//		return ResponseEntity.ok("Team added successfully");
//	}
}
