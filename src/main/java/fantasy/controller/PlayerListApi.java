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

import fantasy.model.Match;
import fantasy.model.PlayerList;
import fantasy.repo.PlayerListRepo;

@Controller
public class PlayerListApi {
	@Autowired
	PlayerListRepo players;
	@GetMapping("/user/match/{match_id}/players")
	public ResponseEntity<Map<String, Object>> fetchPlayers(@PathVariable String match_id) {
		List<PlayerList> player = players.fetchPlayers(match_id);
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("data", player);
		response.put("status", "success");
		return ResponseEntity.ok(response);
	}
	
	@PostMapping("/list")
	public ResponseEntity<String> addTeam(@RequestBody PlayerList playerList) {
		players.insertWithQuery(playerList);
		return ResponseEntity.ok("Team added successfully");
	}
}
