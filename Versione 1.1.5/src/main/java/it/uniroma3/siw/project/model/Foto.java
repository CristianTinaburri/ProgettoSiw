package it.uniroma3.siw.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Foto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String titoloFoto;
	private String titoloAlbum;
	private String fotografo;
	private String uri;
	
	public Foto() {
		
	}
	
	public Foto(String titoloFoto, String titoloAlbum, String fotografo, String uri) {
		super();
		this.titoloFoto = titoloFoto;
		this.titoloAlbum = titoloAlbum;
		this.fotografo = fotografo;
		this.uri = uri;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitoloFoto() {
		return titoloFoto;
	}
	public void setTitoloFoto(String titoloFoto) {
		this.titoloFoto = titoloFoto;
	}
	public String getTitoloAlbum() {
		return titoloAlbum;
	}
	public void setTitoloAlbum(String titoloAlbum) {
		this.titoloAlbum = titoloAlbum;
	}
	public String getFotografo() {
		return fotografo;
	}
	public void setFotografo(String fotografo) {
		this.fotografo = fotografo;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	
}
