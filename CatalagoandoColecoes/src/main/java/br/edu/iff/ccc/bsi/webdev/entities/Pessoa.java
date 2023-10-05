package br.edu.iff.ccc.bsi.webdev.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Pessoa {
	
	//private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ID;
	
	@NotEmpty(message = "Cpf não pode ser nulo")
	@Column(nullable = false)
	private String cpf;
	
	@NotEmpty(message = "Nome não pode ser nulo")
	@Column(nullable = false)
	private String nome;
	
	@NotEmpty(message = "Email não pode ser nulo")
	@Column(nullable = false)
	private String email;
	
	@Embedded
	private Endereco endereco;
	
	@NotNull(message = "Usuario não pode ser nulo")
//	@OneToOne(cascade=CascadeType.PERSIST)
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fk_usuario")
	private Usuario usuario;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fk_colecao",nullable = true)
	private Colecao colecao;
	
	public Long getID() {
		return ID;
	}
	public void setID(Long iD) {
		ID = iD;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Colecao getColecao() {
		return colecao;
	}
	public void setColecao(Colecao colecao) {
		this.colecao = colecao;
	}
	
	
	
}
