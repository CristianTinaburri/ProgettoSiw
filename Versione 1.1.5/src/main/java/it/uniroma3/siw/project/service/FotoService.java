package it.uniroma3.siw.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw.project.model.Foto;
import it.uniroma3.siw.project.repository.FotoRepository;

@Service
public class FotoService{

	@Autowired
	public FotoRepository fotoRepository;
	
	@Transactional
	public Foto inserisciFoto(Foto foto) {
		return fotoRepository.save(foto);
	}
	
	@Transactional
	public Foto fotoPerTitoloFoto(String titolo){
		return this.fotoRepository.findByTitoloFoto(titolo);
	}
	
	@Transactional
	public List<Foto> tuttiFoto(){
		return (List<Foto>)fotoRepository.findAll();
	}
	
	@Transactional
	public List<Foto> fotoPerTitoloAlbum(String titoloAlbum){
		return this.fotoRepository.findByTitoloAlbum(titoloAlbum);
	}
	
	@Transactional
	public List<Foto> fotoPerFotografo(String fotografo){
		return this.fotoRepository.findByFotografo(fotografo);
	}
	
	public boolean esistente(Foto foto) {
		Foto foto1 = this.fotoRepository.findByTitoloFoto(foto.getTitoloFoto());
		if (foto1!=null)
			return true;
		else 
			return false;
	}
	
}
