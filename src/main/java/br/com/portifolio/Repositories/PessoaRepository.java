package br.com.portifolio.Repositories;

import br.com.portifolio.Models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    List<Pessoa> findByGerenteTrue();

}
