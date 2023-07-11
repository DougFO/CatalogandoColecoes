package br.edu.iff.ccc.bsi.webdev.entities;

import jakarta.persistence.Entity;


@Entity
public class Manga extends Item{
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private Long ID;
	
	private int tipo;

	public TipoManga getTipo() {
		return TipoManga.toEnum(tipo);
	}

	public void setTipo(TipoManga tipo) {
		this.tipo = tipo.getCode();
	}
	
	
}
