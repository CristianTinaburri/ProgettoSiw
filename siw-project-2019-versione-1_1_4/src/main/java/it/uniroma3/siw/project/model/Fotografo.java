package it.uniroma3.siw.project.model;


import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Fotografo {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long Id;
	private String nome;
	private String cognome;
	private String nomeArte;
	
	public Fotografo() {	
	}
	
	public Fotografo(String nome, String cognome, String nomeArte) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.nomeArte = nomeArte;
	}
	
	
	public Long getId() {
		return Id;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNomeArte() {
		return nomeArte;
	}
	public void setNomeArte(String nomeArte) {
		this.nomeArte = nomeArte;
	}

	
	
}