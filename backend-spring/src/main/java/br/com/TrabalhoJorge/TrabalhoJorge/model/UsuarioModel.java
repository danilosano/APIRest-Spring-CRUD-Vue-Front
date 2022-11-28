package br.com.TrabalhoJorge.TrabalhoJorge.model;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "Usuario")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome_usuario", nullable = false, length = 300)
    private String nomeUsuario;

    @Column(name = "email_usuario", nullable = false, length = 300, unique = true)
    private  String emailUsuario;

    @Column(name = "senha_usuario", nullable = false, length = 300)
    private String senhaUsuario;

}
