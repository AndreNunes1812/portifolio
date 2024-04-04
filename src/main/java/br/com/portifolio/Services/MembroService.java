package br.com.portifolio.Services;


import br.com.portifolio.Models.Membro;
import br.com.portifolio.Repositories.MembroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MembroService{

    @Autowired
    MembroRepository membroRepository;
    public void save(Membro membro){
        membroRepository.save(membro);
    }
}
