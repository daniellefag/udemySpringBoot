package com.cursoudemy.cursomc.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cursoudemy.cursomc.domain.Produto;

/**
 * @author daniellefag
 *
 */
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
