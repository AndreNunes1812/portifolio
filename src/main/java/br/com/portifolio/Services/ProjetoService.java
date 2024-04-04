package br.com.portifolio.Services;

import br.com.portifolio.Models.Mappers.ProjetoRowMapper;
import br.com.portifolio.Models.Projeto;
import br.com.portifolio.Repositories.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetoService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    ProjetoRepository projetoRepository;

    @Autowired
    public List<Projeto> getAllPprojetos() {
        return jdbcTemplate.query("SELECT * FROM projeto", new ProjetoRowMapper());
    }

    public void save(Projeto projeto) {
        projetoRepository.save(projeto);
    }

    public Optional<Projeto> getOneProjeto(Long id) {
        return projetoRepository.findById(id);
    }

    public boolean validGerente(Long id) { return projetoRepository.existsByGerencialId(id); }

    public void delete(Long id){ projetoRepository.deleteById(id); }
}
