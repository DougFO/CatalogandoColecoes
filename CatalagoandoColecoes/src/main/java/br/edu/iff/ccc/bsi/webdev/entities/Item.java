package br.edu.iff.ccc.bsi.webdev.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToMany;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Item {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ID;
	
	@Column(nullable = false)
	private String isbn;
	@Column(nullable = false)
	private String titulo;
	@Column(nullable = false)
	private String volume;
	
	@ManyToMany(mappedBy = "itens")
	private List<Colecao> colecoes;
	
	private String autor,desenhista,genero,editoraNacional,observacao;
	private int qtd_paginas;
	private float valor;
		
	
	
	public Item(String isbn, String titulo, String volume, String autor, String desenhista,
			String genero, String editoraNacional, String observacao) {		
		this.isbn = isbn;
		this.titulo = titulo;
		this.volume = volume;
		this.autor = autor;
		this.desenhista = desenhista;
		this.genero = genero;
		this.editoraNacional = editoraNacional;
		this.observacao = observacao;
	}
	
	public Item() {
		
	}
	
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
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
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
