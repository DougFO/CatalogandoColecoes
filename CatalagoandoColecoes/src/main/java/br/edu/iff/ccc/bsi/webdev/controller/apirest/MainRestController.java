package br.edu.iff.ccc.bsi.webdev.controller.apirest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iff.ccc.bsi.webdev.entities.Endereco;
import br.edu.iff.ccc.bsi.webdev.entities.Pessoa;
import br.edu.iff.ccc.bsi.webdev.entities.Usuario;
import br.edu.iff.ccc.bsi.webdev.repository.PessoaRepository;
import br.edu.iff.ccc.bsi.webdev.repository.UsuarioRepository;


@RestController
@RequestMapping(path = "/api")
public class MainRestController {
	
	@GetMapping
	@ResponseBody
	public String initial() {
		return "Olá, bem vindo a API do meu app";
	}
	
	
	@Autowired
	private UsuarioRepository reu;
	
	@Autowired
	private PessoaRepository rep; 
	
	
	
//	@PostMapping(value = "/cadastroUsuario/save")
//	@ResponseBody
//	public String saveUserEstudo( Usuario user) {	
//			
//			Usuario u = res.save(user);
//			return "Usuário adicionado --> "+u.getID()+" --> ";
//			
//	}
	
	@PostMapping(value = "/cadastroPessoa/save")
	@ResponseBody
	public String savePessoa(Pessoa pessoa, Usuario user, Endereco endereco) {	
			
			Usuario u = reu.save(user);
			pessoa.setUsuario(u);
			pessoa.setEndereco(endereco);
			Pessoa p = rep.save(pessoa);
			return "Usuário adicionado --> "+u.getUsername()+" --> "+p.getNome();
			
	}
	
	
	
	
	
}

