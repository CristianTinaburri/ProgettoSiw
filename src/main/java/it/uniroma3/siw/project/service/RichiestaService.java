package it.uniroma3.siw.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw.project.model.Richiesta;
import it.uniroma3.siw.project.repository.RichiesteRepository;

@Service
public class RichiestaService {
	
	@Autowired
	public RichiesteRepository richiesteRepository;
	
	@Transactional
	public Richiesta inserisciRichieste(Richiesta richiesta) {
		return richiesteRepository.save(richiesta);
	}
	
	@Transactional
	public void cancellaRichiesta(Richiesta richiesta) {
		richiesteRepository.delete(richiesta);
	}
	
	
	@Transactional
	public List<Richiesta> tuttiRichieste(){
		return (List<Richiesta>)richiesteRepository.findAll();
	}
	
	@Transactional
	public Richiesta richiestaPerNominativo(String nominativo){
		return this.richiesteRepository.findByNominativo(nominativo);
	}
	
	public boolean esistente(Richiesta richiesta) {
		Richiesta richiesta1 = this.richiesteRepository.findByNominativo(richiesta.getNominativo());
		if (richiesta1!=null)
			return true;
		else 
			return false;
	}
}