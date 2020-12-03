package fantasy.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Match {
	@Id
	public int match_id;
	public String team1_id;
	public String team2_id;
	//public int image_id;
	public String venue;
	public Date matchDate;
	public int getMatch_id() {
		return match_id;
	}
	public void setMatch_id(int match_id) {
		this.match_id = match_id;
	}
	public String getTeam1_id() {
		return team1_id;
	}
	public void setTeam1_id(String team1_id) {
		this.team1_id = team1_id;
	}
	public String getTeam2_id() {
		return team2_id;
	}
	public void setTeam2_id(String team2_id) {
		this.team2_id = team2_id;
	}
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	public Date getMatchDate() {
		return matchDate;
	}
	public void setMatchDate(Date matchDate) {
		this.matchDate = matchDate;
	}
	
	
}
