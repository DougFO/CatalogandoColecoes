package br.edu.iff.ccc.bsi.webdev.controller.apirest;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import br.edu.iff.ccc.bsi.webdev.entities.Hq;
import br.edu.iff.ccc.bsi.webdev.entities.Item;
import br.edu.iff.ccc.bsi.webdev.entities.Manga;
import br.edu.iff.ccc.bsi.webdev.entities.Pessoa;
import br.edu.iff.ccc.bsi.webdev.service.ItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
@RequestMapping(path = "api/v1/item")
@Tag(name = "Item", description = "Controller APIREST de Item")
public class ItemRestController {
	
	@Autowired
	ItemService itemService;

	@PostMapping
	@Operation(summary = "Cadastrando um item")
	@ApiResponses({
	    @ApiResponse(responseCode = "201", content = {
	        @Content(schema = @Schema(implementation = Pessoa.class), mediaType = "application/json"),
	    }, description = "Item Cadastrado"),
	    @ApiResponse(responseCode = "500", content = {
	        @Content(schema = @Schema(implementation = ErrorResponse.class), mediaType = "application/json")
	    }, description = "Internal server error")
	})
//	public String save(Item item, @RequestParam Map<String,String> itemMap) {
//	public String save(Item item) {
	ResponseEntity<Item> save(Item item, @RequestParam Map<String,String> itemMap) {
	//public ResponseEntity<Item> save(@RequestParam Map<String,String> colecaoMap) {
		
		return new ResponseEntity<>(itemService.save(item,itemMap), HttpStatus.CREATED);
//		if(itemService.save(item, itemMap)) {
//		if(itemService.save(item, itemMap)) {
//			return "Item adicionado!";
//		} else {
//			return "Item não adicionado!";
//		}
		
	}
	
	
	
	@PutMapping("/{isbn}")
	@Operation(summary = "Atualizando dados de um Item")
	@ApiResponses({
    @ApiResponse(responseCode = "200", content = {
        @Content(schema = @Schema(implementation = Pessoa.class), mediaType = "application/json"),
    }, description = "Dados do Item Atualizada"),
    @ApiResponse(responseCode = "500", content = {
        @Content(schema = @Schema(implementation = ErrorResponse.class), mediaType = "application/json")
    }, description = "Internal server error")
})
	ResponseEntity<Item> atualizar(@PathVariable("isbn") String isbn, Item item, @RequestParam Map<String,String> itemMap) {

			
			return new ResponseEntity<>(itemService.atualizar(isbn,item,itemMap), HttpStatus.OK);			
		}
	
	
	@DeleteMapping("/{isbn}")
	@Operation(summary = "Excluindo dados de um Item")
	@ApiResponses({
    @ApiResponse(responseCode = "200", content = {
        @Content(schema = @Schema(implementation = Pessoa.class), mediaType = "application/json"),
    }, description = "Dados da Item Removidos"),
    @ApiResponse(responseCode = "500", content = {
        @Content(schema = @Schema(implementation = ErrorResponse.class), mediaType = "application/json")
    }, description = "Internal server error")
})
	ResponseEntity<Item> remover(@PathVariable("isbn") String isbn) {

		System.out.println("TesteIsbn: "+isbn);
		return new ResponseEntity<>(itemService.remover(isbn), HttpStatus.OK);			
	}
	
	
	@GetMapping
	@Operation(summary = "Consultando todos Itens cadastrados")
	@ApiResponses({
    @ApiResponse(responseCode = "201", content = {
        @Content(schema = @Schema(implementation = Pessoa.class), mediaType = "application/json"),
    }, description = "Itens encontrados"),
    @ApiResponse(responseCode = "500", content = {
        @Content(schema = @Schema(implementation = ErrorResponse.class), mediaType = "application/json")
    }, description = "Internal server error")
})
	ResponseEntity<ArrayList<Item>> consultaItens() {		
		return new ResponseEntity<>(itemService.consultaItens(), HttpStatus.OK);
	}
	
	
	@GetMapping("/{isbn}")
	@Operation(summary = "Consultando um Item cadastrado pelo ISBN")
	@ApiResponses({
    @ApiResponse(responseCode = "201", content = {
        @Content(schema = @Schema(implementation = Item.class), mediaType = "application/json"),
    }, description = "Item encontrado"),
    @ApiResponse(responseCode = "500", content = {
        @Content(schema = @Schema(implementation = ErrorResponse.class), mediaType = "application/json")
    }, description = "Internal server error")
})
	ResponseEntity<Item> consultaItem(@PathVariable("isbn") String isbn) {		
		return new ResponseEntity<>(itemService.consultaItem(isbn), HttpStatus.OK);
	}
	
	
	@GetMapping("/{isbn}/manga")
	@Operation(summary = "Consultando um Item cadastrado pelo ISBN")
	@ApiResponses({
    @ApiResponse(responseCode = "201", content = {
        @Content(schema = @Schema(implementation = Item.class), mediaType = "application/json"),
    }, description = "Item encontrado"),
    @ApiResponse(responseCode = "500", content = {
        @Content(schema = @Schema(implementation = ErrorResponse.class), mediaType = "application/json")
    }, description = "Internal server error")
})
	ResponseEntity<Manga> consultaManga(@PathVariable("isbn") String isbn) {		
		return new ResponseEntity<>(itemService.consultaManga(isbn), HttpStatus.OK);
	}
}
