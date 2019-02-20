package dev.top.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.top.entities.Collegue;
import dev.top.repos.CollegueRepo;

@RestController()
@RequestMapping("/collegues")
public class CollegueCtrl {

    @Autowired
    private CollegueRepo collegueRepo;

    @GetMapping
    public List<Collegue> findAll() {
        return this.collegueRepo.findAll();
    }
    
    @PatchMapping(value= "{pseudo}")
    public void updateScore(@PathVariable String pseudo, @RequestBody Map<String, String> action) {
    	List<Collegue> collegues = findAll();
    	for(Collegue c : collegues) {
    		if(c.getPseudo().equals(pseudo)) {
    			if(action.get("action").equals("AIMER")) {
    				c.setScore(+1);
    			}else if(action.get("action").equals("DETESTER")) {
    				c.setScore(-1);
    			}this.collegueRepo.save(c); 
    			break;
    		}
    	
    		
    	}
    }
 
}
