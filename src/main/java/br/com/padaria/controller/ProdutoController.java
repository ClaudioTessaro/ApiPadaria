package br.com.padaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.padaria.domain.Produto;
import br.com.padaria.dto.ProdutoDTO;
import br.com.padaria.service.ProdutoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javassist.tools.rmi.ObjectNotFoundException;

@Api(value="Produto controller")
@Controller
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	ProdutoService service;

	@ApiOperation(value="Retorna um id")
	@GetMapping("{id}")
	public ResponseEntity<Produto> readById(@PathVariable Long id) {

		return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
	}

	@ApiOperation(value="Retorna uma lista ")
	@GetMapping
	public ResponseEntity<List<Produto>> readAll() {
		return new ResponseEntity<List<Produto>>(service.findAll(), HttpStatus.OK);

	}

	@ApiOperation(value="Salva o caixa")
	@PostMapping
	public ResponseEntity<Produto> save(@RequestBody ProdutoDTO produtoDto) {
		service.insertProduto(produtoDto);
		return new ResponseEntity<Produto>(HttpStatus.CREATED);
	}
	
	@ApiOperation(value="Atualiza informações do caixa")
	@PutMapping("{id}")
	public ResponseEntity<Produto> update(@PathVariable Long id, @RequestBody ProdutoDTO produtoDTO) throws ObjectNotFoundException{
		service.update(produtoDTO);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	@ApiOperation(value="Deleta o caixa")
	@DeleteMapping("{id}")
	public ResponseEntity<Produto> deleteById(@PathVariable Long id){
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
