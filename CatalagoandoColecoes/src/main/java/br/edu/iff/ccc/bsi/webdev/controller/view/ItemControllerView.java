package br.edu.iff.ccc.bsi.webdev.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping(path = "")
public class ItemControllerView {
	
	@RequestMapping(path = "/itens")
	public String itens() {
		return "item/itens";
	}
	
	@RequestMapping(path = "/item/cadastro")
	public String cadastro() {
		return "item/cadastro_item";
	}
	
	@RequestMapping(path = "/item")
	public String item() {
		return "item/item";
	}

}
