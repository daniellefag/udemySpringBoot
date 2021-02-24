
package com.cursoudemy.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursoudemy.cursomc.domain.Categoria;
import com.cursoudemy.cursomc.repositories.CategoriaRepository;
import com.cursoudemy.cursomc.services.exception.ObjectNotFoundException;

/**
 * @author daniellefag
 *
 */
@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repository;
	
	public Categoria find(Integer id) {
		Optional<Categoria> categoria = repository.findById(id);
		return categoria.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}

	public Categoria insert (Categoria categoria) {
		categoria.setId(null);
		return repository.save(categoria);
	}
	
	public Categoria update (Categoria categoria) {
		find(categoria.getId());
		return repository.save(categoria);
	}
}
