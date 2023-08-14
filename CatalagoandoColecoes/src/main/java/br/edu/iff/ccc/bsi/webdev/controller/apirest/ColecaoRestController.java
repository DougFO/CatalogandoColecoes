package br.edu.iff.ccc.bsi.webdev.controller.apirest;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iff.ccc.bsi.webdev.entities.Colecao;
import br.edu.iff.ccc.bsi.webdev.entities.Item;
import br.edu.iff.ccc.bsi.webdev.service.ColecaoService;
//Depois comentar essa linha, essas opreações devem ser feitas na coleção
import br.edu.iff.ccc.bsi.webdev.service.ItemService;

@RestController
@RequestMapping(path = "api/v1/colecao")
public class ColecaoRestController {
	
	@Autowired
	ColecaoService colecaoService = new ColecaoService();

	//Depois comentar essa linha, essas opreações devem ser feitas na coleção
	@Autowired
	ItemService itemService = new ItemService();

	@PostMapping(path = "")
	@ResponseBody
	public String save(@RequestParam Map<String,String> colecaoMap) throws ParseException {
		
		String cpfPessoa = colecaoMap.get("pessoa");
		String isbnItem = colecaoMap.get("item");
		String nome = colecaoMap.get("nome");
		String obs = colecaoMap.get("observacao");
		String data_inicio = colecaoMap.get("data_inicio");

			
		if(colecaoService.save(nome, obs, data_inicio, cpfPessoa, isbnItem)) {
			return "Coleção adicionada!";
		} else {
			return "Coleção não adicionada!";
		}
	}
	
	@GetMapping("/{cpf}")
	@ResponseBody
	public Colecao consultaColecao(@PathVariable("cpf") String cpf) {
		Colecao colecaoConsultada = colecaoService.consultaColecao(cpf);
		if(colecaoConsultada != null) {
			return colecaoConsultada;
		} else {
			return null;
		}		
	}
	
	
	@PostMapping(path = "/item")
	@ResponseBody
	public String addItem(@RequestParam Map<String,String> colecaoItemMap) {
		
		String cpfPessoa = colecaoItemMap.get("pessoa");
		String isbnItem = colecaoItemMap.get("item");
		
		if((cpfPessoa == "")||(isbnItem == "")) {
			return "Item não adicionado a coleção(Faltando um dos dados)!";
		}
		

		if(colecaoService.AddItem(cpfPessoa, isbnItem)) {
			return "Item adicionado a coleção!";
		} else {
			return "Item não adicionado a coleção!";
		}
	}
	
	@GetMapping
	public List<Colecao> consultaColecoes() {
		return colecaoService.consultaColecoes();
	}
	
	@PutMapping
	@ResponseBody
	public String atualizaColecao(@RequestParam Map<String,String> colecaoMap) {
		if(colecaoService.atualizaColecao(colecaoMap)) {
			return "Colecação atualizada!";
		} else {
			return "Colecação não atualizada!";
		}
	}
	
	@DeleteMapping("/item")
	@ResponseBody
	public String removeItem(@RequestParam Map<String,String> colecaoMap) {
		String cpfPessoa = colecaoMap.get("pessoa");
		String isbnItem = colecaoMap.get("item");
		
		if(colecaoService.removeItem(cpfPessoa, isbnItem)) {
			return "Item removido!";
		} else {
			return "Item não removido!";
		}
	}
	
	@GetMapping("/item/{pessoa}/{item}")
	public Item consultaItemColecao(@PathVariable("pessoa") String pessoa, @PathVariable("item") String item) {
		String cpfPessoa = pessoa;
		String isbnItem = item;
		Item i =  colecaoService.consultaItemColecao(cpfPessoa, isbnItem);
		if(i != null) {
			return i;
		} else {
			return null;
		}
		
		
	}
	
	@GetMapping("/item/{pessoa}")
	public List<Item> ConsultaItensColecao(@PathVariable("pessoa") String cpf) {
		List<Item> itens = colecaoService.consultaItens(cpf);
		if(itens != null) {
			return itens;
		} else {
			return null;
		}
	}
	
	@DeleteMapping
	@ResponseBody
	public String removeColecao(@RequestParam Map<String,String> colecaoMap) {
		String cpfPessoa = colecaoMap.get("pessoa");
		if(colecaoService.removeColecao(cpfPessoa)) {
			return "Coleção removida!";
		} else {
			return "Colecão não removida!";
		}
	}
}
