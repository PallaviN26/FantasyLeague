package fantasy.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fantasy.model.MatchContainer;
import fantasy.repo.MatchRepo;
 
@Controller
public class IndexController {
 
//    @GetMapping("/")
//    public ResponseEntity<String> home() {
//        //model.put("message", "HowToDoInJava Reader !!");
//        return ResponseEntity.ok("Team added successfully");
//    }
	@Autowired
	MatchRepo matchrepo;
	
    @GetMapping("/")
    public String home(Map<String, Object> model) {
    	MatchContainer con = new MatchContainer();
    	con.setMatchList(matchrepo.fetchMatches());
        model.put("message", con);
        return "index";
    }
     
    @RequestMapping("/next")
    public String next(Map<String, Object> model) {
        model.put("message", "You are in new page !!");
        return "next";
    }
 
}
