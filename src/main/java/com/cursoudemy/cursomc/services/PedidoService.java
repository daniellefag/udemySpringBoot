
package com.cursoudemy.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cursoudemy.cursomc.domain.Pedido;
import com.cursoudemy.cursomc.repositories.PedidoRepository;
import com.cursoudemy.cursomc.services.exception.ObjectNotFoundException;

/**
 * @author daniellefag
 *
 */
@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repository;
	
	public Pedido buscar(Integer id) {
		Optional<Pedido> obj = repository.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}

}
