package it.uniroma3.siw.project.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.project.controller.validator.AlbumValidator;
import it.uniroma3.siw.project.model.Album;
import it.uniroma3.siw.project.service.AlbumService;

@Controller
public class AlbumController {
	
	@Autowired
	public AlbumService albumService;
	
	@Autowired
	public AlbumValidator albumValidator;
	
	@RequestMapping("/addAlbum")
	public String addAlbum(Model model) {
		model.addAttribute("album", new Album());
	    return "/albumForm";
	   }
	/*
	@RequestMapping("/albumAdmin")
	public String albumList(Model model) {
		model.addAttribute("albums", new Album());
	    return "/albumListAdmin";
	}*/
	
	@RequestMapping(value = "/albumAdmin")
    public String showAlbumsAdmin(@Valid @ModelAttribute("album") Album album, Model model) {
		model.addAttribute("albums", this.albumService.tuttiAlbum());
        return "/albumListAdmin";
	}
	
	@RequestMapping(value = "/album", method = RequestMethod.GET)
    public String showAlbums(@Valid @ModelAttribute("album") Album album, Model model) {
		model.addAttribute("albums", this.albumService.tuttiAlbum());
        return "/albumList";
	}
	/*
	
	@RequestMapping(value = "/listaAlbum")
    public String showAlbums(@Valid @ModelAttribute("album") Album album, Model model) {
		model.addAttribute("albums", this.albumService.tuttiAlbum());
        return "/albumList";
	}
	*/
	@RequestMapping(value = "/album", method = RequestMethod.POST)
    public String newAlbum(@Valid @ModelAttribute("album") Album album, 
    									Model model, BindingResult bindingResult) {
		this.albumValidator.validate(album, bindingResult);
		 if (this.albumService.esistente(album)) {
	            model.addAttribute("exists", "l'album già esiste");
	            return "/albumForm";
	        }
		
		 else {
	            if (!bindingResult.hasErrors()) {
	                this.albumService.inserisciAlbum(album);
	                model.addAttribute("albums", this.albumService.tuttiAlbum());
	                return "/albumList";
	            }
	        }
	        return "/albumForm";
	}
	
	
    @RequestMapping(value = "/album/{titoloAlbum}", method = RequestMethod.GET)
    public String getAlbum(@PathVariable("titoloAlbum") String titoloAlbum, Model model) {
        model.addAttribute("album", this.albumService.albumPerTitolo(titoloAlbum));
    	return "/album";
    }
	
}
