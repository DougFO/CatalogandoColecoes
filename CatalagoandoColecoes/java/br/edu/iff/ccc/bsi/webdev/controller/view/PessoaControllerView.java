package br.edu.iff.ccc.bsi.webdev.controller.view;

import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/pessoa")
public class PessoaControllerView {
	
//	@RequestMapping(path = "/{cpf}")
//	public String page(@PathVariable("cpf") String cpf) {
//		return "pessoa/pessoa";
//	}
	
	
	@RequestMapping(path = "/cadastro")
	public String cadastro() {
		return "pessoa/cadastro_pessoa";
	}
	
	@RequestMapping(path = "/cadastro/sucesso")
	public String cadastroSucesso() {
		return "pessoa/cadSucesso";
	}
	
	@RequestMapping(path = "/editar/sucesso")
	public String editadoSucesso() {
		return "pessoa/edicaoSucesso";
	}
	
	@RequestMapping(path = "/excluir/sucesso")
	public String removidoSucesso() {
		return "pessoa/excluirSucesso";
	}
	
	@RequestMapping(path = "/pesquisa")
	public String pesquisaPessoa() {
		return "pessoa/pesquisaPessoa";
	}
	
	
	@RequestMapping(path = "/Colecao/cadastro")
	public String cadastroColecao() {
		return "pessoa/cadastro_colecao";
	}
//	@RequestMapping(path = "/cadastro/teste")
//	public String cadastroTeste() {
//		return "header/header";
//	}	
	
//	@GetMapping(path = "")
//	public String ListandoPessoas() {
//		return "pessoa/pessoas2";
//	}
	
	
}
