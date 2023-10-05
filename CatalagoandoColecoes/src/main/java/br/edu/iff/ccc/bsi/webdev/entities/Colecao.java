package br.edu.iff.ccc.bsi.webdev.entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
//import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Schema(
	    title = "Colecao",
	    description = "Parameter required to create or update a colection",
	    requiredMode = Schema.RequiredMode.REQUIRED
	)
public class Colecao {
	
	//private static final long serialVersionUID = 1L;
//	 @Schema(description = "Identificador da coleção.", 
//	            example = "1")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ID;
	

	@OneToOne(mappedBy="colecao")
	private Pessoa pessoa;
	
	@Size(min=1, message = "A coleção deve contem pelo menos 1 item")
	@ManyToMany
	@JoinTable(name = "item_colecao",
			   joinColumns = @JoinColumn(name = "fk_colecao"),
			   inverseJoinColumns = @JoinColumn(name = "fk_item"))
	private List<Item> itens = new ArrayList<Item>();	
	
	
	@Schema(description = "Nome da coleção.", 
    example = "DC")
	@NotNull(message = "Nome não pode ser nulo")
	private String nome;
	 
 	@Schema(description = "Observação da coleção.", 
	example = "testeDC") 
	private String observacao;
 	
	@Schema(description = "Data de criação da coleção.", 
    example = "22/08/2014")
	@NotNull(message = "Data de início da coleção não pode ser nula")
	private Calendar data_inicio;
	
	public Colecao() {
		
	}
	
	public Colecao(String nome, String observacao, Calendar data_inicio, Pessoa pessoa) {
		this.nome = nome;
		this.observacao = observacao;
		this.data_inicio = data_inicio;
		this.pessoa = pessoa;
	}
	
	public void addItem(Item item) {
		this.itens.add(item);
	}
	
	public List<Item> getItens() {
		List<Item> itensR = this.itens;
		return itensR;
	}
	
	public boolean itemIsSet(Item item) {
		for(int i=0; i<this.itens.size(); i++) {
			if(this.itens.get(i).getIsbn().compareTo(item.getIsbn()) == 0) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean removeItem(Item item) {
		for(int i=0; i<this.itens.size(); i++) {
			if(this.itens.get(i).getIsbn().compareTo(item.getIsbn()) == 0) {
				Item itemVerificador = this.itens.remove(i);
				if(itemVerificador == null) {
					return false;
				} else {
					return true;					
				}
			}
		}
		
		return false;
	}
	
	public Long getID() {
		return ID;
	}
	public void setID(Long iD) {
		ID = iD;
	}
//	public Pessoa getPessoa() {
//		return pessoa;
//	}
//	public void setPessoa(Pessoa pessoa) {
//		this.pessoa = pessoa;
//	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public Calendar getData_inicio() {
		return data_inicio;
	}
	public void setData_inicio(Calendar data_inicio) {
		this.data_inicio = data_inicio;
	}
	
	
}
