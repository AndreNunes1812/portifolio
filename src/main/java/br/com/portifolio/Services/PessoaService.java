package br.com.portifolio.Services;

import br.com.portifolio.Models.Mappers.PessoaRowMapper;
import br.com.portifolio.Models.Pessoa;
import br.com.portifolio.Repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    PessoaRepository pessoaRepository;

    @Autowired
    public List<Pessoa> getAllPessoas() {
        return pessoaRepository.findAll();
    }

    @Autowired
    public List<Pessoa> getAllPessoasGerentes() {
        return pessoaRepository.findByGerenteTrue();
    }

    @Autowired
    public List<Pessoa> getAllPessoasFuncionarios() {
        return pessoaRepository.findByFuncionarioIsTrue();
    }

    public void save(Pessoa pessoa) {
        pessoaRepository.save(pessoa);
    }

    public Optional<Pessoa> getOnePessoa(Long id) {
       return pessoaRepository.findById(id);
    }

    public void delete(Long id){ pessoaRepository.deleteById(id); }

}
