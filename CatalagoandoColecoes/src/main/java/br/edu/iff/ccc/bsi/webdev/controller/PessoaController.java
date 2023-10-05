package br.edu.iff.ccc.bsi.webdev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;

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
	
	@GetMapping("/pessoa/{cpf}")
	public String listarPessoa(@PathVariable("cpf") String cpf,Model model) {
		Pessoa pessoa = pessoaService.consultaPessoa(cpf);
		model.addAttribute("pessoa", pessoa);
		//System.out.println("Nome: "+pessoas.get(0).getNome());
		return "/pessoa/pessoa.html";
	}
	
	@GetMapping("/pessoas/{nome}")
	public String listarPessoas(@PathVariable("nome") String nome, Model model) {
		List<Pessoa> pessoas = pessoaService.consultaPessoasPorNome(nome);
		model.addAttribute("pessoas", pessoas);
		//System.out.println("Nome: "+pessoas.get(0).getNome());
		return "/pessoa/pessoas.html";
	}
	
	@GetMapping("/pessoa/excluir/{cpf}")
	public String excluirPessoa(@PathVariable("cpf") String cpf,Model model) {
		Pessoa pessoa = pessoaService.consultaPessoa(cpf);
		model.addAttribute("pessoa", pessoa);
		//System.out.println("Nome: "+pessoas.get(0).getNome());
		return "/pessoa/deletaPessoa.html";
	}
	
	//pessoa/'+${p.cpf}+'/colecao/cadastro
	@GetMapping("/pessoa/{cpf}/colecao")
	public String carregarColecao(@PathVariable("cpf") String cpf,Model model) {
		//Pessoa pessoa = pessoaService.consultaPessoa(cpf);
		//model.addAttribute("pessoa", pessoa);
		model.addAttribute("cpf", cpf);
		//System.out.println("Nome: "+pessoas.get(0).getNome());
		return "/pessoa/colecao/colecao.html";
	}
	
//	@GetMapping("/pessoa/{cpf}")
//	public String listarPessoa(@PathVariable("cpf") String cpf,Model model) {
//		Pessoa pessoa = pessoaService.consultaPessoa(cpf);
//		model.addAttribute("pessoa", pessoa);
//		//System.out.println("Nome: "+pessoas.get(0).getNome());
//		return "/pessoa/pessoa.html";
//	}
	
}
