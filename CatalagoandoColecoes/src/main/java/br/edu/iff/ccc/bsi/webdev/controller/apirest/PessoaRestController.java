package br.edu.iff.ccc.bsi.webdev.controller.apirest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iff.ccc.bsi.webdev.entities.Endereco;
import br.edu.iff.ccc.bsi.webdev.entities.Pessoa;
import br.edu.iff.ccc.bsi.webdev.entities.Usuario;
import br.edu.iff.ccc.bsi.webdev.service.PessoaService;

@RestController
@RequestMapping(path = "api/v1/pessoa")
public class PessoaRestController {
	
	@Autowired
	PessoaService pessoaService;
	
	@PostMapping
	public String save(Pessoa pessoa, Usuario user, Endereco endereco) {
		
		if(pessoaService.save(user, pessoa, endereco)) {
			return "Usuário adicionado! ";
		} else {
			return "Usuário não adicionado! ";
		}
	}

}
