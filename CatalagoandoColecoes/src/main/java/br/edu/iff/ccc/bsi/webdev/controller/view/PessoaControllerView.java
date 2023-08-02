package br.edu.iff.ccc.bsi.webdev.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/Pessoa")
public class PessoaControllerView {
	
	@RequestMapping(path = "")
	public String page() {
		return "pessoa/pessoa";
	}
	
	@RequestMapping(path = "/cadastro")
	public String cadastro() {
		return "pessoa/cadastro_pessoa";
	}

}
