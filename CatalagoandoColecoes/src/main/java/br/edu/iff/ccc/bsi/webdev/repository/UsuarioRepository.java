package br.edu.iff.ccc.bsi.webdev.repository;
import br.edu.iff.ccc.bsi.webdev.entities.Usuario;

import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long>{
	
	@Query(value = "SELECT * FROM USUARIO WHERE ID LIKE (?1)", nativeQuery =true)
	Map<String,String> consultaUsuario(Long id);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE USUARIO SET USERNAME = (?2), PASSWORD = (?3), NIVEL = (?4) WHERE ID = (?1)", nativeQuery =true)
	int atualizar(Long ID,String username,String password,int nivel);
}

