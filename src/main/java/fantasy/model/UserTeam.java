package fantasy.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserTeam {
	@Id
	public int userTeamId;
	public int userId;
	public int matchId;
	public int points;
	
	public int getUserTeamId() {
		return userTeamId;
	}
	public void setUserTeamId(int userTeamId) {
		this.userTeamId = userTeamId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getMatchId() {
		return matchId;
	}
	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	
}