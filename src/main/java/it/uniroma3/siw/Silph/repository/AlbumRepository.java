package it.uniroma3.siw.Silph.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.Silph.model.Album;

public interface AlbumRepository extends CrudRepository<Album, Long>{
	
	public List<Album> findByFotografoId(Long id);
	
	
}
