package it.uniroma3.siw.project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import it.uniroma3.siw.project.model.Album;
import it.uniroma3.siw.project.model.Foto;
import it.uniroma3.siw.project.model.Fotografo;
import it.uniroma3.siw.project.service.AlbumService;
import it.uniroma3.siw.project.service.FotoService;
import it.uniroma3.siw.project.service.FotografoService;

@Controller
public class ViewController {
	
	@Autowired
	FotografoService fotografoService;
	
	@Autowired
	AlbumService albumService;
	
	@Autowired
	FotoService fotoService;
		
	@RequestMapping("/index")
	public void dbInserter(HttpSession session) {
		Fotografo ft1 = new Fotografo("Marcello", "Ponzi","marciodentro");
		Fotografo ft2 = new Fotografo("Francesco", "Zaccari","Uchebo Er Zaccoh");
		this.fotografoService.inserisciFotografo(ft1);
		this.fotografoService.inserisciFotografo(ft2);
		
		Album alb1 = new Album("Marcello", "Ponzi","marciodentro");
		Album alb2 = new Album("Francesco", "Zaccari","Uchebo Er Zaccoh");
		this.albumService.inserisciAlbum(alb1);
		this.albumService.inserisciAlbum(alb2);
		
		Foto foto1 = new Foto("Marcello", "Ponzi","marciodentro","test");
		Foto foto2 = new Foto("Francesco", "Zaccari","Uchebo Er Zaccoh","test");
		this.fotoService.inserisciFoto(foto1);
		this.fotoService.inserisciFoto(foto2);
	}
	
	@RequestMapping("/login")
    public String login(Model model,HttpSession session) {
		return "/login";
	}
	@RequestMapping("/admin")
    public String adminDashboard(Model model,HttpSession session) {
		return "/adminDashboard";
	}
	@RequestMapping("/logout")
    public String logout(Model model,HttpSession session) {
		return "/index";
	}
}
