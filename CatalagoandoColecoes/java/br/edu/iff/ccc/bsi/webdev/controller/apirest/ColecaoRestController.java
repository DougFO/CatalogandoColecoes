//package br.edu.iff.ccc.bsi.webdev.controller.apirest;
//
//import java.text.ParseException;
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import br.edu.iff.ccc.bsi.webdev.entities.Colecao;
//import br.edu.iff.ccc.bsi.webdev.entities.Item;
//import br.edu.iff.ccc.bsi.webdev.service.ColecaoService;
////Depois comentar essa linha, essas opreações devem ser feitas na coleção
//import br.edu.iff.ccc.bsi.webdev.service.ItemService;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.annotations.responses.ApiResponses;
//import io.swagger.v3.oas.annotations.tags.Tag;
//import io.swagger.v3.oas.annotations.media.Content;
//import io.swagger.v3.oas.annotations.media.Schema;
//
//@RestController
//@RequestMapping(path = "api/v1/colecao")
//@Tag(name = "Coleção", description = "Controller APIREST de Coleção")
//public class ColecaoRestController {
//	
//	@Autowired
//	ColecaoService colecaoService = new ColecaoService();
//
//	//Depois comentar essa linha, essas opreações devem ser feitas na coleção
//	@Autowired
//	ItemService itemService = new ItemService();
//
//	@PostMapping(path = "")
//	//@ResponseBody
//	@Operation(summary = "Cadastrando uma coleção")
////	@ApiResponses({
////	    @ApiResponse(responseCode = "201", content = {
////	        @Content(schema = @Schema(implementation = Colecao.class), mediaType = "application/json"),
////	    }, description = "Coleção Cadastrada"),
////	    @ApiResponse(responseCode = "500", content = {
////	        @Content(schema = @Schema(implementation = ErrorResponse.class), mediaType = "application/json")
////	    }, description = "Internal server error")
////	})
//	//public String save(@RequestParam Map<String,String> colecaoMap) throws ParseException {
//	//public ResponseEntity<Colecao> save(@RequestParam Map<String,String> colecaoMap) throws ParseException {
//	public Colecao save(@RequestParam Map<String,String> colecaoMap) throws ParseException {
//		
//		String cpfPessoa = colecaoMap.get("pessoa");
//		String isbnItem = colecaoMap.get("item");
//		String nome = colecaoMap.get("nome");
//		String obs = colecaoMap.get("observacao");
//		String data_inicio = colecaoMap.get("data_inicio");
//
//			
////		if(colecaoService.save(nome, obs, data_inicio, cpfPessoa, isbnItem)) {
////			return "Coleção adicionada!";			
////		} else {
////			return "Coleção não adicionada!";
////		}
//		
//		return colecaoService.save(nome, obs, data_inicio, cpfPessoa, isbnItem);
//		
//		//return new ResponseEntity<>(colecaoService.save(nome, obs, data_inicio, cpfPessoa, isbnItem), HttpStatus.CREATED);
//	}
//	
//	@GetMapping("/{cpf}")
//	@ResponseBody
//	@Operation(summary = "Consultando uma coleção")
////	@ApiResponses({
////	    @ApiResponse(responseCode = "201", content = {
////	        @Content(schema = @Schema(implementation = Colecao.class), mediaType = "application/json"),
////	    }, description = "OK"),
////	    @ApiResponse(responseCode = "500", content = {
////	        @Content(schema = @Schema(implementation = ErrorResponse.class), mediaType = "application/json")
////	    }, description = "Internal server error")
////	})
//	public Colecao consultaColecao(@PathVariable("cpf") String cpf) {
//		Colecao colecaoConsultada = colecaoService.consultaColecao(cpf);
//		if(colecaoConsultada != null) {
//			return colecaoConsultada;
//		} else {
//			return null;
//		}		
//	}
//	
//	
//	@PostMapping(path = "/item")
//	@ResponseBody
//	@Operation(summary = "Adicionando um item em uma coleção")
//	public String addItem(@RequestParam Map<String,String> colecaoItemMap) {
//		
//		String cpfPessoa = colecaoItemMap.get("pessoa");
//		String isbnItem = colecaoItemMap.get("item");
//		
//		if((cpfPessoa == "")||(isbnItem == "")) {
//			return "Item não adicionado a coleção(Faltando um dos dados)!";
//		}
//		
//
//		if(colecaoService.AddItem(cpfPessoa, isbnItem)) {
//			return "Item adicionado a coleção!";
//		} else {
//			return "Item não adicionado a coleção!";
//		}
//	}
//	
//	@GetMapping
//	@Operation(summary = "Consultando todas as coleções")
//	@ApiResponses({
//	    @ApiResponse(responseCode = "200", content = {
//	        @Content(schema = @Schema(implementation = Colecao.class), mediaType = "application/json"),
//	    }, description = "OK"),
//	    @ApiResponse(responseCode = "500", content = {
//	        @Content(schema = @Schema(implementation = ErrorResponse.class), mediaType = "application/json")
//	    }, description = "Internal server error")
//	})
//	public List<Colecao> consultaColecoes() {
//		return colecaoService.consultaColecoes();
//	}
//	
//	@PutMapping
//	@ResponseBody
//	@Operation(summary = "Atualizando uma coleção")
//	public String atualizaColecao(@RequestParam Map<String,String> colecaoMap) {
//		if(colecaoService.atualizaColecao(colecaoMap)) {
//			return "Colecação atualizada!";
//		} else {
//			return "Colecação não atualizada!";
//		}
//	}
//	
//	@DeleteMapping("/item")
//	@ResponseBody
//	@Operation(summary = "Deleta um item de uma coleção")
//	public String removeItem(@RequestParam Map<String,String> colecaoMap) {
//		String cpfPessoa = colecaoMap.get("pessoa");
//		String isbnItem = colecaoMap.get("item");
//		
//		if(colecaoService.removeItem(cpfPessoa, isbnItem)) {
//			return "Item removido!";
//		} else {
//			return "Item não removido!";
//		}
//	}
//	
//	@GetMapping("/item/{pessoa}/{item}")
//	@Operation(summary = "Consultando um item de uma coleção")
//	public Item consultaItemColecao(@PathVariable("pessoa") String pessoa, @PathVariable("item") String item) {
//		String cpfPessoa = pessoa;
//		String isbnItem = item;
//		Item i =  colecaoService.consultaItemColecao(cpfPessoa, isbnItem);
//		if(i != null) {
//			return i;
//		} else {
//			return null;
//		}
//		
//		
//	}
//	
//	@GetMapping("/item/{pessoa}")
//	@Operation(summary = "Consultando todos os itens de uma coleção")
//	public List<Item> ConsultaItensColecao(@PathVariable("pessoa") String cpf) {
//		List<Item> itens = colecaoService.consultaItens(cpf);
//		if(itens != null) {
//			return itens;
//		} else {
//			return null;
//		}
//	}
//	
//	@DeleteMapping
//	@ResponseBody
//	@Operation(summary = "Deleta uma coleção")
//	public String removeColecao(@RequestParam Map<String,String> colecaoMap) {
//		String cpfPessoa = colecaoMap.get("pessoa");
//		if(colecaoService.removeColecao(cpfPessoa)) {
//			return "Coleção removida!";
//		} else {
//			return "Colecão não removida!";
//		}
//	}
//}
