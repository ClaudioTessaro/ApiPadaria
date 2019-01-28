package br.com.padaria.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.padaria.domain.enums.TipoPagamento;

@Entity
public class Caixa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataEntrada;

	private Double valorTotal;

	@OneToMany
	@JoinColumn(name = "id_caixa")
	private List<Produto> produtos = new ArrayList<>();
	
	private Integer tipoPagamento;

	public Caixa() {

	}

	public Caixa(Long id, Date dataEntrada, Double valorTota) {
		super();
		this.id = id;
		this.dataEntrada = dataEntrada;
		this.valorTotal = valorTota;
	}

	public Caixa(Long id, Date dataEntrada, Double valorTotal, List<Produto> produtos, TipoPagamento tipoPagamento) {
		super();
		this.id = id;
		this.dataEntrada = dataEntrada;
		this.valorTotal = valorTotal;
		this.produtos = produtos;
		this.tipoPagamento = ((tipoPagamento == null)? null: tipoPagamento.getCod());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public void setValorTota(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Caixa other = (Caixa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Caixa [id=" + id + ", dataEntrada=" + dataEntrada + ", valorTota=" + valorTotal + ", produtos="
				+ produtos + "]";
	}

	public TipoPagamento getTipoPagamento() {
		return TipoPagamento.toEnum(tipoPagamento);
	}

	public void setTipoPagamento(TipoPagamento tipoPagamento) {
		this.tipoPagamento = tipoPagamento.getCod();
	}

}
