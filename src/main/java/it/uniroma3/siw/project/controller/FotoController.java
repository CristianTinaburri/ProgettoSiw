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
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.siw.project.model.Foto;
import it.uniroma3.siw.project.service.FotoService;
import it.uniroma3.siw.project.controller.validator.FotoValidator;

@Controller
public class FotoController {
	
	@Autowired
	FotoService fotoService;
	
	@Autowired
	FotoValidator fotoValidator;
	
	
	@RequestMapping(value="/fotoAlbum/{titoloAlbum}", method = RequestMethod.GET)
	public String getFotoAlbum(@PathVariable("titoloAlbum") String titoloAlbum, Model model) {
		model.addAttribute("fotos", this.fotoService.fotoPerTitoloAlbum(titoloAlbum));
		return "/fotoList";
	}
	
	@RequestMapping(value="/fotoAlbumAdmin/{titoloAlbum}", method = RequestMethod.GET)
	public String getFotoAlbumAdmin(@PathVariable("titoloAlbum") String titoloAlbum, Model model) {
		model.addAttribute("fotos", this.fotoService.fotoPerTitoloAlbum(titoloAlbum));
		return "/fotoListAdmin";
	}
	
	
	@RequestMapping("/addFoto")
	public String addFoto(Model model) {
		model.addAttribute("foto", new Foto());
	    return "/fotoForm";
	    }

	@RequestMapping(value="/richiestaFoto", method = RequestMethod.GET)
	public String sceltaFoto(@Valid @RequestParam("titoloFoto") String titoloFoto, Model model) {
		model.addAttribute("titoloFoto", titoloFoto);
	    return "/richiesta";
	}
	@RequestMapping(value = "/foto", method = RequestMethod.POST)
    public String newFoto(@Valid @ModelAttribute("foto") Foto foto, 
    									Model model, BindingResult bindingResult) {
		this.fotoValidator.validate(foto, bindingResult);
		 if (this.fotoService.esistente(foto)) {
	            model.addAttribute("exists", "La foto già esiste");
	            return "/fotoForm";
	        }
		
		 else {
	            if (!bindingResult.hasErrors()) {
	                this.fotoService.inserisciFoto(foto);
	                model.addAttribute("fotos", this.fotoService.tuttiFoto());
	                return "/fotoListAdmin";
	            }
	        }
	        return "/fotoForm";
	}
		

	@RequestMapping(value = "/fotoAdmin", method = RequestMethod.GET)
    public String showfotosAdmin(@Valid @ModelAttribute("foto") Foto foto, Model model) {
		model.addAttribute("fotos", this.fotoService.tuttiFoto());
        return "/fotoListAdmin";
	}
	
	@RequestMapping(value = "/foto", method = RequestMethod.GET)
    public String showfotos(@Valid @ModelAttribute("foto") Foto foto, Model model) {
		model.addAttribute("fotos", this.fotoService.tuttiFoto());
        return "/fotoList";
	}
	
	
    @RequestMapping(value = "/foto/{titoloFoto}", method = RequestMethod.GET)
    public String getFoto(@PathVariable("titoloFoto") String titoloFoto, Model model) {
        model.addAttribute("foto", this.fotoService.fotoPerTitoloFoto(titoloFoto));
    	return "/foto";
    }  
}