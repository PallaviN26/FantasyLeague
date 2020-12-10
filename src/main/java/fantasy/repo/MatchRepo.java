package fantasy.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
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
	    entityManager.createNativeQuery("INSERT INTO match (match_id, first_id,second_id,venue) VALUES (?,?,?,?)")
	      .setParameter(1, match.getMatchId())
	      .setParameter(2, match.getFirstId())
	      .setParameter(3, match.getSecondId())
	      .setParameter(4, match.getVenue())
	      .executeUpdate();    
	}
	
	@SuppressWarnings("unchecked")
	@Query
	public List<Match> fetchMatches() {
		List<Match> matches = entityManager.createNativeQuery("select * from match", Match.class)
			.getResultList();
		return matches;
	}
	
	

}
