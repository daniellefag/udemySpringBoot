
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
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repository.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}

}
