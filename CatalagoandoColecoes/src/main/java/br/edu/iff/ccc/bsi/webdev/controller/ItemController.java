package br.edu.iff.ccc.bsi.webdev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.iff.ccc.bsi.webdev.entities.Hq;
import br.edu.iff.ccc.bsi.webdev.entities.Item;
import br.edu.iff.ccc.bsi.webdev.entities.Manga;
import br.edu.iff.ccc.bsi.webdev.entities.Pessoa;
import br.edu.iff.ccc.bsi.webdev.service.ItemService;

@Controller
public class ItemController {
	
	@Autowired
	ItemService itemService;
	
//	@GetMapping("/item")
//	//public String listarItens(Model model) {
//	public ResponseEntity<List<Item>> listarItens() {
//		return new ResponseEntity<>(itemService.consultaItens(),HttpStatus.OK);
//		//model.addAttribute("itens", itens);
//		//System.out.println("Nome: "+pessoas.get(0).getNome());
//		//return "/item/itens.html";
//		//return itens;
//	}
	
	
	@GetMapping("/item")
	public String listarItens(Model model) {
	//public ResponseEntity<List<Item>> listarItens() {
		List<Item> itens = itemService.consultaItens();
		model.addAttribute("itens", itens);
		//System.out.println("Nome: "+pessoas.get(0).getNome());
		return "/item/itens.html";
		//return itens;
	}
	
	@GetMapping("/item/{isbn}/manga")
	public String consultaManga(@PathVariable("isbn") String isbn,Model model) {
		Manga manga = itemService.consultaManga(isbn);
		model.addAttribute("manga", manga);
		//System.out.println("Nome: "+pessoas.get(0).getNome());
		return "/item/manga.html";
	}
	
	@GetMapping("/item/{isbn}/hq")
	public String consultaHq(@PathVariable("isbn") String isbn,Model model) {
		Hq hq = itemService.consultaHq(isbn);
		model.addAttribute("hq", hq);
		//System.out.println("Nome: "+pessoas.get(0).getNome());
		return "/item/hq.html";
	}
	
	@GetMapping("/itensPesquisados/{titulo}")
	public String listarItens(@PathVariable("titulo") String titulo, Model model) {
		//List<Item> itens = itemService.consultaItensPorTitulo(titulo);
		//model.addAttribute("itens", itens);
		String tituloP = titulo;
		model.addAttribute("titulo", tituloP);
		//System.out.println("Nome: "+pessoas.get(0).getNome());
		return "/item/itensPesquisados.html";
	}
}
