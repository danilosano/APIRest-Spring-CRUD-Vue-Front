package br.com.TrabalhoJorge.TrabalhoJorge.model;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;

@Entity
@Table(name = "professor")
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorModel extends RepresentationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter @Getter
    private long id;

    @Column(name = "nomeCompleto", nullable = false, length = 50)
    @Setter @Getter
    private String nomeCompleto;

    @Column(name = "email",nullable = false, length = 50)
    @Setter @Getter
    private String email;

    @Column(name = "idade",nullable = false)
    @Setter @Getter
    private Integer idade;

    @Column(name = "salario", nullable = false)
    @Getter @Setter
    private Float salario;

    @ManyToOne
    @JoinColumn(name = "disciplina_id")
    @Getter @Setter
    private DisciplinaModel disciplina;
}
