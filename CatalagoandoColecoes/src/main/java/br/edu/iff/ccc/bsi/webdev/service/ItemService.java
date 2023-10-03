package br.edu.iff.ccc.bsi.webdev.service;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iff.ccc.bsi.webdev.entities.Hq;
import br.edu.iff.ccc.bsi.webdev.entities.Item;
import br.edu.iff.ccc.bsi.webdev.entities.Manga;
import br.edu.iff.ccc.bsi.webdev.entities.TipoManga;
import br.edu.iff.ccc.bsi.webdev.repository.HqRepository;
import br.edu.iff.ccc.bsi.webdev.repository.ItemRepository;
import br.edu.iff.ccc.bsi.webdev.repository.MangaRepository;

@Service
public class ItemService {
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private MangaRepository mangaRepository;
	
	@Autowired
	private HqRepository hqRepository;

	public Item save(Item item, Map<String,String> itemMap) {
		String opcao = itemMap.get("opcao");
		if(itemRepository.verificaItem(item.getIsbn()) == null) {
				if(opcao != null) {
					if((opcao.compareTo("manga") != 0)&&(opcao.compareTo("hq") != 0)) {
						return null;
					}
				} else {
					return null;
				}
				
				if(opcao.compareTo("manga") == 0) {
					int tipo = Integer.parseInt(itemMap.get("tipo"));
					TipoManga tipoManga;		
					tipoManga = TipoManga.toEnum(tipo);
					Manga manga = new Manga(item.getIsbn(),item.getTitulo(),item.getVolume(),item.getAutor(),item.getDesenhista(),item.getGenero(),item.getEditoraNacional(),item.getObservacao(),item.getValor(),item.getQtd_paginas());
					manga.setTipo(tipoManga);
		
					Manga m = mangaRepository.save(manga);
					return m;					
				} 
				
				if(opcao.compareTo("hq") == 0) {
					String editoraOriginal = itemMap.get("editoraOriginal");
					String personagemGrupo = itemMap.get("personagemGrupo");
					
					Hq hQ = new Hq(item.getIsbn(),item.getTitulo(),item.getVolume(),item.getAutor(),item.getDesenhista(),item.getGenero(),item.getEditoraNacional(),item.getObservacao(),item.getValor(),item.getQtd_paginas());
					hQ.setEditoraOriginal(editoraOriginal);
					hQ.setPersonagemGrupo(personagemGrupo);
					
					Hq h = hqRepository.save(hQ);
					return h;						
				}
		} else {
			System.out.println("Item já está cadastrado!");
		}
		return null;
	}
	
	public Item consultaItem(String isbn) {
		if(itemRepository.verificaItem(isbn) != null) {
			Map<String,String> itemConsultado = itemRepository.consultaItem(isbn);
			Item item = new Item();
			item.setID(Long.parseLong(String.valueOf(itemConsultado.get("ID"))));
			item.setAutor(itemConsultado.get("AUTOR"));
			item.setDesenhista(itemConsultado.get("DESENHISTA"));
			item.setEditoraNacional(itemConsultado.get("EDITORANACIONAL"));
			item.setGenero(itemConsultado.get("GENERO"));
			item.setIsbn(itemConsultado.get("ISBN"));
			item.setObservacao(itemConsultado.get("OBSERVACAO"));
			item.setQtd_paginas(Integer.parseInt(String.valueOf(itemConsultado.get("QTD_PAGINAS"))));
			item.setTitulo(itemConsultado.get("TITULO"));
			item.setValor(Float.parseFloat(String.valueOf(itemConsultado.get("VOLUME"))));
			item.setVolume(itemConsultado.get("VOLUME"));
			
			return item;
		} else {
			System.out.println("Item consultado não está cadastrado!");
			return null;
		}	
	}
	
	public ArrayList<Item> consultaItens() {
		return (ArrayList<Item>) itemRepository.findAll();
	}
	
	public Item consultaItemById(Long id) {
		Map<String,String> itemConsultado = itemRepository.consultaItemByID(id);
		Item item = new Item();
		item.setID(Long.parseLong(String.valueOf(itemConsultado.get("ID"))));
		item.setAutor(itemConsultado.get("AUTOR"));
		item.setDesenhista(itemConsultado.get("DESENHISTA"));
		item.setEditoraNacional(itemConsultado.get("EDITORANACIONAL"));
		item.setGenero(itemConsultado.get("GENERO"));
		item.setIsbn(itemConsultado.get("ISBN"));
		item.setObservacao(itemConsultado.get("OBSERVACAO"));
		item.setQtd_paginas(Integer.parseInt(String.valueOf(itemConsultado.get("QTD_PAGINAS"))));
		item.setTitulo(itemConsultado.get("TITULO"));
		item.setValor(Float.parseFloat(String.valueOf(itemConsultado.get("VOLUME"))));
		item.setVolume(itemConsultado.get("VOLUME"));
		
		return item;
	}
	
	public Long consultaIdItem(String isbn) {
		if(itemRepository.consultaIdItem(isbn) != null) {
			return itemRepository.consultaIdItem(isbn);
		}	else {
			return null;
		}
	}
	
	public boolean verificaItem(String isbn) {
		if(itemRepository.verificaItem(isbn) == null) {
			return false;
		} else {
			return true;
		}
	}
	
	
	public Item atualizar(String isbn, Item item, Map<String,String>itemMap) {
		String opcao = itemMap.get("opcao");
		
		if(itemRepository.verificaItem(isbn) != null) {
				Long idItem = itemRepository.consultaIdItem(isbn);
				item.setID(idItem);
				if(opcao != null) {
					if((opcao.compareTo("manga") != 0)&&(opcao.compareTo("hq") != 0)) {
						return null;
					}
				} else {
					return null;
				}
				
				if(opcao.compareTo("manga") == 0) {
					int tipo = Integer.parseInt(itemMap.get("tipo"));
					TipoManga tipoManga;		
					tipoManga = TipoManga.toEnum(tipo);
					Manga manga = new Manga(item.getIsbn(),item.getTitulo(),item.getVolume(),item.getAutor(),item.getDesenhista(),item.getGenero(),item.getEditoraNacional(),item.getObservacao(),item.getValor(),item.getQtd_paginas());
					manga.setTipo(tipoManga);
					manga.setID(idItem);
					Manga m = mangaRepository.saveAndFlush(manga);
					if(m.equals(null)) {
						return null;
					} else {
						return (Item) m;
					}
				} 
				
				if(opcao.compareTo("hq") == 0) {
					String editoraOriginal = itemMap.get("editoraOriginal");
					String personagemGrupo = itemMap.get("personagemGrupo");
					
					Hq hQ = new Hq(item.getIsbn(),item.getTitulo(),item.getVolume(),item.getAutor(),item.getDesenhista(),item.getGenero(),item.getEditoraNacional(),item.getObservacao(),item.getValor(),item.getQtd_paginas());
					hQ.setEditoraOriginal(editoraOriginal);
					hQ.setPersonagemGrupo(personagemGrupo);
					hQ.setID(idItem);
					Hq h = hqRepository.saveAndFlush(hQ);
					if(h.equals(null)) {
						return null;
					} else {
						return (Item) h;
					}
				}
		} else {
			System.out.println("O Item não está cadastrado!");
		}

		return null;
	}
	
	
	public Item remover(String isbn) {
		if(itemRepository.verificaItem(isbn) != null) {
			Long idItem = itemRepository.consultaIdItem(isbn);
			Item item = this.consultaItem(isbn);
			itemRepository.deleteById(idItem);
			return item;
		} else {
			System.out.println("O Item não está cadastrado!");
		}
		return null;
	}


}
