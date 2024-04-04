package br.com.portifolio.Services;


import br.com.portifolio.Models.Membro;
import br.com.portifolio.Repositories.MembroRepository;
import br.com.portifolio.Repositories.PessoaRepository;
import br.com.portifolio.Repositories.ProjetoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MembroService{

    @Autowired
    MembroRepository membroRepository;

    @Autowired
    ProjetoRepository projetoRepository;

    @Autowired
    PessoaRepository pessoaRepository;

    @Transactional
    public ResponseEntity<Object> save(Membro membro){

        boolean idprojeto = projetoRepository.existsById(membro.getIdProjeto());
        boolean idpessoa =  pessoaRepository.existsById(membro.getIdPessoa());

        if((idprojeto) && (idpessoa)) {
            membroRepository.save(membro);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ERRO: ao criar o membro");
    }
}
