package it.uniroma3.siw.project.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import it.uniroma3.siw.project.model.Album;
import it.uniroma3.siw.project.model.Foto;
import it.uniroma3.siw.project.model.Fotografo;
import it.uniroma3.siw.project.service.AlbumService;
import it.uniroma3.siw.project.service.FotoService;
import it.uniroma3.siw.project.service.FotografoService;

@Component
public class DBPopulation implements ApplicationRunner{
	
	@Autowired
	public FotografoRepository fotografoRepository;
	
	@Autowired
	public FotografoService fotografoService;
	
	@Autowired
	public AlbumService albumService;
	
	@Autowired
	public FotoService fotoService;
	
	@Autowired
	public AlbumRepository albumRepository;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		this.deleteAll();
		this.addAll();
	}
	
	private void deleteAll() {
			
	}
	
	private void addAll() {
		Fotografo ft1 = new Fotografo("Marcello", "Ponzi","marciodentro");
		Fotografo ft2 = new Fotografo("Francesco", "Zaccari","Uchebo Er Zaccoh");
		this.fotografoService.inserisciFotografo(ft1);
		this.fotografoService.inserisciFotografo(ft2);
		
		Album alb1 = new Album("Marcello", "Ponzi","marciodentro");
		Album alb2 = new Album("Francesco", "Zaccari","Uchebo Er Zaccoh");
		this.albumService.inserisciAlbum(alb1);
		this.albumService.inserisciAlbum(alb2);
		
		Foto foto1 = new Foto("Marcello", "Ponzi","marciodentro","https://picsum.photos/200?random=1");
		Foto foto2 = new Foto("Francesco", "Zaccari","Uchebo Er Zaccoh","https://picsum.photos/200?random=2");
		Foto foto3 = new Foto("Marcello", "Ponzi","marciodentro","https://picsum.photos/200?random=3");
		Foto foto4 = new Foto("Francesco", "Zaccari","Uchebo Er Zaccoh","https://picsum.photos/200?random=4");
		Foto foto5 = new Foto("Marcello", "Ponzi","marciodentro","https://picsum.photos/200?random=5");
		Foto foto6 = new Foto("Francesco", "Zaccari","Uchebo Er Zaccoh","https://picsum.photos/200?random=6");
		Foto foto7 = new Foto("Marcello", "Ponzi","marciodentro","https://picsum.photos/200?random=7");
		Foto foto8 = new Foto("Francesco", "Zaccari","Uchebo Er Zaccoh","https://picsum.photos/200?random=8");
		this.fotoService.inserisciFoto(foto1);
		this.fotoService.inserisciFoto(foto2);
		this.fotoService.inserisciFoto(foto3);
		this.fotoService.inserisciFoto(foto4);
		this.fotoService.inserisciFoto(foto5);
		this.fotoService.inserisciFoto(foto6);
		this.fotoService.inserisciFoto(foto7);
		this.fotoService.inserisciFoto(foto8);
	}

}



