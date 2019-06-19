package it.uniroma3.siw.project.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import it.uniroma3.siw.project.model.Album;
import it.uniroma3.siw.project.model.Foto;
import it.uniroma3.siw.project.model.Fotografo;
import it.uniroma3.siw.project.model.Richieste;
import it.uniroma3.siw.project.service.AlbumService;
import it.uniroma3.siw.project.service.FotoService;
import it.uniroma3.siw.project.service.FotografoService;
import it.uniroma3.siw.project.service.RichiestaService;

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
	
	@Autowired
	public RichiestaService richiestaService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		this.deleteAll();
		this.addAll();
	}
	
	private void deleteAll() {
			
	}
	
	private void addAll() {
		Fotografo ft1 = new Fotografo("Cristian", "Tinaburri", "CriTin");
		Fotografo ft2 = new Fotografo("Giorgia", "Nesci", "GioNes");
		Fotografo ft3 = new Fotografo("Massimiliano", "Patrizi", "MasPat");
		this.fotografoService.inserisciFotografo(ft1);
		this.fotografoService.inserisciFotografo(ft2);
		this.fotografoService.inserisciFotografo(ft3);
		
		Album alb1 = new Album("Album CT", "CriTin", "Oggi");
		Album alb2 = new Album("Album GN", "GioNes", "Domani");
		Album alb3 = new Album("Album MP", "MasPat", "Ieri");
		this.albumService.inserisciAlbum(alb1);
		this.albumService.inserisciAlbum(alb2);
		this.albumService.inserisciAlbum(alb3);
		
		Richieste r1 = new Richieste("Marcello", "Ponzi","marciodentro", "asd");
		Richieste r2 = new Richieste("asd", "asd","marciodentro", "asd");
		Richieste r3 = new Richieste("asd", "Ponzi","sdsd", "asd");
		this.richiestaService.inserisciRichieste(r1);
		this.richiestaService.inserisciRichieste(r2);
		this.richiestaService.inserisciRichieste(r3);
		
		Foto foto1 = new Foto("Foto 1", "Album CT","CriTin","https://picsum.photos/200?random=1");
		Foto foto2 = new Foto("Foto 2", "Album CT","CriTin","https://picsum.photos/200?random=2");
		Foto foto3 = new Foto("Foto 3", "Album CT","CriTin","https://picsum.photos/200?random=3");
		Foto foto4 = new Foto("Foto 4", "Album GN","GioNes","https://picsum.photos/200?random=4");
		Foto foto5 = new Foto("Foto 5", "Album GN","GioNes","https://picsum.photos/200?random=5");
		Foto foto6 = new Foto("Foto 6", "Album GN","GioNes","https://picsum.photos/200?random=6");
		Foto foto7 = new Foto("Foto 7", "Album MP","MasPat","https://picsum.photos/200?random=7");
		Foto foto8 = new Foto("Foto 8", "Album MP","MasPat","https://picsum.photos/200?random=8");
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



