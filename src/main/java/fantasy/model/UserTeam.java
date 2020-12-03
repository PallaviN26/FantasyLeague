package fantasy.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserTeam {
	@Id
	public int user_team_id;
	public int user_id;
	public int game_id;
	public int points;
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getUser_team_id() {
		return user_team_id;
	}
	public void setUser_team_id(int user_team_id) {
		this.user_team_id = user_team_id;
	}
	public int getGame_id() {
		return game_id;
	}
	public void setGame_id(int game_id) {
		this.game_id = game_id;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	
}