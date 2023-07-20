package br.edu.iff.ccc.bsi.webdev.entities;

import jakarta.persistence.Embeddable;

@Embeddable
public class Endereco {
	
//	private Long ID;
	private String cEP,rua,numero,bairro,cidade,estado;
//	public Long getID() {
//		return ID;
//	}
//	public void setID(Long iD) {
//		ID = iD;
//	}
	public String getCEP() {
		return cEP;
	}
	public void setCEP(String cEP) {
		this.cEP = cEP;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	

}
