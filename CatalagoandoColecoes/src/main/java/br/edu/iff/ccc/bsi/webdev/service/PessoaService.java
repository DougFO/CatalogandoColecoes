package br.edu.iff.ccc.bsi.webdev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iff.ccc.bsi.webdev.entities.Endereco;
import br.edu.iff.ccc.bsi.webdev.entities.Pessoa;
import br.edu.iff.ccc.bsi.webdev.entities.Usuario;
import br.edu.iff.ccc.bsi.webdev.repository.PessoaRepository;
import br.edu.iff.ccc.bsi.webdev.repository.UsuarioRepository;

@Service
public class PessoaService {
	
	@Autowired
	private UsuarioRepository reu;
	
	@Autowired
	private PessoaRepository rep;
	
	public boolean save(Usuario user, Pessoa pessoa, Endereco endereco) {
		Usuario u = reu.save(user);
		pessoa.setUsuario(u);
		pessoa.setEndereco(endereco);
		Pessoa p = rep.save(pessoa);		
		return true;
	}
}
