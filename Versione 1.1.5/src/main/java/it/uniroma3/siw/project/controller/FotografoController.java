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

import it.uniroma3.siw.project.model.Fotografo;
import it.uniroma3.siw.project.service.AlbumService;
import it.uniroma3.siw.project.service.FotografoService;
import it.uniroma3.siw.project.controller.validator.FotografoValidator;

@Controller
public class FotografoController {
	
	@Autowired
	FotografoService fotografoService;
	
	@Autowired
	AlbumService albumservice;
	
	@Autowired
	FotografoValidator fotografoValidator;
	
	@RequestMapping("/homepage")
    public String homepage(Model model,HttpSession session) {
		return "/homepage";
	}
	
	@RequestMapping("/addFotografo")
	public String addFotografo(Model model) {
		model.addAttribute("fotografo", new Fotografo());
	    return "/fotografoForm";
	    }
	
	@RequestMapping("/fotografiAdmin")
	public String fotografoList(Model model) {
		model.addAttribute("fotografi", this.fotografoService.tuttiFotografi());
	    return "/fotografiListAdmin";
	}
	
	
	@RequestMapping(value = "/fotografo", method = RequestMethod.POST)
    public String newAllievo(@Valid @ModelAttribute("fotografo") Fotografo fotografo, 
    									Model model, BindingResult bindingResult) {
		this.fotografoValidator.validate(fotografo, bindingResult);
		 if (this.fotografoService.esistente(fotografo)) {
	            model.addAttribute("exists", "Il fotografo già esiste");
	            return "fotografoForm";
	        }
		
		 else {
	            if (!bindingResult.hasErrors()) {
	                this.fotografoService.inserisciFotografo(fotografo);
	                model.addAttribute("fotografi", this.fotografoService.tuttiFotografi());
	                return "/fotografiList";
	            }
	        }
	        return "/fotografoForm";
	}
		
	
	@RequestMapping(value = "/fotografo", method = RequestMethod.GET)
    public String showFotografi(@Valid @ModelAttribute("fotografo") Fotografo fotografo, Model model) {
		model.addAttribute("fotografi", this.fotografoService.tuttiFotografi());
        return "/fotografiList";
	}
	
	
    @RequestMapping(value = "/fotografo/{nomeArte}", method = RequestMethod.GET)
    public String getFotografo(@PathVariable("nomeArte") String nomeArte, Model model) {
        model.addAttribute("fotografo", this.fotografoService.fotografoPerNomeArte(nomeArte));
    	return "/fotografo";
    }
    
    
}
