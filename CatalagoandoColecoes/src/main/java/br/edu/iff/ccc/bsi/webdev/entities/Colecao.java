package br.edu.iff.ccc.bsi.webdev.entities;

import java.util.Calendar;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Colecao {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ID;
	
	@OneToOne
	@JoinColumn(name="fk_pessoa",nullable = false)
	//@Column(nullable = false)
	private Pessoa pessoa;
	
	@ManyToMany
	@JoinTable(name = "item_colecao",
			   joinColumns = @JoinColumn(name = "fk_colecao"),
			   inverseJoinColumns = @JoinColumn(name = "fk_item"))
	private List<Item> itens;
	
	private String nome,observacao;
	private Calendar data_inicio;
	public Long getID() {
		return ID;
	}
	public void setID(Long iD) {
		ID = iD;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
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
