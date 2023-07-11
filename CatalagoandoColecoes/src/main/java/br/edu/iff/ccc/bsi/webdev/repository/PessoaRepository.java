package br.edu.iff.ccc.bsi.webdev.repository;

import br.edu.iff.ccc.bsi.webdev.entities.Pessoa;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface PessoaRepository extends JpaRepository<Pessoa,Long>{

}
