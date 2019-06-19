package it.uniroma3.siw.project.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String index(Model model,HttpSession session) {
		return "/index";
	}
	@RequestMapping("/login")
    public String login(Model model,HttpSession session) {
		return "/login";
	}
	@RequestMapping("/admin")
    public String adminDashboard(@Valid @ModelAttribute("username") String username, 
    					@Valid @ModelAttribute("username") String password, Model model,HttpSession session) {
		if(username.equals("admin") && password.equals("admin")) {
			return "/adminDashboard";
		}else {
			return "/login";
		}
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
