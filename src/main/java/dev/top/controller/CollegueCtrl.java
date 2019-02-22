package dev.top.controller;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import dev.top.entities.Collegue;
import dev.top.entities.Personne;
import dev.top.repos.CollegueRepo;

@RestController()
@CrossOrigin
@RequestMapping("/collegues")
public class CollegueCtrl {

	@Autowired
	private CollegueRepo collegueRepo;
	
	@GetMapping
	public List<Collegue> findAll() {
		List<Collegue> listeCollegues = this.collegueRepo.findAll();
		listeCollegues.sort(Comparator.comparing(Collegue::getPseudo));
		//System.out.print(listeCollegues.get(0).getPhoto());
		return listeCollegues;
	}
		
	@PatchMapping(value = "{pseudo}")
	public Collegue updateScore(@PathVariable String pseudo, @RequestBody Map<String, String> action) {
		List<Collegue> collegues = findAll();

		for (Collegue c : collegues) {
			if (c.getPseudo().equals(pseudo)) {
				if (action.get("action").equals("AIMER")) {
					c.setScore(c.getScore() + 10);
				} else if (action.get("action").equals("DETESTER")) {
					c.setScore(c.getScore() - 5);
				}

				this.collegueRepo.save(c);
				return c;
			}

		}

		return null;
	}
	@PostMapping
	public void postCollegue(@RequestBody Map<String, String> action) {
		final String url = "https://tommy-sjava.cleverapps.io/collegues?matricule=" + action.get("matricule");
		RestTemplate restTemplate = new RestTemplate();
		Collegue[] listeCollegue = restTemplate.getForObject(url, Collegue[].class);
		
		
		if(listeCollegue.length == 0) {
			System.out.println("Erreur à retourner");
		} else {
			Collegue collegueTrouvee = listeCollegue[0]; 
			
			Collegue collegue = new Collegue(collegueTrouvee.getPseudo(), 0, collegueTrouvee.getPhotoUrl());
			System.out.println("Je crée bien un rappel");
			
			this.collegueRepo.save(collegue); //Enregistre le résultat du GetApi en BDD
			
		}
	}
}
