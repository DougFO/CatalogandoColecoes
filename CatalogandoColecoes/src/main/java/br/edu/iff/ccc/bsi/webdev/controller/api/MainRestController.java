package br.edu.iff.ccc.bsi.webdev.controller.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MainRestController {
	
	@GetMapping("/{id}")
	public String initial(@PathVariable("id") int id) {
		return "Olá mundo -->"+id;
	}

}
