package it.uniroma3.siw.project.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.project.model.Richiesta;

public interface RichiesteRepository extends CrudRepository<Richiesta, Long> {
	
	public Richiesta findByNominativo(String nominativo);
	public Richiesta findByTitoloFoto (String titoloFoto);
}


