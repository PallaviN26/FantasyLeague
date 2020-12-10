package fantasy.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import fantasy.model.PlayerList;

@Component
@Repository

public class PlayerRepo {
	
	@PersistenceContext
    private EntityManager entityManager;
	
	public List<PlayerList> teamPlayers(int user_team_id){
		@SuppressWarnings("unchecked")
		List<PlayerList> players =  (List<PlayerList>)entityManager.createNativeQuery("SELECT * FROM playerslist  where player_id = (Select player_id from userteam where user_team_id = ?", PlayerList.class)
				.setParameter(1, user_team_id)
				.getResultList();
		return players;
		
	}
	

}
