package it.uniroma3.siw.Silph.service;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.Silph.model.Album;
import it.uniroma3.siw.Silph.repository.AlbumRepository;
@Service

public class AlbumService {

	@Autowired
	private AlbumRepository albumRepository;

	@Transactional
	public Album inserisci(Album a) {
		return this.albumRepository.save(a);
	}
	
	
	@Transactional	
	public List<Album> tuttiAlbum(){
		return (List<Album>) this.albumRepository.findAll();
	}
	
	@Transactional
	public Album albumPerID(Long id) {
		return this.albumRepository.findById(id).get();
	}
	
	@Transactional
	public List<Album> albumPerAuthorId(Long id){
		return (List<Album>) this.albumRepository.findByFotografoId(id);
	}
	
	
	@Transactional
	public void eliminaAlbum(Album a) {
		this.albumRepository.delete(a);
	}
	
	@Transactional
	public void eliminaTuttiAlbum(List<Album> listaAlbum) {
		this.albumRepository.deleteAll(listaAlbum);
	}
	
	public void eliminaAlbumPerID(Long id) {
		 this.albumRepository.deleteById(id);
	}

}
