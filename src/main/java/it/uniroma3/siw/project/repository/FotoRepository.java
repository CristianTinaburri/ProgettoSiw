package it.uniroma3.siw.project.repository;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.project.model.Foto;

public interface FotoRepository extends CrudRepository<Foto, Long> {
	
	public Foto findByTitoloFoto(String titoloFoto);
	public Foto findByTitoloAlbum(String titoloAlbum);
	public Foto findByFotografo(String fotografo);
}


