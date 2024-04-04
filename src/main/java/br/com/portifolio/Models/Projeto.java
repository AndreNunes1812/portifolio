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
@Table(name="projeto")
public class Projeto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(length = 200)
    private String nome;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
    private String dataInicio;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
    private String dataPrevisaoFim;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
    private String dataFim;

    @NotNull
    @Column(length = 5000)
    private String descricao;

    @Column(length = 45)
    private String status;

    @NotNull
    private double orcamento;

    @NotNull
    @Column(length = 45)
    private String risco;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idgerente")
    private Pessoa gerencial;


}
