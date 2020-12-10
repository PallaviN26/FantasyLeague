package fantasy.repo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import fantasy.model.PlayerScore;

public class PlayerScoreRepo {
	@PersistenceContext
    private EntityManager entityManager;
	
	@Transactional
	public void insertWithQuery(PlayerScore score) {
	    entityManager.createNativeQuery("INSERT INTO player_score (player_id, runs ,wickets ,catches) VALUES (?,?,?,?)")
	      .setParameter(1,score.getPlayer_id() )
	      .setParameter(2,score.getRuns())
	      .setParameter(3, score.getWickets())
	      .setParameter(4,score.getCatches() )
	      .executeUpdate();    
	}
	@Modifying
    public void UpdatePoints(PlayerScore score) {
    	entityManager.createNativeQuery("Update player_score set runs = runs + ? , wickets = wickets + ?,catches = catches + ?,points = points + runs + wickets*25 + catches*8 where player_id = ? AND match_id = ?",PlayerScore.class)
        .setParameter(1, score.getRuns())
        .setParameter(2, score.getWickets())
        .setParameter(3,score.getCatches())
        .setParameter(4, score.getPlayer_id())
        .setParameter(5,score.getMatch_id())
        .executeUpdate();
	}
}
