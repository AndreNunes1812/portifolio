package br.com.portifolio.Repositories;

import br.com.portifolio.Models.Membro;
import br.com.portifolio.Models.MembroId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MembroRepository  extends JpaRepository<Membro, MembroId> {
    Optional<Membro> findByIdProjetoAndIdPessoa(Long idProjeto, Long idPessoa);
}
