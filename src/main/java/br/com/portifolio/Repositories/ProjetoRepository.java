package br.com.portifolio.Repositories;

import br.com.portifolio.Models.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {

  boolean existsByGerencialId(Long gerenteId);
  boolean existsById(Long idProjeo);

}
