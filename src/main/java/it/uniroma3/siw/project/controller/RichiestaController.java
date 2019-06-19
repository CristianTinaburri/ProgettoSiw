package it.uniroma3.siw.project.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.project.model.Richieste;
import it.uniroma3.siw.project.service.RichiestaService;

@Controller
public class RichiestaController {
	
	@Autowired
	RichiestaService richiestaService;
	
	@RequestMapping(value = "/invioRichiestaFoto", method = RequestMethod.POST)
	public String newAllievo(@Valid @ModelAttribute("richiesta") Richieste richiesta, Model model, BindingResult bindingResult) {
	    if (this.richiestaService.esistente(richiesta)) {
	        model.addAttribute("exists", "Il richiesta già esiste");
	        return "/index";
	    } else {
	        if (!bindingResult.hasErrors()) {
	            this.richiestaService.inserisciRichieste(richiesta);
	            model.addAttribute("richieste", this.richiestaService.tuttiRichieste());
	            return "/index";
	        }
	    }
	    return "/index";
	}
	
	@RequestMapping(value = "/richiestaAdmin", method = RequestMethod.GET)
    public String richiestaAdmin(Model model, @Valid @ModelAttribute("richieste") Richieste richieste) {
		model.addAttribute("richieste", richiestaService.tuttiRichieste());
		return "/richiestaAdmin";
	} //  new ArrayList<Richieste>()

}
