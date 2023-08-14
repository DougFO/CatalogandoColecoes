package br.edu.iff.ccc.bsi.webdev.repository;
import br.edu.iff.ccc.bsi.webdev.entities.Usuario;

import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long>{
	
	@Query(value = "SELECT * FROM USUARIO WHERE ID LIKE (?1)", nativeQuery =true)
	Map<String,String> consultaUsuario(Long id);
}

