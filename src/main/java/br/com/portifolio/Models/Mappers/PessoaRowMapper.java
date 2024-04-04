package br.com.portifolio.Models.Mappers;

import br.com.portifolio.Models.Pessoa;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PessoaRowMapper implements RowMapper<Pessoa> {
    @Override
    public Pessoa mapRow(ResultSet rs, int rowNum) throws SQLException {
        Pessoa pessoa = new Pessoa();

        pessoa.setId(rs.getLong("id"));
        pessoa.setNome(rs.getString("nome"));
        pessoa.setCpf(rs.getString("cpf"));
        pessoa.setFuncionario(rs.getBoolean("funcionario"));
        pessoa.setGerente(rs.getBoolean("gerente"));
        pessoa.setDataNascimento(rs.getString("datanascimento"));


        return pessoa;
    }
}