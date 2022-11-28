package br.com.TrabalhoJorge.TrabalhoJorge.service;

import br.com.TrabalhoJorge.TrabalhoJorge.model.UsuarioModel;
import br.com.TrabalhoJorge.TrabalhoJorge.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        UsuarioModel usuario = repository.findByEmailUsuario(username)
                .orElseThrow(() -> new UsernameNotFoundException("Email não encontrado!"));
        return User
                .builder()
                .username(usuario.getEmailUsuario())
                .password(usuario.getSenhaUsuario())
                .roles("USER")
                .build();
    }
}
