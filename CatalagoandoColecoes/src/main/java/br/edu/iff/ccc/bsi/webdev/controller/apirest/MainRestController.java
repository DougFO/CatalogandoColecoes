package br.edu.iff.ccc.bsi.webdev.controller.apirest;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iff.ccc.bsi.webdev.entities.Endereco;
import br.edu.iff.ccc.bsi.webdev.entities.Hq;
import br.edu.iff.ccc.bsi.webdev.entities.Item;
import br.edu.iff.ccc.bsi.webdev.entities.Manga;
import br.edu.iff.ccc.bsi.webdev.entities.Pessoa;
import br.edu.iff.ccc.bsi.webdev.entities.TipoManga;
import br.edu.iff.ccc.bsi.webdev.entities.Usuario;
import br.edu.iff.ccc.bsi.webdev.repository.PessoaRepository;
import br.edu.iff.ccc.bsi.webdev.repository.UsuarioRepository;
import br.edu.iff.ccc.bsi.webdev.service.ItemService;
import br.edu.iff.ccc.bsi.webdev.service.PessoaService;


@RestController
@RequestMapping(path = "/api")
public class MainRestController {
	
	@Autowired
	PessoaService pessoaService;
	
	@Autowired
	ItemService itemService;
	
	@GetMapping
	@ResponseBody
	public String initial() {
		return "Olá, bem vindo a API do meu app";
	}

	
//	@PostMapping(value = "/cadastroPessoa/save")
//	@ResponseBody
//	public String savePessoa(Pessoa pessoa, Usuario user, Endereco endereco) {	
//			
//			if(pessoaService.save(user, pessoa, endereco)) {
//				return "Usuário adicionado! ";
//			} else {
//				return "Usuário não adicionado! ";
//			}
//			
//			
//	}
		
	
//	@PostMapping(value = "/cadastro_item/save")
//	@ResponseBody
//	public String saveItem(Item item, Hq hq, @RequestParam Map<String,String> itemMap) {
//		
//		int tipo = Integer.parseInt(itemMap.get("tipo"));
//		String opcao = itemMap.get("opcao");
//		
//		if(itemService.save(item, tipo, hq, opcao)) {
//			return "Item adicionado!";
//		} else {
//			return "Item não adicionado!";
//		}
//
//		
//	}
	
	
	
	
	
	
	
}

