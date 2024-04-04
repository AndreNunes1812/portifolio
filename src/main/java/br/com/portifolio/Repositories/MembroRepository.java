package br.com.portifolio.Repositories;

import br.com.portifolio.Models.Membro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembroRepository  extends JpaRepository<Membro, Long> {}
