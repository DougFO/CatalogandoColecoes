package br.edu.iff.ccc.bsi.webdev.entities;

import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;


@Entity
public class Manga extends Item{
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private Long ID;
	
	public Manga(String isbn, String titulo, String volume, String autor, String desenhista,
			String genero, String editoraNacional, String observacao, float valor, int qtd_paginas) {
		super(isbn, titulo, volume, autor, desenhista,
			genero, editoraNacional, observacao,valor,qtd_paginas);
	}	
	
	private int tipo;
	
	public Manga() {
		
	}
		
	public TipoManga getTipo() {
		return TipoManga.toEnum(tipo);
	}

	public void setTipo(TipoManga tipo) {
		this.tipo = tipo.getCode();
	}
	
	
}
