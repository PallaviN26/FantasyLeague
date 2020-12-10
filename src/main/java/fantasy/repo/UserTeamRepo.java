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
	public void addUserTeam(UserTeam team) {
		entityManager.createNativeQuery("INSERT INTO user_team(user_id,user_team_id,match_id) VALUES (?,?,?)")
				.setParameter(1, team.getUserId()).setParameter(2, team.getUserTeamId())
				.setParameter(3, team.getMatchId()).executeUpdate();
	}

	public int fetchPoints(int userTeamId) {
		int point = (Integer) entityManager
				.createNativeQuery("SELECT points FROM user_team where user_team_id = ?", UserTeam.class)
				.setParameter(1, userTeamId).getSingleResult();
		return point;
	}

	@Modifying
	public void updatePoints(int user_team_id, int points) {
		entityManager.createNativeQuery("Update user_team set points = ?  where used_team_id = ?")
				.setParameter(1, points).setParameter(2, user_team_id).executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<UserTeam> ranking(int match_id) {
		List<UserTeam> teamByRank = entityManager
				.createNativeQuery("Select * from user_team where match_id = ? group by points desc", UserTeam.class)
				.setParameter(1, match_id).getResultList();

		return teamByRank;
	}

	@Modifying
	public int setPoints(int user_team_id) {
		int points = (Integer) entityManager.createNativeQuery(
				"Select SUM(score) in player_score where player_id IN (Select player_id from User_team where user_team_id = ?)",
				Integer.class).setParameter(1, user_team_id).getSingleResult();
		entityManager.createNativeQuery("Update user_team set points = ?").setParameter(1, points).executeUpdate();
		return points;
	}
}
