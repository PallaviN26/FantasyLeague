package fantasy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import fantasy.model.User;
import fantasy.repo.UserRepo;

public class UserApi {
	@Autowired
	UserRepo  userRepo;
	@PostMapping("/user")
	public ResponseEntity<String> addUser(@RequestBody User user) {
		userRepo.insertWithQuery(user);
		return ResponseEntity.ok("Team added successfully");
	}
}
