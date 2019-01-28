package br.com.padaria.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.padaria.domain.enums.TipoPagamento;

public class CaixaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private Date dataEntrada;

	private Double valorTotal;
	
	private List<Long> idsProdutos = new ArrayList<>();
	
	private Integer tipoPagamento;

	public CaixaDTO() {

	}

	public CaixaDTO(Long id, Date dataEntrada, Double valorTotal) {
		super();
		this.id = id;
		this.dataEntrada = dataEntrada;
		this.valorTotal = valorTotal;
	}
	
	

	public CaixaDTO(Long id, Date dataEntrada, Double valorTotal, List<Long> idsProdutos, TipoPagamento tipoPagamento) {
		super();
		this.id = id;
		this.dataEntrada = dataEntrada;
		this.valorTotal = valorTotal;
		this.idsProdutos = idsProdutos;
		this.tipoPagamento = ((tipoPagamento == null)? null: tipoPagamento.getCod());
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Long> getIdsProdutos() {
		return idsProdutos;
	}

	public void setIdsProdutos(List<Long> idsProdutos) {
		this.idsProdutos = idsProdutos;
	}

	public TipoPagamento getTipoPagamento() {
		return TipoPagamento.toEnum(tipoPagamento);
	}

	public void setTipoPagamento(TipoPagamento tipoPagamento) {
		this.tipoPagamento = tipoPagamento.getCod();
	}
}
