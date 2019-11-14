package it.uniroma3.siw.Silph.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;


import it.uniroma3.siw.Silph.model.Foto;
public interface FotoRepository extends CrudRepository<Foto, Long>{

	
	
	public List<Foto> findTop15ByOrderByIdDesc();
}
