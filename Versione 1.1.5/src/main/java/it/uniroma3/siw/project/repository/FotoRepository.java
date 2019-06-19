package it.uniroma3.siw.project.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.project.model.Foto;

public interface FotoRepository extends CrudRepository<Foto, Long> {
	
	public Foto findByTitoloFoto(String titoloFoto);
	public List<Foto> findByTitoloAlbum(String titoloAlbum);
	public List<Foto> findByFotografo(String fotografo);
}


