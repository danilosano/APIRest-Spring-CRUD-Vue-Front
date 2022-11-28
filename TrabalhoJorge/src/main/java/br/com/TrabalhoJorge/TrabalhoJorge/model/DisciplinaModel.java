package br.com.TrabalhoJorge.TrabalhoJorge.model;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;

@Entity
@Table(name = "disciplina")
@Data
public class DisciplinaModel extends RepresentationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nome_disciplina", length = 50, nullable = false)
    public String nomeDisciplina;

    @Column(name = "aulas_disciplina")
    public Integer aulasDisciplina;
}
