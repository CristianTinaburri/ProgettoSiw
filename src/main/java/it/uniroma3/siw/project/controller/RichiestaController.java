package it.uniroma3.siw.project.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.project.model.Richiesta;
import it.uniroma3.siw.project.service.RichiestaService;

@Controller
public class RichiestaController {
	
	@Autowired
	RichiestaService richiestaService;
	
	@RequestMapping(value = "/invioRichiestaFoto", method = RequestMethod.POST)
	public String newRichiesta( @Valid @ModelAttribute("nominativo") String nominativo,
								@Valid @ModelAttribute("email") String email,
								@Valid @ModelAttribute("titoloFoto") String titoloFoto,
								@Valid @ModelAttribute("messaggio") String messaggio,
								Model model, 
								BindingResult bindingResult) {
		Richiesta richiesta = new Richiesta(nominativo, email, titoloFoto, messaggio);
		if (!bindingResult.hasErrors()) {
            this.richiestaService.inserisciRichieste(richiesta);
            return "/index";
        }
	    return "/index";
	}
	
	@RequestMapping(value = "/richiestaAdmin", method = RequestMethod.GET)
    public String richiestaAdmin(Model model) {
        model.addAttribute("richieste", this.richiestaService.tuttiRichieste()); // this.richiestaService.tuttiRichieste()
		return "/richiestaAdmin";
	}
}