package it.uniroma3.siw.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Album {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String titoloAlbum;
	private String autore;
	private String data;
	
	public Album() {
		
	}
	
	public Album(String titoloAlbum, String autore, String data) {
		super();
		this.titoloAlbum = titoloAlbum;
		this.autore = autore;
		this.data = data;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitoloAlbum() {
		return titoloAlbum;
	}
	public void setTitoloAlbum(String titoloalbum) {
		this.titoloAlbum = titoloalbum;
	}
	public String getautore() {
		return autore;
	}
	public void setAutore(String autore) {
		this.autore = autore;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
}