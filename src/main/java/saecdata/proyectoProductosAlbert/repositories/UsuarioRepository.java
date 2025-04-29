package saecdata.proyectoProductosAlbert.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import saecdata.proyectoProductosAlbert.models.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsername(String username);

}
