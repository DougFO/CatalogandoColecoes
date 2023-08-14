package br.edu.iff.ccc.bsi.webdev.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.iff.ccc.bsi.webdev.entities.Colecao;
import jakarta.transaction.Transactional;

@Repository
public interface ColecaoRepository extends JpaRepository<Colecao,Long>{

	@Query(value = "SELECT C.* FROM COLECAO AS C JOIN PESSOA AS P ON C.FK_PESSOA = P.ID WHERE P.CPF LIKE (?1)", nativeQuery =true)
	Map<String,String> consultaColecao(String cpf);
	
	@Query(value = "SELECT C.ID FROM COLECAO AS C JOIN PESSOA AS P ON C.FK_PESSOA = P.ID WHERE P.CPF LIKE (?1)", nativeQuery =true)
	Long verificaColecao(String cpf);
	
	@Transactional
	@Modifying
	@Query(value = "INSERT INTO ITEM_COLECAO (FK_COLECAO,FK_ITEM) VALUES (?1,?2)", nativeQuery =true)
	int AddItem(Long colecao,Long item);
	
	@Query(value = "SELECT FK_ITEM FROM ITEM_COLECAO WHERE FK_COLECAO = (?1)", nativeQuery =true)
	List<Long> consultaItensColecao(Long id);
}
