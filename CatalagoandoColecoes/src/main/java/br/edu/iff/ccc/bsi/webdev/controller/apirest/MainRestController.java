package br.edu.iff.ccc.bsi.webdev.controller.apirest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/api")
public class MainRestController {
	
	@GetMapping
	@ResponseBody
	public String initial() {
		return "Olá, bem vindo a API do meu app";
	}
	
	@GetMapping("/{id}")
	public String page(@PathVariable("id") int id) {
		return "Olá mundo -->"+id;
	}
	
	/*@GetMapping("/{id}")
	public String page(@PathVariable("id") int id, @RequestParam("nome") String nome) {
		return "Olá mundo -->"+id+"-->"+nome;
	}*/
	
	/*@GetMapping("/{nome}")
	public String page2(@PathVariable("nome") String nome) {
		return "Olá mundo -->"+nome;
	}*/
	
	@GetMapping("/find")
	public String page2(@RequestParam String nome) {
		return "Olá mundo -->"+nome;
	}
}
