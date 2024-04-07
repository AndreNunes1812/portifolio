package br.com.portifolio.Controllers;

import br.com.portifolio.Models.Mappers.ProjetoRowMapper;
import br.com.portifolio.Models.Pessoa;
import br.com.portifolio.Models.Projeto;
import br.com.portifolio.Services.PessoaService;
import br.com.portifolio.Services.ProjetoService;
import br.com.portifolio.enums.ProjetoClassificacao;
import br.com.portifolio.enums.ProjetoStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/projetos")
public class ProjetoController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    ProjetoService projetoService;

    @Autowired
    PessoaService pessoaService;

    @GetMapping("/project")
    public String cadastrarProjeto(Model model) {
        List<Pessoa> gerentes = pessoaService.getAllPessoasGerentes();
        model.addAttribute("riscoValues", ProjetoClassificacao.values());
        model.addAttribute("statusValues", ProjetoStatus.values());
        model.addAttribute("gerentes", gerentes);
        return "cadastrarProjeto";
    }

    @GetMapping("")
    public String getAllProjetos(Model model) {
        List<Projeto> projetos = jdbcTemplate.query("SELECT * FROM projeto", new ProjetoRowMapper());
        model.addAttribute("projetos", projetos);
        return "projetos";
    }

    @GetMapping(value = "/editarProjeto")
    public String findOneProjeto(@RequestParam("id") Long id, Model model) {
        System.out.println("editarProjeto:");
        List<Pessoa> gerentes = pessoaService.getAllPessoasGerentes();

        System.out.println("gerentes:"+gerentes.get(0).getNome());

        Optional<Projeto> projetoOptional = projetoService.getOneProjeto(id);

        if (projetoOptional.isPresent()) {
            Projeto projeto = projetoOptional.get();

            model.addAttribute("riscoValues", ProjetoClassificacao.values());
            model.addAttribute("statusValues", ProjetoStatus.values());
            model.addAttribute("gerentes", gerentes);
            model.addAttribute("projeto", projeto);

        } else {
            model.addAttribute("errorMessage", "Projeto não encontrado.");
            return "redirect:/projetos";
        }
        return "editarProjeto";
    }

    @PostMapping("/editarProjeto")
    public String editarProjeto(@ModelAttribute("projeto") Projeto projeto) {
        projetoService.save(projeto);
        return "redirect:/projetos";
    }

    @PostMapping("")
    public String insertProjeto(@ModelAttribute("projeto") Projeto projeto) {
        projetoService.save(projeto);
        return "redirect:projetos";
    }

    @GetMapping("/excluirProjeto")
    public String excluirProjeto(@RequestParam("id") Long id, Model model) {

        Optional<Projeto> projetoOptional = projetoService.getOneProjeto(id);

        if(!projetoOptional.isPresent()){
            model.addAttribute("errorMessage", "Projeto  não encontrado.");
            return "redirect:projetos";
        } else {

            if (projetoOptional.get().getStatus().toUpperCase().equals("INICIADO") || projetoOptional.get().getStatus().toUpperCase().equals("ANDAMENTO") || projetoOptional.get().getStatus().toUpperCase().equals("ENCERRADO")) {
                model.addAttribute("errorMessage", "Projeto com STATUS:" + projetoOptional.get().getStatus().toUpperCase() + " não pode ser excluido.");
                return "redirect:/projetos";
            }

            if (projetoOptional.isPresent()) {
                projetoService.delete(id);
            } else {
                model.addAttribute("errorMessage", "Projeto  não encontrado.");
                return "redirect:/projetos";
            }
        }
        return "redirect:/projetos";
    }
}