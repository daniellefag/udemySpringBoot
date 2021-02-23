/**
 * 
 */
package com.cursoudemy.cursomc.domain;

import javax.persistence.Entity;

import com.cursoudemy.cursomc.domain.enums.StatusPagamento;

/**
 * 
 *
 */
@Entity
public class PagamentoComCartao extends Pagamento {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer numeroParcelas;
	
	public PagamentoComCartao() {
		
	}

	/**
	 * @param idInteger
	 * @param statusPagamento
	 * @param pedido
	 */
	public PagamentoComCartao(Integer idInteger, StatusPagamento statusPagamento, Pedido pedido, Integer numeroParcelas) {
		super(idInteger, statusPagamento, pedido);
		this.numeroParcelas = numeroParcelas;
	}

	public Integer getNumeroParcelas() {
		return numeroParcelas;
	}

	public void setNumeroParcelas(Integer numeroParcelas) {
		this.numeroParcelas = numeroParcelas;
	}
	
	
	
	

}
