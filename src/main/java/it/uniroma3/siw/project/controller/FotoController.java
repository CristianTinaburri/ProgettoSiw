package it.uniroma3.siw.project.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.project.model.Album;
import it.uniroma3.siw.project.model.Foto;
import it.uniroma3.siw.project.model.Fotografo;
import it.uniroma3.siw.project.service.FotoService;
import it.uniroma3.siw.project.controller.validator.FotoValidator;

@Controller
public class FotoController {
	
	@Autowired
	FotoService fotoService;
	
	@Autowired
	FotoValidator fotoValidator;
	
	@RequestMapping("/addFoto")
	public String addFoto(Model model) {
		model.addAttribute("foto", new Foto());
	    return "/fotoForm";
	    }
	
	@RequestMapping("/fotoAdmin")
	public String fotografoList(Model model) {
		model.addAttribute("foto", new Fotografo());
	    return "/fotoListAdmin";
	}
	
	@RequestMapping(value = "/foto", method = RequestMethod.POST)
    public String newAllievo(@Valid @ModelAttribute("foto") Foto foto, 
    									Model model, BindingResult bindingResult) {
		this.fotoValidator.validate(foto, bindingResult);
		 if (this.fotoService.esistente(foto)) {
	            model.addAttribute("exists", "La foto già esiste");
	            return "/fotoForm";
	        }
		
		 else {
	            if (!bindingResult.hasErrors()) {
	                this.fotoService.inserisciFoto(foto);
	                model.addAttribute("foto", this.fotoService.tuttiFoto());
	                return "/fotoList";
	            }
	        }
	        return "/fotoForm";
	}
		
	
	@RequestMapping(value = "/foto", method = RequestMethod.GET)
    public String showfotos(@Valid @ModelAttribute("foto") Foto foto, Model model) {
		model.addAttribute("fotografi", this.fotoService.tuttiFoto());
        return "/fotoList";
	}
	
	
    @RequestMapping(value = "/foto/{titoloFoto}", method = RequestMethod.GET)
    public String getFoto(@PathVariable("titoloFoto") String titoloFoto, Model model) {
        model.addAttribute("foto", this.fotoService.fotoPerTitoloFoto(titoloFoto));
    	return "/foto";
    }
    
    
}
