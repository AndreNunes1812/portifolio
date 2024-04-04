package br.com.portifolio.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="pessoa")
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="nome", length = 100 , unique = true)
    private String nome;


    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
    @Column(name = "datanascimento")
    private String dataNascimento;

    @NotNull
    @Column(name="cpf", nullable = false, length = 14)
    private String cpf;

    @NotNull
    @Column(name="funcionario")
    private boolean funcionario;

    @NotNull
    @Column(name="gerente")
    private boolean gerente;

    @OneToMany(mappedBy = "gerencial")
    private List<Projeto> projetosGerenciados;

}
