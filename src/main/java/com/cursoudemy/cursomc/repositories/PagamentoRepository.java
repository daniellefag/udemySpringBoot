package com.cursoudemy.cursomc.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cursoudemy.cursomc.domain.Pagamento;

/**
 * @author daniellefag
 *
 */
@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {

}
