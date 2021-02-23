package com.cursoudemy.cursomc.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cursoudemy.cursomc.domain.Pedido;

/**
 * @author daniellefag
 *
 */
@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
