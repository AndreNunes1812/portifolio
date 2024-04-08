package br.com.portifolio.Services;


import br.com.portifolio.Models.Membro;
import br.com.portifolio.Models.MembroId;
import br.com.portifolio.Models.Pessoa;
import br.com.portifolio.Repositories.MembroRepository;
import br.com.portifolio.Repositories.PessoaRepository;
import br.com.portifolio.Repositories.ProjetoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MembroService{

    @Autowired
    MembroRepository membroRepository;

    @Autowired
    ProjetoRepository projetoRepository;

    @Autowired
    PessoaRepository pessoaRepository;
    @Autowired
    PessoaService pessoaService;

    @Autowired
    public List<Membro> getAllMembros() {
        return membroRepository.findAll();
    }

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

    public Optional<Membro> getOneMembro(Long idProjeto, Long idPessoa) {

        return membroRepository.findByIdProjetoAndIdPessoa(idProjeto, idPessoa);
    }

    public void delete(Long idProjeto, Long idPessoa) {
        MembroId membroId = new MembroId(idProjeto, idPessoa);
        membroRepository.deleteById(membroId);
    }

    public void validarFuncionario(MembroId membroId) {

        Optional<Membro> membroResult = getOneMembro(membroId.getIdProjeto(), membroId.getIdPessoa());

        if(membroResult.isPresent()) {
            Membro membro = membroResult.get();

            Optional<Pessoa> pessoa = pessoaService.getOnePessoa(membro.getIdPessoa());

            if(pessoa.isPresent()){
                if(pessoa.get().isFuncionario()){
                    save(membro);
                }
            }
        }

    }


}
