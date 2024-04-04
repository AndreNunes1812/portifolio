package br.com.portifolio.Embeddable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class MembroId implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long idProjeto;

    private Long idPessoa;
}