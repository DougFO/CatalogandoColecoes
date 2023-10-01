package br.edu.iff.ccc.bsi.webdev.repository;

import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.iff.ccc.bsi.webdev.entities.Item;

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
}
