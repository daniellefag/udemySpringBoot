package com.cursoudemy.cursomc.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cursoudemy.cursomc.domain.Endereco;

/**
 * @author daniellefag
 *
 */
@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

}
