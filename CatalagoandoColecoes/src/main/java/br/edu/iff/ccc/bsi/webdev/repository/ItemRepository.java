package br.edu.iff.ccc.bsi.webdev.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.iff.ccc.bsi.webdev.entities.Item;
import br.edu.iff.ccc.bsi.webdev.entities.Manga;
import br.edu.iff.ccc.bsi.webdev.entities.Pessoa;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long>{

	@Query(value = "SELECT ID FROM ITEM WHERE isbn LIKE (?1)", nativeQuery =true)
	Long consultaIdItem(String isbn);
	
	@Query(value = "SELECT * FROM ITEM WHERE isbn LIKE (?1)", nativeQuery =true)
	Map<String,String> consultaItem(String isbn);
	
	@Query(value = "SELECT * FROM ITEM WHERE id LIKE (?1)", nativeQuery =true)
	Map<String,String> consultaItemByID(Long id);
	
	@Query(value = "SELECT ID FROM ITEM WHERE isbn LIKE (?1)", nativeQuery =true)
	Long verificaItem(String isbn);
	
	@Query(value = "SELECT * FROM ITEM WHERE TITULO LIKE (?1)", nativeQuery =true)
	List<Item> consultaItensPorTitulo(String titulo);
	
	@Query(value = "SELECT M.TIPO FROM MANGA AS M JOIN ITEM AS I ON M.ID = I.ID WHERE isbn LIKE (?1)", nativeQuery =true)
	int consultaManga(String isbn);
	
	@Query(value = "SELECT HQ.EDITORA_ORIGINAL,HQ.PERSONAGEM_GRUPO FROM HQ JOIN ITEM AS I ON HQ.ID = I.ID WHERE isbn LIKE (?1)", nativeQuery =true)
	Map<String,String> consultaHq(String isbn);

}
