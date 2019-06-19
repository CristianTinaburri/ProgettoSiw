package it.uniroma3.siw.project.repository;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.project.model.Richieste;

public interface RichiesteRepository extends CrudRepository<Richieste, Long> {
	
	public Richieste findByNominativo(String nominativo);
	public Richieste findByTitoloFoto (String titoloFoto);
	
}


