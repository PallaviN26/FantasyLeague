package fantasy.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import fantasy.model.PlayerContainer;
import fantasy.model.PlayerList;
import fantasy.repo.PlayerListRepo;

@Controller
public class PlayerListApi {
	@Autowired
	PlayerListRepo players;

	@GetMapping("/players/{match_id}")
	public String fetchPlayers(@PathVariable String match_id, Map<String, Object> model) {
		PlayerContainer members = new PlayerContainer();
		members.setPlayerList(players.fetchPlayers(match_id));
		model.put("result", members);
		return "player";
	}

	@PostMapping("/list")
	public ResponseEntity<String> addTeam(@RequestBody List<PlayerList> playerList) {
		players.insertWithQuery(playerList);
		return ResponseEntity.ok("Players added successfully");
	}
}
