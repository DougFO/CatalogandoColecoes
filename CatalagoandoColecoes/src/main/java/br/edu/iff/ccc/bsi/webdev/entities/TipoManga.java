package br.edu.iff.ccc.bsi.webdev.entities;

public enum TipoManga {
	Shonen(1), Shoujo(2), Seinen(3), Kodomo(4), Josei(5);
	
	private final int code;
	
	private TipoManga(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static TipoManga toEnum(int code) {
		for(TipoManga m : TipoManga.values()) {
			if(m.getCode()==code) {
				return m;
			}
		}
		return null;
	}
}
