package br.edu.iff.ccc.bsi.webdev.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/Cadastro_colecao")
public class CadastroColecaoControllerView {
	
	@GetMapping
	public String page() {
		return "cadastro/cadastro_colecao.html";
	}

}
