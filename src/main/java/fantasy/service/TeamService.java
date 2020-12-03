package fantasy.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import fantasy.model.Team;

@Service
public class TeamService {
	Map<String, Team> map = new HashMap<String, Team>();
	
	public Team fetchTeam(String teamId) {
		return map.get(teamId);
	}
	
	public void addTeam(Team team) {
		map.put(team.getTeamId(), team);
	}
}
