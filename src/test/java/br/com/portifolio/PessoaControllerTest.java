package br.com.portifolio;

import br.com.portifolio.Controllers.PessoaController;
import br.com.portifolio.Models.Pessoa;
import br.com.portifolio.Services.PessoaService;
import br.com.portifolio.Services.ProjetoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class PessoaControllerTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @Mock
    private PessoaService pessoaService;

    @Mock
    private ProjetoService projetoService;

    @Mock
    private Model model;

    @InjectMocks
    private PessoaController pessoaController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllPessoas() {
        List<Pessoa> pessoas = new ArrayList<>();
        when(jdbcTemplate.query(anyString(), any(RowMapper.class))).thenReturn(pessoas);

        String viewName = pessoaController.getAllPessoas(model);

        assertEquals("pessoas", viewName);
        verify(model).addAttribute("pessoas", pessoas);
    }

    @Test
    public void testFindOnePessoa() {
        Long id = 1L;
        Pessoa pessoa = new Pessoa();
        pessoa.setId(id);
        Optional<Pessoa> pessoaOptional = Optional.of(pessoa);

        when(pessoaService.getOnePessoa(id)).thenReturn(pessoaOptional);
        String viewName = pessoaController.findOnePessoa(id, model);
        verify(model).addAttribute("pessoa", pessoa);

        assertEquals("editarPessoa", viewName);
    }

    @Test
    public void testFindOnePessoaPessoaNotFound() {
        Long id = 1L;
        Optional<Pessoa> pessoaOptional = Optional.empty();

        when(pessoaService.getOnePessoa(id)).thenReturn(pessoaOptional);
        String viewName = pessoaController.findOnePessoa(id, model);
        verify(model).addAttribute("errorMessage", "Pessoa não encontrada.");
        assertEquals("redirect:/pessoas", viewName);
    }

    @Test
    public void testEditarPessoa() {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(1L);

        String viewName = pessoaController.editarPessoa(pessoa);
        verify(pessoaService).save(pessoa);

        assertEquals("redirect:/pessoas", viewName);
    }


    @Test
    public void testInsertPessoa() {
        Pessoa pessoa = new Pessoa();

        String viewName = pessoaController.insertPessoa(pessoa);
        verify(pessoaService).save(pessoa);

        assertEquals("redirect:/pessoas", viewName);
    }

    @Test
    public void testExcluirPessoa() {
        Long id = 1L;
        Optional<Pessoa> pessoaOptional = Optional.of(new Pessoa());

        when(pessoaService.getOnePessoa(id)).thenReturn(pessoaOptional);
        when(projetoService.validGerente(id)).thenReturn(false);


        String viewName = pessoaController.excluirPessoa(id, mock(Model.class));

        verify(pessoaService).delete(id);
        assertEquals("redirect:/pessoas", viewName);
    }

    @Test
    public void testExcluirPessoaPessoaEmProjeto() {
        Long id = 1L;
        Optional<Pessoa> pessoaOptional = Optional.of(new Pessoa());


        when(pessoaService.getOnePessoa(id)).thenReturn(pessoaOptional);
        when(projetoService.validGerente(id)).thenReturn(true);

        Model model = mock(Model.class);
        String viewName = pessoaController.excluirPessoa(id, model);

        verify(model).addAttribute("errorMessage", "Pessoa em Projeto não pode ser excluida.");
        assertEquals("redirect:/pessoas", viewName);
    }

    @Test
    public void testExcluirPessoaPessoaNaoEncontrada() {
        Long id = 1L;
        Optional<Pessoa> pessoaOptional = Optional.empty();

        when(pessoaService.getOnePessoa(id)).thenReturn(pessoaOptional);
        Model model = mock(Model.class);
        String viewName = pessoaController.excluirPessoa(id, model);

        verify(model).addAttribute("errorMessage", "Pessoa não encontrada.");

        assertEquals("redirect:/pessoas", viewName);
    }

}
