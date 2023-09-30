package br.edu.iff.ccc.bsi.webdev.controller.apirest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iff.ccc.bsi.webdev.entities.Endereco;
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
	
	
	
	@DeleteMapping
	@Operation(summary = "Excluindo dados de uma pessoa")
	@ApiResponses({
    @ApiResponse(responseCode = "200", content = {
        @Content(schema = @Schema(implementation = Pessoa.class), mediaType = "application/json"),
    }, description = "Dados da Pessoa Removidos"),
    @ApiResponse(responseCode = "500", content = {
        @Content(schema = @Schema(implementation = ErrorResponse.class), mediaType = "application/json")
    }, description = "Internal server error")
})
	public ResponseEntity<Pessoa> remove(Pessoa pessoa) {
		
		return new ResponseEntity<>(pessoaService.remove(pessoa), HttpStatus.OK);
	}

}
