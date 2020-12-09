package fantasy.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Match {
	@Id
	public String matchId;
	public String venue;
	public String firstId;
	public String secondId;
	//public Date matchDate;
	public String getMatchId() {
		return matchId;
	}
	public void setMatchId(String matchId) {
		this.matchId = matchId;
	}
	
	public String getFirstId() {
		return firstId;
	}
	public void setFirstId(String firstId) {
		this.firstId = firstId;
	}
	public String getSecondId() {
		return secondId;
	}
	public void setSecondId(String secondId) {
		this.secondId = secondId;
	}
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
//	public Date getMatchDate() {
//		return matchDate;
//	}
//	public void setMatchDate(Date matchDate) {
//		this.matchDate = matchDate;
//	}
}
