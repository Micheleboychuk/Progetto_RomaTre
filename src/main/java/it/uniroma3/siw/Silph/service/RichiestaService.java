package it.uniroma3.siw.Silph.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.Silph.model.Richiesta;
import it.uniroma3.siw.Silph.repository.RichiestaRepository;

@Service
public class RichiestaService {
	
	@Autowired
	private RichiestaRepository richiestaRepository;

	@Transactional
	public Richiesta save(Richiesta r) {
			return this.richiestaRepository.save(r);
	}
	
	
	@Transactional 
	public List<Richiesta> tutteRichieste() {
		return (List<Richiesta>) this.richiestaRepository.findAll();
	}
	
	
}
