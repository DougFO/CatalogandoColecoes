package br.edu.iff.ccc.bsi.webdev.entities;

import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;

@Entity
public class Hq extends Item{
	
	//private static final long serialVersionUID = 1L;
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private Long ID;
	
	public Hq(String isbn, String titulo, String volume, String autor, String desenhista,
			String genero, String editoraNacional, String observacao, float valor, int qtd_paginas) {
		super(isbn, titulo, volume, autor, desenhista,
				genero, editoraNacional, observacao,valor,qtd_paginas);
		
	}

	
	private String editoraOriginal,personagemGrupo;	
	
	public Hq() {
		
	}

	public String getEditoraOriginal() {
		return editoraOriginal;
	}

	public void setEditoraOriginal(String editoraOriginal) {
		this.editoraOriginal = editoraOriginal;
	}

	public String getPersonagemGrupo() {
		return personagemGrupo;
	}

	public void setPersonagemGrupo(String personagemGrupo) {
		this.personagemGrupo = personagemGrupo;
	}
	
	
}
