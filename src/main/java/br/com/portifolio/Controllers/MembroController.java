package br.com.portifolio.Controllers;

import br.com.portifolio.Models.Membro;
import br.com.portifolio.Services.MembroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/membros")
public class MembroController {
    @Autowired
    MembroService membroService;

    @PostMapping
    public void save(@RequestBody @Valid Membro membro) {
        System.out.println("Membro:"+membro);
        membroService.save(membro);
    }
}