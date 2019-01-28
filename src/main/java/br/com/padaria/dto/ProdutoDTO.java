package br.com.padaria.dto;

import java.io.Serializable;

import br.com.padaria.domain.Caixa;

public class ProdutoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String nomeProduto;

	private Double valorProduto;

	private Integer quantidade;
	


	public ProdutoDTO() {

	}

	public ProdutoDTO(Long id, String nomeProduto, Double valorProduto, Integer quantidade) {
		super();
		this.id = id;
		this.nomeProduto = nomeProduto;
		this.valorProduto = valorProduto;
		this.quantidade = quantidade;
		
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public Double getValorProduto() {
		return valorProduto;
	}

	public void setValorProduto(Double valorProduto) {
		this.valorProduto = valorProduto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}



}
