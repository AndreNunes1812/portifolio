package br.com.portifolio.Models.Mappers;

import br.com.portifolio.Models.Pessoa;
import br.com.portifolio.Models.Projeto;
import br.com.portifolio.Services.PessoaService;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class ProjetoRowMapper implements RowMapper<Projeto> {
    @Override
    public Projeto mapRow(ResultSet rs, int rowNum) throws SQLException {

        Projeto projeto = new Projeto();
        PessoaService pessoaService = new PessoaService();

        projeto.setId(rs.getLong("id"));
        projeto.setNome(rs.getString("nome"));
        projeto.setDescricao(rs.getString("descricao"));
        projeto.setStatus(rs.getString("status"));
        projeto.setDataFim(rs.getString("data_fim"));
        projeto.setDataInicio(rs.getString("data_inicio"));
        projeto.setRisco(rs.getString("risco"));
        projeto.setOrcamento(rs.getDouble("orcamento"));
        projeto.setDataPrevisaoFim(rs.getString("data_previsao_fim"));

/*
        Long idGerente = rs.getLong("idgerente");


        if (idGerente != null) {
            Optional<Pessoa> p =  pessoaService.getOnePessoa(idGerente);

            Pessoa pessoa = new Pessoa();
            pessoa.setGerente(p.get().isGerente());
            pessoa.setFuncionario(p.get().isGerente());
            pessoa.setCpf(p.get().getCpf());
            pessoa.setDataNascimento(p.get().getDataNascimento());
            pessoa.setId(p.get().getId());
            pessoa.setNome(p.get().getNome());
            projeto.setGerencial(pessoa);


        }
*/
        return projeto;
    }
}