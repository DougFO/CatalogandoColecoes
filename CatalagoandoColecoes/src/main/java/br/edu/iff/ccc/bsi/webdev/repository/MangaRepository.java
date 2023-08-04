package br.edu.iff.ccc.bsi.webdev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;

import br.edu.iff.ccc.bsi.webdev.entities.Manga;
import jakarta.transaction.Transactional;

@Repository
public interface MangaRepository extends JpaRepository<Manga,Long> {
	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO MANGA (TIPO) VALUES (?1)", nativeQuery =true)
	void salvar(int t);
		

}
