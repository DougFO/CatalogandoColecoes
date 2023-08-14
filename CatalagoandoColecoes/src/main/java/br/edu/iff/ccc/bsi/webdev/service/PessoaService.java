package br.edu.iff.ccc.bsi.webdev.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iff.ccc.bsi.webdev.entities.Endereco;
import br.edu.iff.ccc.bsi.webdev.entities.Pessoa;
import br.edu.iff.ccc.bsi.webdev.entities.Usuario;
import br.edu.iff.ccc.bsi.webdev.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository rep;	
	
	@Autowired
	private UsuarioService usuarioService = new UsuarioService();
	
	//public boolean save(Usuario user, Pessoa pessoa, Endereco endereco) {
	public Pessoa save(Usuario user, Pessoa pessoa, Endereco endereco) {
		pessoa.setUsuario(usuarioService.save(user));
		pessoa.setEndereco(endereco);
		Pessoa p = rep.save(pessoa);
		if(p.equals(null)) {
			//return false;
			return null;
		}
		//rep.save(pessoa);
		//return true;
		return p;
	}
	
	
	public Pessoa consultaPessoa(String cpf) {
		Map<String,String> pessoaConsultada = rep.consultaPessoa(cpf);
		Pessoa pessoa = new Pessoa();
		pessoa.setID(Long.parseLong(String.valueOf(pessoaConsultada.get("ID"))));
		pessoa.setCpf(pessoaConsultada.get("CPF"));
		pessoa.setEmail(pessoaConsultada.get("EMAIL"));
		pessoa.setNome(pessoaConsultada.get("NOME"));
		
		Endereco endereco = new Endereco();
		endereco.setCEP(pessoaConsultada.get("CEP"));
		endereco.setBairro(pessoaConsultada.get("BAIRRO"));
		endereco.setCidade(pessoaConsultada.get("CIDADE"));
		endereco.setEstado(pessoaConsultada.get("ESTADO"));
		endereco.setRua(pessoaConsultada.get("RUA"));
		endereco.setNumero(pessoaConsultada.get("NUMERO"));
		
		pessoa.setEndereco(endereco);
		
		Usuario usuario = new Usuario();
		Long idUsuario = this.consultaIDUsuario(cpf);
		usuario = usuarioService.consultaUsuario(idUsuario);
		pessoa.setUsuario(usuario);			
				
		return pessoa;
	}
	
	Long consultaIDUsuario(String cpf) {
		Map<String,String> pessoaConsultada = rep.consultaPessoa(cpf);
		return Long.parseLong(String.valueOf(pessoaConsultada.get("FK_USUARIO")));
	}
}
