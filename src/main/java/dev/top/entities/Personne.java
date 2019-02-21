package dev.top.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Personne {
	@Column
	private String matricule;
	@Column
	private String pseudo;
	@Column
	private String url;

	public Personne() {
		super();
	}

	public Personne(String matricule, String pseudo, String url) {
		super();
		this.matricule = matricule;
		this.pseudo = pseudo;
		this.url = url;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
