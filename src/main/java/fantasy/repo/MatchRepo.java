package fantasy.repo;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import fantasy.model.Match;

@Component
@Repository
public class MatchRepo {
	@PersistenceContext
    private EntityManager entityManager;
	
	@Transactional
	public void insertWithQuery(Match match) {
	    entityManager.createNativeQuery("INSERT INTO match (match_id, team1_id,team2_id,venue,date) VALUES (?,?,?,?,?)")
	      .setParameter(1, match.getMatch_id())
	      .setParameter(2, match.getTeam1_id())
	      .setParameter(3, match.getTeam2_id())
	      .setParameter(4, match.getVenue())
	      .setParameter(5,match.getMatchDate())
	      .executeUpdate();    
	}
	public List<Match> fetchMatches() {
		List<Match> matches = (LinkedList<Match>)entityManager.createNativeQuery("SELECT * FROM match", Match.class)
			.getResultList();
		return matches;
	}
	
	

}
