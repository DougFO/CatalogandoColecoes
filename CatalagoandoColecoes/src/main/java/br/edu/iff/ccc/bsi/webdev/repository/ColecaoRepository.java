package br.edu.iff.ccc.bsi.webdev.repository;

import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.iff.ccc.bsi.webdev.entities.Colecao;

@Repository
public interface ColecaoRepository extends JpaRepository<Colecao,Long>{

	@Query(value = "SELECT C.* FROM COLECAO AS C JOIN PESSOA AS P ON C.FK_PESSOA = P.ID WHERE P.CPF LIKE (?1)", nativeQuery =true)
	public Map<String,String> consultaColecao(String cpf);
}
