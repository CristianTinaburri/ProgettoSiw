package it.uniroma3.siw.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw.project.model.Richieste;
import it.uniroma3.siw.project.repository.RichiesteRepository;

@Service
public class RichiestaService {
	
	@Autowired
	public RichiesteRepository richiesteRepository;
	
	@Transactional
	public Richieste inserisciRichieste(Richieste richiesta) {
		return richiesteRepository.save(richiesta);
	}
	
	@Transactional
	public List<Richieste> tuttiRichieste(){
		return (List<Richieste>)richiesteRepository.findAll();
	}
	
	@Transactional
	public Richieste richiestaPerNominativo(String nominativo){
		return this.richiesteRepository.findByNominativo(nominativo);
	}
	
	public boolean esistente(Richieste richiesta) {
		Richieste richiesta1 = this.richiesteRepository.findByNominativo(richiesta.getNominativo());
		if (richiesta1!=null)
			return true;
		else 
			return false;
	}	
}
