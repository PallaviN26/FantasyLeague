package fantasy.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Team {
	@Id
	public String teamId;
	public String teamName;
	public String getTeamId() {
		return teamId;
	}
	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
}
