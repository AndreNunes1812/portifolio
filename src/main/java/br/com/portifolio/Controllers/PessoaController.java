package br.com.portifolio.Controllers;

import br.com.portifolio.Models.Pessoa;
import br.com.portifolio.Services.PessoaService;
import br.com.portifolio.Services.ProjetoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/pessoas")
public class PessoaController {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    PessoaService pessoaService;

    @Autowired
    ProjetoService projetoService;


    @GetMapping("/cadastrar")
    public String cadastrarPessoas() {  return "cadastrarPessoa"; }

    @GetMapping("")
    public String getAllPessoas(Model model) {
        List<Pessoa> pessoas = pessoaService.getAllPessoas();
        model.addAttribute("pessoas", pessoas);
        return "pessoas";
    }

    @GetMapping(value = "/editarPessoa")
    public String findOnePessoa(@RequestParam("id") Long id, Model model) {
        Optional<Pessoa> pessoaOptional = pessoaService.getOnePessoa(id);
        if (pessoaOptional.isPresent()) {
            Pessoa pessoa = pessoaOptional.get();
            model.addAttribute("pessoa", pessoa);
        } else {
            model.addAttribute("errorMessage", "Pessoa não encontrada.");
            return "redirect:/pessoas";
        }
        return "editarPessoa";
    }

    @PostMapping("/editarPessoa")
    public String editarPessoa(@ModelAttribute("pessoa") Pessoa pessoa) {
        pessoaService.save(pessoa);
        return "redirect:/pessoas";
    }

    @PostMapping("")
    public String insertPessoa(@ModelAttribute("pessoa") Pessoa pessoa) {
        pessoaService.save(pessoa);
        return "redirect:/pessoas";
    }

    @Transactional
    @GetMapping("/excluirPessoa")
    public String excluirPessoa(@RequestParam("id") Long id, Model model) {
       Optional<Pessoa> pessoa = pessoaService.getOnePessoa(id);
        if(pessoa.isPresent()){
            boolean pessoaEmProjeto = projetoService.validGerente(id);
            if(!pessoaEmProjeto){
                pessoaService.delete(id);
            } else {
                model.addAttribute("errorMessage", "Pessoa em Projeto não pode ser excluida.");
                return "redirect:/pessoas";
            }
        } else {
            model.addAttribute("errorMessage", "Pessoa não encontrada.");
            return "redirect:/pessoas";
        }
        return "redirect:/pessoas";
    }

}