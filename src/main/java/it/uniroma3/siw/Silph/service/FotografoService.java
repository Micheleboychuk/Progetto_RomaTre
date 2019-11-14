package it.uniroma3.siw.Silph.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.uniroma3.siw.Silph.model.Fotografo;
import it.uniroma3.siw.Silph.repository.FotografoRepository;

@Service
public class FotografoService {
	
	@Autowired
	private FotografoRepository fotografoRepository;

	
	@Transactional
	public Fotografo inserisciFotografo(Fotografo fotografo) {
		return this.fotografoRepository.save(fotografo);
	}
	
	
	@Transactional	
	public List<Fotografo> tuttiFotografi(){
		return (List<Fotografo>) this.fotografoRepository.findAll();
	}
	
	@Transactional
	public Fotografo fotografoPerID(Long id) {
		return this.fotografoRepository.findById(id).get();
	}
	
	@Transactional
	public void eliminaFotografo(Fotografo f) {
		this.fotografoRepository.delete(f);
	}
	
	@Transactional
	public void eliminaFotografoPerID(Long id) {
		this.fotografoRepository.deleteById(id);
	}
	
}
