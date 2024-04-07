package br.com.portifolio.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="membros")
@IdClass(MembroId.class)
public class Membro  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "idprojeto")
    private Long idProjeto;

    @Id
    @Column(name = "idpessoa")
    private Long idPessoa;

    @ManyToOne
    @JoinColumn(name = "idprojeto", referencedColumnName = "id", insertable = false, updatable = false)
    private Projeto projeto;


    @ManyToOne
    @JoinColumn(name = "idpessoa", referencedColumnName = "id", insertable = false, updatable = false)
    private Pessoa pessoa;

}