package it.uniroma3.siw.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw.project.model.Fotografo;
import it.uniroma3.siw.project.repository.FotografoRepository;


@Service
public class FotografoService {
	
	@Autowired 
	private FotografoRepository fotografoRepository;
	
	@Transactional 
	public Fotografo inserisciFotografo(Fotografo fotografo) {
		return fotografoRepository.save(fotografo);
	}
	
	@Transactional
	public List<Fotografo> tuttiFotografi(){
		return (List<Fotografo>) fotografoRepository.findAll();
	}
	@Transactional
	public Fotografo fotografoPerId(Long id) {
		return this.fotografoRepository.findById(id).get();
	}
	
	@Transactional
	public List <Fotografo> fotografoPerNome(String nome) {
		return this.fotografoRepository.findByNome(nome);
	}
   
	@Transactional
	public Fotografo fotografoPerNomeArte(String nomeArte) {
		return this.fotografoRepository.findByNomeArte(nomeArte);
	}
	
	public boolean esistente(Fotografo fotografo) {
		List<Fotografo> fotografi = this.fotografoRepository.findByNome(fotografo.getNome());
		if (fotografi.size() > 0)
			return true;
		else 
			return false;
	}	
	
}

