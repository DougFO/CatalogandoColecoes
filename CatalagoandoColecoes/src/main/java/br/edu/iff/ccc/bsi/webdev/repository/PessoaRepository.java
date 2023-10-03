package br.edu.iff.ccc.bsi.webdev.repository;

import br.edu.iff.ccc.bsi.webdev.entities.Pessoa;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


@Repository
public interface PessoaRepository extends JpaRepository<Pessoa,Long>{

	@Query(value = "SELECT ID FROM PESSOA WHERE cpf LIKE (?1)", nativeQuery =true)
//	String consultaIdPessoa(String cpf);
	Long consultaIdPessoa(String cpf);
	
	@Query(value = "SELECT * FROM PESSOA WHERE cpf LIKE (?1)", nativeQuery =true)
	Map<String,String> consultaPessoa(String cpf);
	
	@Query(value = "SELECT FK_USUARIO FROM PESSOA WHERE CPF LIKE (?1)", nativeQuery =true)
	long consultaFKUsuario(String cpf);
	
	@Query(value = "SELECT FK_COLECAO FROM PESSOA WHERE CPF LIKE (?1)", nativeQuery =true)
	Long consultaFKColecao(String cpf);
	
	@Query(value = "SELECT * FROM PESSOA WHERE NOME LIKE (?1)", nativeQuery =true)
	List<Pessoa> consultaPessoaPorNome(String nome);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE PESSOA SET NOME = (?2), EMAIL = (?3), CEP = (?4), RUA = (?5), NUMERO = (?6), BAIRRO = (?7), CIDADE = (?8), ESTADO = (?9) WHERE CPF LIKE (?1)", nativeQuery =true)
	int atualizar(String cpf,String nome,String email,String cep,String rua,String numero,String bairro,String cidade,String estado);
}
