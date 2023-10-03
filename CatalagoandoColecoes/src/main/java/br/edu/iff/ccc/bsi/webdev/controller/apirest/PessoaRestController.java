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

import br.edu.iff.ccc.bsi.webdev.entities.Colecao;
import br.edu.iff.ccc.bsi.webdev.entities.Endereco;
import br.edu.iff.ccc.bsi.webdev.entities.Item;
import br.edu.iff.ccc.bsi.webdev.entities.Pessoa;
import br.edu.iff.ccc.bsi.webdev.entities.Usuario;
import br.edu.iff.ccc.bsi.webdev.service.PessoaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
@RequestMapping(path = "api/v1/pessoa")
@Tag(name = "Pessoa", description = "Controller APIREST de Pessoa")
public class PessoaRestController {
	
	@Autowired
	PessoaService pessoaService;
	
	@PostMapping
	@Operation(summary = "Cadastrando uma pessoa")
	@ApiResponses({
    @ApiResponse(responseCode = "201", content = {
        @Content(schema = @Schema(implementation = Pessoa.class), mediaType = "application/json"),
    }, description = "Coleção Cadastrada"),
    @ApiResponse(responseCode = "500", content = {
        @Content(schema = @Schema(implementation = ErrorResponse.class), mediaType = "application/json")
    }, description = "Internal server error")
})
	ResponseEntity<Pessoa> save(Pessoa pessoa, Usuario user, Endereco endereco) {
		
		return new ResponseEntity<>(pessoaService.save(user, pessoa, endereco), HttpStatus.CREATED);
	}
	
	
	
	@DeleteMapping("/{cpf}")
	@Operation(summary = "Excluindo dados de uma pessoa")
	@ApiResponses({
    @ApiResponse(responseCode = "200", content = {
        @Content(schema = @Schema(implementation = Pessoa.class), mediaType = "application/json"),
    }, description = "Dados da Pessoa Removidos"),
    @ApiResponse(responseCode = "500", content = {
        @Content(schema = @Schema(implementation = ErrorResponse.class), mediaType = "application/json")
    }, description = "Internal server error")
})
	public ResponseEntity<Pessoa> remove(@PathVariable("cpf") String cpf) {
		
		return new ResponseEntity<>(pessoaService.remove(cpf), HttpStatus.OK);
	}
	
	
	
	@PutMapping("/{cpf}")
	@Operation(summary = "Atualizando dados de uma pessoa")
	@ApiResponses({
    @ApiResponse(responseCode = "200", content = {
        @Content(schema = @Schema(implementation = Pessoa.class), mediaType = "application/json"),
    }, description = "Dados da Pessoa Atualizada"),
    @ApiResponse(responseCode = "500", content = {
        @Content(schema = @Schema(implementation = ErrorResponse.class), mediaType = "application/json")
    }, description = "Internal server error")
})
	public ResponseEntity<Pessoa> atualizar(@PathVariable("cpf") String cpf,Pessoa pessoa, Usuario user, Endereco endereco) {
		
		return new ResponseEntity<>(pessoaService.atualizar(user, pessoa, endereco, cpf), HttpStatus.OK);
	}
	
	
	@GetMapping("/{cpf}")
	@Operation(summary = "Consultando Pessoa pelo CPF")
	@ApiResponses({
    @ApiResponse(responseCode = "201", content = {
        @Content(schema = @Schema(implementation = Pessoa.class), mediaType = "application/json"),
    }, description = "Pessoa encontrada"),
    @ApiResponse(responseCode = "500", content = {
        @Content(schema = @Schema(implementation = ErrorResponse.class), mediaType = "application/json")
    }, description = "Internal server error")
})
	ResponseEntity<Pessoa> consultaPessoa(@PathVariable("cpf") String cpf) {		
		return new ResponseEntity<>(pessoaService.consultaPessoa(cpf), HttpStatus.CREATED);
	}
	
	
	
	@GetMapping
	@Operation(summary = "Consultando todas Pessoas cadastradas")
	@ApiResponses({
    @ApiResponse(responseCode = "201", content = {
        @Content(schema = @Schema(implementation = Pessoa.class), mediaType = "application/json"),
    }, description = "Pessoa encontrada"),
    @ApiResponse(responseCode = "500", content = {
        @Content(schema = @Schema(implementation = ErrorResponse.class), mediaType = "application/json")
    }, description = "Internal server error")
})
	ResponseEntity<ArrayList<Pessoa>> consultaPessoas() {		
		return new ResponseEntity<>(pessoaService.consultaPessoas(), HttpStatus.CREATED);
	}
	
	
	@PostMapping("/Colecao")
	@Operation(summary = "Cadastrando Coleção de uma pessoa")
	@ApiResponses({
    @ApiResponse(responseCode = "201", content = {
        @Content(schema = @Schema(implementation = Pessoa.class), mediaType = "application/json"),
    }, description = "Coleção Cadastrada"),
    @ApiResponse(responseCode = "500", content = {
        @Content(schema = @Schema(implementation = ErrorResponse.class), mediaType = "application/json")
    }, description = "Internal server error")
})
	ResponseEntity<Pessoa> criarColecao(Pessoa pessoa, Item item, @RequestParam Map<String,String> dadosColecao) {		
		return new ResponseEntity<>(pessoaService.criarColecao(pessoa, item, dadosColecao), HttpStatus.CREATED);
	}

	
	@PutMapping("/{cpf}/Colecao")
	@Operation(summary = "Atualização Coleção de uma pessoa")
	@ApiResponses({
    @ApiResponse(responseCode = "201", content = {
        @Content(schema = @Schema(implementation = Pessoa.class), mediaType = "application/json"),
    }, description = "Coleção Atualização"),
    @ApiResponse(responseCode = "500", content = {
        @Content(schema = @Schema(implementation = ErrorResponse.class), mediaType = "application/json")
    }, description = "Internal server error")
})
	ResponseEntity<Pessoa> atualizarColecao(@PathVariable("cpf") String cpf,Colecao colecao, @RequestParam Map<String,String> dadosAtualizacao) {		
		return new ResponseEntity<>(pessoaService.atualizarColecao(cpf,colecao, dadosAtualizacao), HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/{cpf}/Colecao")
	@Operation(summary = "Exclusão da Coleção de uma pessoa")
	@ApiResponses({
    @ApiResponse(responseCode = "201", content = {
        @Content(schema = @Schema(implementation = Pessoa.class), mediaType = "application/json"),
    }, description = "Coleção removida"),
    @ApiResponse(responseCode = "500", content = {
        @Content(schema = @Schema(implementation = ErrorResponse.class), mediaType = "application/json")
    }, description = "Internal server error")
})
	ResponseEntity<Pessoa> removerColecao(@PathVariable("cpf") String cpf) {		
		return new ResponseEntity<>(pessoaService.removerColecao(cpf), HttpStatus.CREATED);
	}
	
	
	@PostMapping("/{cpf}/Colecao/Item/{isbn}")
	@Operation(summary = "Adicionando Item na Coleção de uma pessoa")
	@ApiResponses({
    @ApiResponse(responseCode = "201", content = {
        @Content(schema = @Schema(implementation = Pessoa.class), mediaType = "application/json"),
    }, description = "Coleção removida"),
    @ApiResponse(responseCode = "500", content = {
        @Content(schema = @Schema(implementation = ErrorResponse.class), mediaType = "application/json")
    }, description = "Internal server error")
})
	ResponseEntity<Pessoa> addItem(@PathVariable("cpf") String cpf, @PathVariable("isbn") String isbn) {		
		return new ResponseEntity<>(pessoaService.addItem(cpf, isbn), HttpStatus.CREATED);
	}
	
	
	
	@DeleteMapping("/{cpf}/Colecao/Item/{isbn}")
	@Operation(summary = "Removendo Item da Coleção de uma pessoa")
	@ApiResponses({
    @ApiResponse(responseCode = "201", content = {
        @Content(schema = @Schema(implementation = Pessoa.class), mediaType = "application/json"),
    }, description = "Item removido da coleção"),
    @ApiResponse(responseCode = "500", content = {
        @Content(schema = @Schema(implementation = ErrorResponse.class), mediaType = "application/json")
    }, description = "Internal server error")
})
	ResponseEntity<Pessoa> removeItem(@PathVariable("cpf") String cpf, @PathVariable("isbn") String isbn) {		
		return new ResponseEntity<>(pessoaService.removeItem(cpf, isbn), HttpStatus.CREATED);
	}
	
	

}
