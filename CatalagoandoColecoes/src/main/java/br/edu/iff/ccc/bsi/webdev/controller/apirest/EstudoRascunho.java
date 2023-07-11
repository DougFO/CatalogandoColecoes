package br.edu.iff.ccc.bsi.webdev.controller.apirest;
import java.util.Map;


//@RestController
//@RequestMapping(path = "/api")
public class EstudoRascunho {
	
	//estudoI
//	@GetMapping
//	@ResponseBody
//	public String initial() {
//		return "Olá, bem vindo a API do meu app";
//	}
	//estudoF

	//estudoI
//	@GetMapping("/{id}")
//	public String page(@PathVariable("id") int id) {
//		return "Olá mundo -->"+id;
//	}
	//estudoF
	
	
	//estudoI
//	@GetMapping("/find")
//	public String page2(@RequestParam String nome) {
//		return "Olá mundo -->"+nome;
//	}
	//estudoF
	
	
	//estudoI
//	@GetMapping("/testeVeP/{id2}")
//	//public String page2(@PathVariable("id2") int id2, @RequestParam String nome2) {
//	//public String page2(@PathVariable("id2") int id2, @RequestParam String nome2 (required=false)) {
//	public String page2(@PathVariable("id2") int id2, @RequestParam(required=false) String nome2) {
//		//if(nome2 != null) { Como é String, tem fazer strcmp
//		//if(nome2 != null) {
////		
//		if(nome2 == null) {
//			return "Olá mundo --> Valor passado: "+id2;		
//		} else {
//			return "Olá mundo -->"+nome2+"-->Valor passado: "+id2;
////			return "Olá mundo --> Valor passado: "+id2;
//		}
//		
//		//return "Olá mundo --> Valor passado: "+id2;	
//	}
	//estudoF
	
	//estudoI
//	@GetMapping("teste/{id3}")
//	public ResponseEntity<?> buscar(@PathVariable("id3") int id3) {
//		if(id3 == 1234) {
//			return ResponseEntity.ok().header("Content-Type","text/html").body("1234");
//		} else {
//			return ResponseEntity.notFound().header("Content-Type","text/html").build();
//		}
//	}
	//estudoF
	
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
	
	
	//estudoI
////	@PostMapping(value = "/user", method = RequestMethod.POST)
//	@PostMapping("/user")
//	@ResponseBody
//	public String saveUser(@ModelAttribute Usuario user) {	
//			System.out.println("User ID:" + user.getID());
//			System.out.println("User ID:" + user.getUsername());
//			System.out.println("User ID:" + user.getPassword());
//			
//			//return user.getUsername();
//			return "Funfou!"+user.getUsername();
//			
//	}
	//estudoF
	
	
////	@PostMapping(value = "/user", method = RequestMethod.POST)
//	@PostMapping(value = "/user/estudo")
//	@ResponseBody
//	//@PostMapping("/user/estudo")
//	public String saveUserEstudo(@ModelAttribute Usuario user) {	
////			System.out.println("User ID:" + user.getID());
////			System.out.println("User ID:" + user.getUsername());
////			System.out.println("User ID:" + user.getPassword());
//			
//			
//			//return "Funcionou"+$_POST["tUserName"];
//			return "Funcionou";
//			//return user.getUsername();
//			
//	}
	
	
	//estudoI
//	@Autowired
//	private UsuarioRepository res;
//	
//	
//	
////	@PostMapping(value = "/user", method = RequestMethod.POST)
////	@PostMapping(value = "/user/cadastroUsuario")
//	@PostMapping(value = "/cadastroUsuario/save")
//	@ResponseBody
//	//@PostMapping("/user/estudo")
//	public String saveUserEstudo( Usuario user) {	
////			System.out.println("User ID:" + user.getID());
////			System.out.println("User ID:" + user.getUsername());
////			System.out.println("User ID:" + user.getPassword());
//			
//			Usuario u = res.save(user);
//			//return "Funcionou"+$_POST["tUserName"];
//			//return "Funcionou";
//			return "Usuário adicionado --> "+u.getID()+" --> ";
//			//return user.getUsername();
//			
//	}
	//estudoF
	
	
	
	
	
	
}

