package br.edu.iff.ccc.bsi.webdev.controller.apirest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iff.ccc.bsi.webdev.entities.Usuario;


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
	
	@GetMapping("/testeVeP/{id2}")
	//public String page2(@PathVariable("id2") int id2, @RequestParam String nome2) {
	//public String page2(@PathVariable("id2") int id2, @RequestParam String nome2 (required=false)) {
	public String page2(@PathVariable("id2") int id2, @RequestParam(required=false) String nome2) {
		//if(nome2 != null) { Como é String, tem fazer strcmp
		//if(nome2 != null) {
//		
		if(nome2 == null) {
			return "Olá mundo --> Valor passado: "+id2;		
		} else {
			return "Olá mundo -->"+nome2+"-->Valor passado: "+id2;
//			return "Olá mundo --> Valor passado: "+id2;
		}
		
		//return "Olá mundo --> Valor passado: "+id2;	
	}
	
	@GetMapping("teste/{id3}")
	public ResponseEntity<?> buscar(@PathVariable("id3") int id3) {
		if(id3 == 1234) {
			return ResponseEntity.ok().header("Content-Type","text/html").body("1234");
		} else {
			return ResponseEntity.notFound().header("Content-Type","text/html").build();
		}
	}
	
//	@PostMapping("/new/users")
//	@ResponseStatus(HttpStatus.CREATED)
//	public Map<String, String> registerUser(@RequestParam Map<String, String> userMap) {
//		try {
//			System.out.println("User ID:" + userMap.get("userName"));
//			System.out.println("User ID:" + userMap.get("password"));
//			
//		} catch (Exception e){
////		}	catch (FileNotFoundException f) {
//			if(userMap.get("usarName") == null) {
//				System.out.println("Faltou o userName");
//			}
//		}
//		
//		return userMap;
//	}
	
	
//	@PostMapping(value = "/user", method = RequestMethod.POST)
	@PostMapping("/user")
	public String saveUser(@ModelAttribute Usuario user) {	
			System.out.println("User ID:" + user.getID());
			System.out.println("User ID:" + user.getUsername());
			System.out.println("User ID:" + user.getPassword());
			
			return user.getUsername();
			
	}

}
