package br.com.padaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.padaria.domain.Caixa;
import br.com.padaria.domain.Produto;
import br.com.padaria.dto.CaixaDTO;
import br.com.padaria.repositories.CaixaRepository;
import br.com.padaria.service.exception.ObjectNotFoundException;

@Service
public class CaixaService {

	@Autowired
	CaixaRepository repo;
	
	@Autowired
	ProdutoService produtoservice;
	


	public void insertCaixa(CaixaDTO objDTO) throws Exception {
		Caixa caixa = fromCaixaDto(objDTO);
		caixa.setValorTota(valorTotal(objDTO));
		if(objDTO.getTipoPagamento().getDescricao() == "A vista") {
			caixa.setTipoPagamento(objDTO.getTipoPagamento());
		}else if(objDTO.getTipoPagamento().getDescricao() == "Cartao"){
			caixa.setTipoPagamento(objDTO.getTipoPagamento());
		}
		caixa.getProdutos().addAll(produtoservice.findListProdutos(objDTO.getIdsProdutos()));
		repo.save(caixa);

	}

	public Caixa findById(Long id) {
		return repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto do Id:" + id + " não existe"));
		// Lançando exceção na forma de expressão lambida do java 9,
		// para caso não exista registrado o id procurado no endpoint na base de dados

	}

	public List<Caixa> findAll() {
		
		return repo.findAll();
	}

	public void delete(Long id) { // Da mesma forma do find, aqui é lançado uma exceção personalizada caso não
									// exista o id pesquisado no endpoint
		findById(id);
		try {
			repo.deleteById(id);
		} catch (ObjectNotFoundException e) {
			throw new ObjectNotFoundException("Objeto não existe");
		}
	}

	public void update(CaixaDTO caixaDto) throws Exception {
		Caixa caixa = new Caixa();
		caixa = findById(caixaDto.getId());
		caixa.setDataEntrada(caixaDto.getDataEntrada());
		caixa.setValorTota(valorTotal(caixaDto));
		caixa.getProdutos().addAll(produtoservice.findListProdutos(caixaDto.getIdsProdutos()));

		repo.save(caixa);

	}
	
	//Metodo responsavel por fazer a operação para fornecimento do valor total da compra
	public Double valorTotal(CaixaDTO caixaDto) throws Exception {
		
		Double valorTotal = 0.0;
		
		try {
		List<Produto> produtos = produtoservice.findListProdutos(caixaDto.getIdsProdutos());
		
		for(Produto produto: produtos) {
			valorTotal += produto.getValorProduto()*produto.getQuantidade();
		}
		
		return valorTotal;
		}catch(Exception e) {
			throw new Exception("Por favor, verifique se o campo quantidade/preco esta preenchido");
		}
	}
	
	public Caixa fromCaixaDto(CaixaDTO objDto) {
		return new Caixa(objDto.getId(), objDto.getDataEntrada(), null);
	}
	


}
