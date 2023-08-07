package br.edu.iff.ccc.bsi.webdev.controller.apirest;

import java.text.ParseException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iff.ccc.bsi.webdev.service.ColecaoService;

@RestController
@RequestMapping(path = "/colecao")
public class ColecaoRestController {
	
	@Autowired
	ColecaoService colecaoService = new ColecaoService();

	@PostMapping
	@ResponseBody
	public String save(@RequestParam Map<String,String> colecaoMap) throws ParseException {
		
		String cpfPessoa = colecaoMap.get("pessoa");
		String isbnItem = colecaoMap.get("item");
		
		if(colecaoService.verificaColecao(cpfPessoa) == null) {
			String nome = colecaoMap.get("nome");
			String obs = colecaoMap.get("observacao");
			String data_inicio = colecaoMap.get("data_inicio");			
			
			if(colecaoService.save(nome, obs, data_inicio, cpfPessoa, isbnItem)) {
				return "Coleção adicionada!";
			} else {
				return "Coleção não adicionada!";
			}
		} else {
			Long idColecao = colecaoService.verificaColecao(cpfPessoa);
			Long idItem = colecaoService.consultaIdItem(isbnItem);
			System.out.println("IdColecaoR: "+idColecao);
			System.out.println("IdItemR: "+idItem);
			
			if(colecaoService.AddItem(idColecao, idItem)&&(idColecao != null)&&(idItem != null)) {
				return "Item adicionado a coleção!";
			} else {
				return "Item não adicionado a coleção!";
			}
		}	
	}
	
	@GetMapping("/{cpf}")
	@ResponseBody
	public String consultaColecao(@PathVariable("cpf") String cpf) {
		Map<String,String> colecaoConsultada = colecaoService.consultaColecao(cpf);
		System.out.println("cpf: "+cpf);
		System.out.println("Nome: "+colecaoConsultada.get("nome"));
		return "Coleção consultada com sucesso";
	}
	
}
