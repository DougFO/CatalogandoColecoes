package br.edu.iff.ccc.bsi.webdev.repository;
import br.edu.iff.ccc.bsi.webdev.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long>{
}

