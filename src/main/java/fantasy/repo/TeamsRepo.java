package fantasy.repo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import fantasy.model.Team;

@Component
@Repository
public class TeamsRepo {
	@PersistenceContext
    private EntityManager entityManager;
	
	@Transactional
	public void insertWithQuery(Team team) {
	    entityManager.createNativeQuery("INSERT INTO team (team_id, team_name) VALUES (?,?)")
	      .setParameter(1, team.getTeamId())
	      .setParameter(2, team.getTeamName())
	      .executeUpdate();    
	}
	
	public Team fetchTeam(String teamId) {
		Team team = (Team)entityManager.createNativeQuery("SELECT * FROM team where team_id = ?", Team.class)
			.setParameter(1, teamId)
			.getSingleResult();
		return team;
	}
	
}
