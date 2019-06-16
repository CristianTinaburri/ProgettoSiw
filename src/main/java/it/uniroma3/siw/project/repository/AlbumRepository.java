package it.uniroma3.siw.project.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.project.model.Album;


public interface AlbumRepository extends CrudRepository<Album, Long> {
	
	public Album findByTitoloAlbum(String titolo);
	public List<Album> findByAutore(String autore);
}