package fantasy.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import fantasy.model.PlayerList;

@Component
@Repository
public class PlayerListRepo {
	@PersistenceContext
	private EntityManager entityManager;

	public List<PlayerList> fetchPlayers1(String teamId) {
		@SuppressWarnings("unchecked")
		List<PlayerList> player = (List<PlayerList>) entityManager
				.createNativeQuery("SELECT * FROM playerlist  where team_id = ?", PlayerList.class)
				.setParameter(1, teamId).getResultList();
		return player;
	}

	public int PlayerID(String player_name) {
		int player = (Integer) entityManager
				.createNativeQuery("Select player_id from player where player_name like '%?%'", String.class)
				.setParameter(1, player_name).executeUpdate();
		return player;
	}

	public List<PlayerList> fetchPlayers(String match_id) {

		@SuppressWarnings("unchecked")
		List<PlayerList> players = (List<PlayerList>) entityManager.createNativeQuery(
				"SELECT * FROM player_list  where team_id IN ((Select first_id from match where match_id =?) UNION (Select second_id from match where match_id =?))",
				PlayerList.class).setParameter(1, match_id).setParameter(2, match_id).getResultList();

		return players;
	}

	@Transactional
	public void insertWithQuery(List<PlayerList> playerList) {
		for (PlayerList player : playerList) {
			entityManager
					.createNativeQuery(
							"INSERT INTO player_list (player_id, player_name,team_id,category) VALUES (?,?,?,?)")
					.setParameter(1, player.getPlayerId()).setParameter(2, player.getPlayerName())
					.setParameter(3, player.getTeamId()).setParameter(4, player.getCategory()).executeUpdate();
		}
	}
}
