package br.com.portifolio.Models;

import br.com.portifolio.Embeddable.MembroId;
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
public class Membro  implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private MembroId id;
}