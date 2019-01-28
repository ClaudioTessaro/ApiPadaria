package br.com.padaria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.padaria.domain.Produto;

@Repository
public interface ProdutoRepository  extends JpaRepository<Produto, Long>{

}
