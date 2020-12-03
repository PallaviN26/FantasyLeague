package fantasy.repo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import fantasy.model.Match;
import fantasy.model.Team;

@Component
@Repository

public class PlayerRepo {
	
	@PersistenceContext
    private EntityManager entityManager;
	
	public void insertWithQuery(Match match) {
	    entityManager.createNativeQuery("INSERT INTO match (match_id, team1_id,team2_id,venue,date) VALUES (?,?,?,?,?)")
	      .setParameter(1, match.getMatch_id())
	      .setParameter(2, match.getTeam1_id())
	      .setParameter(3, match.getTeam2_id())
	      .setParameter(4, match.getVenue())
	      .setParameter(5,match.getMatchDate())
	      .executeUpdate();    
	}
	
	public Team fetchTeam(String teamId) {
		Team team = (Team)entityManager.createNativeQuery("SELECT * FROM team where team_id = ?", Team.class)
			.setParameter(1, teamId)
			.getSingleResult();
		return team;
	}
	
	

}
