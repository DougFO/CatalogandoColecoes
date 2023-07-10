package br.edu.iff.ccc.bsi.webdev.entities;

import java.util.Calendar;

public class Colecao {
	private Long ID;
	private Pessoa pessoa;
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
