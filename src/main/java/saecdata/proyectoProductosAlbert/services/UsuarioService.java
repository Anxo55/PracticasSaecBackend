package saecdata.proyectoProductosAlbert.services;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import saecdata.proyectoProductosAlbert.models.Usuario;
import saecdata.proyectoProductosAlbert.repositories.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        // Asignar el rol con el prefijo ROLE_ para que Spring Security lo reconozca
        return new User(
            usuario.getUsername(),
            usuario.getPassword(),
            Collections.singleton(new SimpleGrantedAuthority("ROLE_" + usuario.getRol())) // Aquí asignamos el rol
        );
    }
}
