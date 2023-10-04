package br.edu.iff.ccc.bsi.webdev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.iff.ccc.bsi.webdev.entities.Pessoa;
import br.edu.iff.ccc.bsi.webdev.service.PessoaService;

@Controller
public class PessoaController {

	@Autowired
	PessoaService pessoaService;

	@GetMapping("/pessoa")
	public String listarPessoas(Model model) {
		List<Pessoa> pessoas = pessoaService.consultaPessoas();
		model.addAttribute("pessoas", pessoas);
		//System.out.println("Nome: "+pessoas.get(0).getNome());
		return "/pessoa/pessoas.html";
	}
}
