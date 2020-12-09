package fantasy.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import fantasy.model.UserFantasy;
@Service
public class UserService {
Map<Integer, UserFantasy > map = new HashMap<Integer, UserFantasy>();
	
	public UserFantasy fetchUser(int user_id) {
		return map.get(user_id);
	}
	
	public void addTeam(UserFantasy user) {
		map.put(user.getUserId(), user);
	}

}