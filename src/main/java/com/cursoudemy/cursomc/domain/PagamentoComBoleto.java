/**
 * 
 */
package com.cursoudemy.cursomc.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.cursoudemy.cursomc.domain.enums.StatusPagamento;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 
 *
 */
@Entity
public class PagamentoComBoleto extends Pagamento {
	
	
	private static final long serialVersionUID = 1L;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataVencimento;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataPagamento;
	
	public PagamentoComBoleto() {
		
	}

	/**
	 * @param idInteger
	 * @param statusPagamento
	 * @param pedido
	 */
	public PagamentoComBoleto(Integer idInteger, StatusPagamento statusPagamento, Pedido pedido, Date dataVencimento, Date dataPagamento) {
		super(idInteger, statusPagamento, pedido);
		this.dataPagamento = dataPagamento;
		this.dataVencimento = dataVencimento;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	
	
	

}
