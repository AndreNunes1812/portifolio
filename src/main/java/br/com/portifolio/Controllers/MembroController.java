package br.com.portifolio.Controllers;

import br.com.portifolio.Models.Membro;
import br.com.portifolio.Models.MembroId;
import br.com.portifolio.Models.Pessoa;
import br.com.portifolio.Models.Projeto;
import br.com.portifolio.Services.MembroService;
import br.com.portifolio.Services.PessoaService;
import br.com.portifolio.Services.ProjetoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/membros")
public class MembroController {
    @Autowired
    MembroService membroService;

    @Autowired
    ProjetoService projetoService;
    @Autowired
    PessoaService pessoaService;

    @GetMapping("")
    public String getAllMembros(Model model) {
        List<Membro> membros =  membroService.getAllMembros();
        model.addAttribute("membros", membros);
        return "membros";
    }

    @PostMapping("")
    public void save(@RequestBody MembroId membro) {
        membroService.validarFuncionario(membro);
    }

    @Transactional
    @GetMapping("/excluirMembro")
    public String excluirMembro(@RequestParam("idProjeto") Long idProjeto, @RequestParam("idPessoa") Long idPessoa, Model model) {
        Optional<Membro> membro = membroService.getOneMembro(idProjeto, idPessoa);
        if(!membro.isPresent()) {
            model.addAttribute("erromessage", "Membro não cadastrado");
        }

        membroService.delete(idProjeto,idPessoa);

        return "redirect:/membros";
    }

    @GetMapping(value = "/editarMembro")
    public String findOneMembro(@RequestParam("idProjeto") Long idProjeto, @RequestParam("idPessoa") Long idPessoa, Model model) {
        List<Projeto> projetos = projetoService.getAllPprojetos();
        Optional<Membro> membroOptional = membroService.getOneMembro(idProjeto, idPessoa);
        if (membroOptional.isPresent()) {
            Membro membro = membroOptional.get();
            model.addAttribute("projetos", projetos);
            model.addAttribute("pessoas", pessoaService.getAllPessoasFuncionarios());
            model.addAttribute("membro", membro);
        } else {
            model.addAttribute("errorMessage", "Membro/Projeto não encontrado.");
            return "redirect:/membros";
        }
        return "editarMembro";
    }
}