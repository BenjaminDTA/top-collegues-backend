package dev.top.entities;


public class Personne {
	
	private String matricule;
	
	private String pseudo;
	
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
