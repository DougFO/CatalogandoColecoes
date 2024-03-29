package br.edu.iff.ccc.bsi.webdev.controller.apirest;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import br.edu.iff.ccc.bsi.webdev.entities.Hq;
import br.edu.iff.ccc.bsi.webdev.entities.Item;
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
	ResponseEntity<Item> save(Item item, @RequestParam Map<String,String> itemMap) {

		return new ResponseEntity<>(itemService.save(item,itemMap), HttpStatus.CREATED);		
	}
	
	
	@PutMapping
	@Operation(summary = "Atualizando dados de um Item")
	@ApiResponses({
    @ApiResponse(responseCode = "200", content = {
        @Content(schema = @Schema(implementation = Pessoa.class), mediaType = "application/json"),
    }, description = "Dados do Item Atualizada"),
    @ApiResponse(responseCode = "500", content = {
        @Content(schema = @Schema(implementation = ErrorResponse.class), mediaType = "application/json")
    }, description = "Internal server error")
})
	ResponseEntity<Item> atualizar(Item item, @RequestParam Map<String,String> itemMap) {

			
			return new ResponseEntity<>(itemService.atualizar(item,itemMap), HttpStatus.CREATED);			
		}
	
	
	
	@DeleteMapping
	@Operation(summary = "Excluindo dados de um Item")
	@ApiResponses({
    @ApiResponse(responseCode = "200", content = {
        @Content(schema = @Schema(implementation = Pessoa.class), mediaType = "application/json"),
    }, description = "Dados da Item Removidos"),
    @ApiResponse(responseCode = "500", content = {
        @Content(schema = @Schema(implementation = ErrorResponse.class), mediaType = "application/json")
    }, description = "Internal server error")
})
	ResponseEntity<Item> remover(Item item) {

		
		return new ResponseEntity<>(itemService.remover(item), HttpStatus.CREATED);			
	}
}
