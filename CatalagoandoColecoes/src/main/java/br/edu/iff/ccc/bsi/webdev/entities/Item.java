package br.edu.iff.ccc.bsi.webdev.entities;

public class Item {
	private Long ID;
	private String isbn,autor,desenhista,genero,editoraNacional,volume,observacao;
	private int qtd_paginas;
	private float valor;
	public Long getID() {
		return ID;
	}
	public void setID(Long iD) {
		ID = iD;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getDesenhista() {
		return desenhista;
	}
	public void setDesenhista(String desenhista) {
		this.desenhista = desenhista;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getEditoraNacional() {
		return editoraNacional;
	}
	public void setEditoraNacional(String editoraNacional) {
		this.editoraNacional = editoraNacional;
	}
	public String getVolume() {
		return volume;
	}
	public void setVolume(String volume) {
		this.volume = volume;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public int getQtd_paginas() {
		return qtd_paginas;
	}
	public void setQtd_paginas(int qtd_paginas) {
		this.qtd_paginas = qtd_paginas;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	
	
	

}
