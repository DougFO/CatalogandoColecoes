package br.edu.iff.ccc.bsi.webdev.controller.apirest;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import br.edu.iff.ccc.bsi.webdev.entities.Hq;
import br.edu.iff.ccc.bsi.webdev.entities.Item;
import br.edu.iff.ccc.bsi.webdev.service.ItemService;

@RestController
@RequestMapping(path = "api/v1/item")
public class ItemRestController {
	
	@Autowired
	ItemService itemService;

	@PostMapping
	public String save(Item item, @RequestParam Map<String,String> itemMap) {
		
		if(itemService.save(item, itemMap)) {
			return "Item adicionado!";
		} else {
			return "Item não adicionado!";
		}
		
	}
}
