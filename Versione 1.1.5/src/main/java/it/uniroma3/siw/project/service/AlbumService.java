package it.uniroma3.siw.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw.project.model.Album;
import it.uniroma3.siw.project.repository.AlbumRepository;

@Service
public class AlbumService {
	
	@Autowired
	public AlbumRepository albumRepository;
	
	@Transactional
	public Album inserisciAlbum(Album album) {
		return albumRepository.save(album);
	}
	
	@Transactional
	public Album albumPerTitolo(String titolo){
		return this.albumRepository.findByTitoloAlbum(titolo);
	}
	
	@Transactional
	public List<Album> tuttiAlbum(){
		return (List<Album>)albumRepository.findAll();
	}
	
	@Transactional
	public List <Album> albumPerAutore(String autore){
		return this.albumRepository.findByAutore(autore);
	}
	
	public boolean esistente(Album album) {
		Album album1 = this.albumRepository.findByTitoloAlbum(album.getTitoloAlbum());
		if (album1!=null)
			return true;
		else 
			return false;
	}	
}
