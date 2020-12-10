package fantasy.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PlayerScore {
	@Id
	public int player_id;
	public int wickets;
	public int catches;
	public int runs;
	public int points;
	public int match_id;
	public int getMatch_id() {
		return match_id;
	}
	public void setMatch_id(int match_id) {
		this.match_id = match_id;
	}
	public int getPlayer_id() {
		return player_id;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public void setPlayer_id(int player_id) {
		this.player_id = player_id;
	}
	public int getWickets() {
		return wickets;
	}
	public void setWickets(int wickets) {
		this.wickets = wickets;
	}
	public int getCatches() {
		return catches;
	}
	public void setCatches(int catches) {
		this.catches = catches;
	}
	public int getRuns() {
		return runs;
	}
	public void setRuns(int runs) {
		this.runs = runs;
	}

}
