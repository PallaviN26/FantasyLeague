package fantasy.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import fantasy.model.UserTeam;

@Component
@Repository
public class UserTeamRepo {
	@PersistenceContext
    private EntityManager entityManager;
	
	@Transactional
	public void insertQuery(UserTeam member ) {
		    entityManager.createNativeQuery("INSERT INTO user_team(user_id,user_team_id,game_id) VALUES (?,?,?)")
		      .setParameter(1, member.getUser_id())
		      .setParameter(2,member.getUser_team_id())
		      .setParameter(3, member.getGame_id())
//		      .setParameter(4,member.getPoints())
		      .executeUpdate();    
	}
	
	public int  fetchPoints(int user_team_id) 
	{
	int point = (Integer)entityManager.createNativeQuery("SELECT points FROM user_team where user_team_id = ?",UserTeam.class)
			.setParameter(1, user_team_id)
			.getSingleResult();
		return point;
	}
	@Modifying
	public void UpdatePoints(int user_team_id,int points ) {
		entityManager.createNativeQuery("Update user_team set points = ?  where used_team_id = ?",UserTeam.class )
		.setParameter(1, points)
		.setParameter(2, user_team_id)
		.executeUpdate();
	}
	public List<UserTeam> Ranking(int match_id) {
		@SuppressWarnings("unchecked")
		List<UserTeam> card= (List<UserTeam>)entityManager.createNativeQuery("Select * from user_team where game_id = ? group by points desc", UserTeam.class)
				                .setParameter(1, match_id);
				                	
	return card;
	
				
	}
}
