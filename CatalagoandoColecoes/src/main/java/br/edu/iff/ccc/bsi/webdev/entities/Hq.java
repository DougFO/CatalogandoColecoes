package br.edu.iff.ccc.bsi.webdev.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Hq extends Item{
	
	//private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ID;
	
	private String editoraOriginal,personagemGrupo;

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
