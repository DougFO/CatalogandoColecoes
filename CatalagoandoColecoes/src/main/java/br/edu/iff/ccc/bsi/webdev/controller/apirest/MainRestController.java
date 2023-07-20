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
import br.edu.iff.ccc.bsi.webdev.service.PessoaService;


@RestController
@RequestMapping(path = "/api")
public class MainRestController {
	
	@Autowired
	PessoaService pessoaService;
	
	@GetMapping
	@ResponseBody
	public String initial() {
		return "Olá, bem vindo a API do meu app";
	}

	
	@PostMapping(value = "/cadastroPessoa/save")
	@ResponseBody
	public String savePessoa(Pessoa pessoa, Usuario user, Endereco endereco) {	
			
			if(pessoaService.save(user, pessoa, endereco)) {
				return "Usuário adicionado! ";
			} else {
				return "Usuário não adicionado! ";
			}
			
			
	}
	
	
	
	
	
}

