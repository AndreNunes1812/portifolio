package br.com.portifolio.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class MembroId implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long idProjeto;

    private Long idPessoa;


}
