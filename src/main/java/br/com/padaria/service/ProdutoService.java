package br.com.padaria.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.padaria.domain.Produto;
import br.com.padaria.dto.ProdutoDTO;
import br.com.padaria.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository repo;
	
	@Autowired
	CaixaService caixaService;
	
	

	public void insertProduto(ProdutoDTO objDTO) {
	
		Produto produto = fromProdutoDto(objDTO);
		

		repo.save(produto);
	}

	public Produto findById(Long id) {
		return repo.findById(id).get();
	}

	public List<Produto> findAll() {
		return repo.findAll();
	}

	public void delete(Long id) {
		repo.deleteById(id);
	}

	public void update(ProdutoDTO produtoDto) {
		findById(produtoDto.getId());
		Produto produto = fromProdutoDto(produtoDto);
		repo.save(produto);
	}
	
	public List<Produto> findListProdutos(List<Long> ids){
		List<Produto> produtos = new ArrayList<>();
		
		for (Long id : ids) {
			
			Produto produto = repo.findById(id).get();
			
			produtos.add(produto);
			
		}
		
		
		return produtos;
	}
		
	
	public Produto fromProdutoDto(ProdutoDTO objDto) {
		return new Produto(objDto.getId(),objDto.getNomeProduto(),objDto.getValorProduto(),objDto.getQuantidade());
	}

}
