package dev.top;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import dev.top.entities.Collegue;
import dev.top.repos.CollegueRepo;

@Component
public class StartupDataInit {

    @Autowired
    CollegueRepo collegueRepo;

    @EventListener(ContextRefreshedEvent.class)
    public void init() {
    	
    	this.collegueRepo.save(new Collegue("Son-Goku", 0, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTgQXkpoa32cbVTHomv9EpVjU5jA7P4AVjagnJ8P9DR0yFw7R9Hzw"));
    	this.collegueRepo.save(new Collegue("Killua", 0, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRPWoTh2b1gCOIXYNHckWEAOjW1vcITvoRStnxTL4VvSJfwFp-a"));
    	this.collegueRepo.save(new Collegue("Freeza", 0, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS0QxfYdbUMs-bB_eeEEj-G71_MLbvnKXUMqKzHXZj58njmPke8pw"));
    	this.collegueRepo.save(new Collegue("Rukia", 0, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQiknxBAvOz0PA-X8VL5cVVGm2mplPuPP97YOtMpkPqRlWMlPg3"));
    	this.collegueRepo.save(new Collegue("Saitama", 0, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTYf4Fz8TQCqwE4rKfRo8aQCiO45gf6of1oDgbSWHvkN737qAWZ"));
    	this.collegueRepo.save(new Collegue("Snoopy", 0, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcREo6XzHSp5EfreVqFK8RD009Hf494jbZ0w2c8BR7TDiLrgJ5bx"));
    	this.collegueRepo.save(new Collegue("Tony Tony Chopper", 0, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS3Tjf3Gci9pA1W54ohpRVPxWVa0iPl3oGCsE62eu_GVpkkV6qt"));



    }
}
