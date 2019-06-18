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
	@RequestMapping("/richiesta")
    public String richiesta(Model model,HttpSession session) {
		return "/richiesta";
	}
}
