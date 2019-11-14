package it.uniroma3.siw.Silph.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.Silph.model.Foto;

import it.uniroma3.siw.Silph.repository.FotoRepository;

@Service
public class FotoService {
	
	@Autowired
	private FotoRepository fotoRepository;

	
	public Foto salva(Foto foto)
	{
		return this.fotoRepository.save(foto);
	}
	
	public List<Foto> tutti(){
		return (List<Foto>) this.fotoRepository.findAll();
	}
	
	@Transactional
	public void eliminaFoto(Foto foto) {
		this.fotoRepository.delete(foto);
	}
	
	@Transactional
	public void eliminaTutteFoto(List<Foto> fotoAlbum) {
		this.fotoRepository.deleteAll(fotoAlbum);
	}
	@Transactional
	public List<Foto> ultimi15(){
		return this.fotoRepository.findTop15ByOrderByIdDesc();
	}
}
