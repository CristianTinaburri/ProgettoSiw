package it.uniroma3.siw.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Richiesta {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nominativo;
	private String email;
	private String titoloFoto;
	private String messaggio;
	
	public Richiesta() {
		
	}
	
	public Richiesta(String nominativo, String email, String titoloFoto, String messaggio) {
		super();
		this.nominativo = nominativo;
		this.email = email;
		this.titoloFoto = titoloFoto;
		this.messaggio = messaggio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNominativo() {
		return nominativo;
	}

	public void setNominativo(String nominativo) {
		this.nominativo = nominativo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTitoloFoto() {
		return titoloFoto;
	}

	public void setTitoloFoto(String titoloFoto) {
		this.titoloFoto = titoloFoto;
	}

	public String getMessaggio() {
		return messaggio;
	}

	public void setMessaggio(String messaggio) {
		this.messaggio = messaggio;
	}		
}