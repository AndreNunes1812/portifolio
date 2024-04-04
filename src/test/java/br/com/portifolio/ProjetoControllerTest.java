package br.com.portifolio;

import br.com.portifolio.Controllers.ProjetoController;
import br.com.portifolio.Models.Mappers.ProjetoRowMapper;
import br.com.portifolio.Models.Pessoa;
import br.com.portifolio.Models.Projeto;
import br.com.portifolio.Services.PessoaService;
import br.com.portifolio.Services.ProjetoService;
import br.com.portifolio.enums.ProjetoClassificacao;
import br.com.portifolio.enums.ProjetoStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ProjetoControllerTest {

    @Mock
    private PessoaService pessoaService;

    @Mock
    private ProjetoService projetoService;

    @InjectMocks
    private ProjetoController projetoController;


    @Mock
    private JdbcTemplate jdbcTemplate;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllProjetos() {
        List<Projeto> projetos = new ArrayList<>();
        projetos.add(new Projeto());
        projetos.add(new Projeto());


        when(jdbcTemplate.query(anyString(), any(ProjetoRowMapper.class))).thenReturn(projetos);
        Model model = mock(Model.class);
        String viewName = projetoController.getAllProjetos(model);

        verify(model).addAttribute("projetos", projetos);
        assertEquals("projetos", viewName);
    }

    @Test
    public void testFindOneProjeto() {
        Long id = 1L;
        Pessoa gerente = new Pessoa();
        gerente.setId(1L);

        Projeto projeto = new Projeto();
        projeto.setId(id);
        projeto.setGerencial(gerente);

        Optional<Projeto> projetoOptional = Optional.of(projeto);

        when(projetoService.getOneProjeto(id)).thenReturn(projetoOptional);
        List<Pessoa> gerentes = new ArrayList<>();
        gerentes.add(gerente);
        when(pessoaService.getAllPessoasGerentes()).thenReturn(gerentes);

        Model model = mock(Model.class);

        String viewName = projetoController.findOneProjeto(id, model);

        verify(model).addAttribute("projeto", projeto);

        verify(model).addAttribute("riscoValues", ProjetoClassificacao.values());
        verify(model).addAttribute("statusValues", ProjetoStatus.values());

        verify(model).addAttribute("gerentes", gerentes);
        assertEquals("editarProjeto", viewName);
    }
}
