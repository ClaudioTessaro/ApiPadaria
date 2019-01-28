package br.com.padaria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.padaria.domain.Caixa;

@Repository
public interface CaixaRepository extends JpaRepository<Caixa, Long>{

}
