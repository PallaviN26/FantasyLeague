package fantasy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import fantasy.model.UserFantasy;
import fantasy.repo.UserRepo;

@Controller
public class UserApi {
	@Autowired
	UserRepo  userRepo;
	@PostMapping("/user")
	public ResponseEntity<String> addUser(@RequestBody UserFantasy user) {
		 boolean val = userRepo.insertWithQuery(user);
		 if (val)
		return ResponseEntity.ok("User account created successfully");
		 else 
			 return ResponseEntity.ok("Acount exists");
	}
}
