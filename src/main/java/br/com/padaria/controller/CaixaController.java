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

import br.com.padaria.domain.Caixa;
import br.com.padaria.dto.CaixaDTO;
import br.com.padaria.service.CaixaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javassist.tools.rmi.ObjectNotFoundException;

@Api(value="Controller Caixa")
@Controller
@RequestMapping("/caixa")
public class CaixaController {

	@Autowired
	CaixaService service;
	
	@ApiOperation(value="Retorna um id")
	@GetMapping("{id}")
	public ResponseEntity<Caixa> readById(@PathVariable Long id) {

		return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
	}
	@ApiOperation(value="Retorna uma lista ")
	@GetMapping
	public ResponseEntity<List<Caixa>> readAll() {
		return new ResponseEntity<List<Caixa>>(service.findAll(), HttpStatus.OK);

	}
	@ApiOperation(value="Salva o caixa")
	@PostMapping
	public ResponseEntity<Caixa> save(@RequestBody CaixaDTO caixaDto) throws Exception {
		service.insertCaixa(caixaDto);
		return new ResponseEntity<Caixa>(HttpStatus.CREATED);
	}
	@ApiOperation(value="Atualiza informações do caixa")
	@PutMapping("{id}")
	public ResponseEntity<Caixa> update(@PathVariable Long id, @RequestBody CaixaDTO caixaDTO) throws Exception{
		service.update(caixaDTO);
		return new ResponseEntity<Caixa>(HttpStatus.OK);
		
	}
	@ApiOperation(value="Deleta o caixa")
	@DeleteMapping("{id}")
	public ResponseEntity<Caixa> deleteById(@PathVariable Long id){
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
