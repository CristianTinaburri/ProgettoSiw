package it.uniroma3.siw.project.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;


import it.uniroma3.siw.project.model.Fotografo;
import it.uniroma3.siw.project.service.FotografoService;

public class DBPopulation implements ApplicationRunner{
	
	@Autowired
	public FotografoRepository fotografoRepository;
	
	@Autowired
	public FotografoService fotografoService;
	
	@Autowired
	public AlbumRepository albumRepository;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		this.deleteAll();
		this.addAll();
	}
	
private void deleteAll() {
		
	}
	//non funziona, ho messo lo stesso codice nel controller e funziona
	private void addAll() {
		Fotografo ft1 = new Fotografo("Marcello", "Ponzi","marciodentro");
		Fotografo ft2 = new Fotografo("Francesco", "Zaccari","Uchebo Er Zaccoh");
		this.fotografoService.inserisciFotografo(ft1);
		this.fotografoService.inserisciFotografo(ft2);
	} 
	

}



