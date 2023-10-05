package br.edu.iff.ccc.bsi.webdev.service;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iff.ccc.bsi.webdev.entities.Hq;
import br.edu.iff.ccc.bsi.webdev.entities.Item;
import br.edu.iff.ccc.bsi.webdev.entities.Manga;
import br.edu.iff.ccc.bsi.webdev.entities.Pessoa;
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

	public Item save(Item item, Map<String,String>itemMap) {
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
			item.setEditoraNacional(itemConsultado.get("EDITORA_NACIONAL"));
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
	
//	public boolean verificaManga(String isbn) {
//		if(itemRepository.consultaManga(isbn) != null) {
//				return true;
//		} else {
//			return false;
//		}
//	}
//	
//	public boolean verificaHq(String isbn) {
//		if(itemRepository.consultaHq(isbn) != null) {
//			return true;
//		} else {
//			return false;
//		}
//	}
	
	
	
	
	
	public Manga consultaManga(String isbn) {
		if(itemRepository.verificaItem(isbn) != null) {
			
			
			Map<String,String> itemConsultado = itemRepository.consultaItem(isbn);
			Manga manga = new Manga();
			manga.setID(Long.parseLong(String.valueOf(itemConsultado.get("ID"))));
			manga.setAutor(itemConsultado.get("AUTOR"));
			manga.setDesenhista(itemConsultado.get("DESENHISTA"));
			manga.setEditoraNacional(itemConsultado.get("EDITORA_NACIONAL"));
			manga.setGenero(itemConsultado.get("GENERO"));
			manga.setIsbn(itemConsultado.get("ISBN"));
			manga.setObservacao(itemConsultado.get("OBSERVACAO"));
			manga.setQtd_paginas(Integer.parseInt(String.valueOf(itemConsultado.get("QTD_PAGINAS"))));
			manga.setTitulo(itemConsultado.get("TITULO"));
			manga.setValor(Float.parseFloat(String.valueOf(itemConsultado.get("VOLUME"))));
			manga.setVolume(itemConsultado.get("VOLUME"));
			
			//Manga manga = (Manga) item;
				
			int tipo = itemRepository.consultaManga(isbn);
			TipoManga tipoManga;		
			//System.out.println("TesteT: "+itemConsultado.get("TIPO"));
			//System.out.println("TesteT: "+itemConsultado);
			//int tipo = Integer.valueOf(itemConsultado.get("TIPO")).intValue();
			//System.out.println("TesteT2: "+tipo);
			tipoManga = TipoManga.toEnum(tipo);
			//Manga manga = new Manga(item.getIsbn(),item.getTitulo(),item.getVolume(),item.getAutor(),item.getDesenhista(),item.getGenero(),item.getEditoraNacional(),item.getObservacao(),item.getValor(),item.getQtd_paginas());
			manga.setTipo(tipoManga);
			
			return manga;
			
		} else {
			System.out.println("Item consultado não está cadastrado!");
			return null;
		}	
	}
	
	
	
	public Hq consultaHq(String isbn) {
		if(itemRepository.verificaItem(isbn) != null) {
			
			
			Map<String,String> itemConsultado = itemRepository.consultaItem(isbn);
			Hq hq = new Hq();
			hq.setID(Long.parseLong(String.valueOf(itemConsultado.get("ID"))));
			hq.setAutor(itemConsultado.get("AUTOR"));
			hq.setDesenhista(itemConsultado.get("DESENHISTA"));
			hq.setEditoraNacional(itemConsultado.get("EDITORA_NACIONAL"));
			hq.setGenero(itemConsultado.get("GENERO"));
			hq.setIsbn(itemConsultado.get("ISBN"));
			hq.setObservacao(itemConsultado.get("OBSERVACAO"));
			hq.setQtd_paginas(Integer.parseInt(String.valueOf(itemConsultado.get("QTD_PAGINAS"))));
			hq.setTitulo(itemConsultado.get("TITULO"));
			hq.setValor(Float.parseFloat(String.valueOf(itemConsultado.get("VOLUME"))));
			hq.setVolume(itemConsultado.get("VOLUME"));
								
			//Hq hq =  (Hq) item;
			Map<String,String> dadosHq = itemRepository.consultaHq(isbn);
			hq.setEditoraOriginal(dadosHq.get("EDITORA_ORIGINAL"));
			hq.setPersonagemGrupo(dadosHq.get("PERSONAGEM_GRUPO"));
			
			return hq;
			
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
		item.setEditoraNacional(itemConsultado.get("EDITORA_NACIONAL"));
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
		//if(itemRepository.consultaIdItem(isbn).get("ID") != null) {
		if(itemRepository.consultaIdItem(isbn) != null) {
			//Long IdItemBD = (Long.parseLong(String.valueOf(itemRepository.consultaIdItem(isbn).get("ID"))));
			//return IdItemBD;
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
		System.out.println("TesteISbn S: "+isbn);
		if(itemRepository.verificaItem(isbn) != null) {
			Long idItem = itemRepository.consultaIdItem(isbn);
			Item item = this.consultaItem(isbn);
//			item.setID(idItem);
			itemRepository.deleteById(idItem);
			return item;
		} else {
			System.out.println("O Item não está cadastrado!");
		}
		return null;
	}
	
	/*public ArrayList<Item> consultaPessoasPorNome(String titulo) {
		String tituloP = "%"+titulo+"%";
//		System.out.println("Teste Nome P: "+tituloP);
		ArrayList<Item> itens = (ArrayList<Item>) itemRepository.consultaItensPorTitulo(tituloP);
		
		if(itens.size() != 0) {
			return itens;
		} else {
			return null;
		}	
	}*/
	
	
	public ArrayList<Item> consultaItensPorTitulo(String titulo) {
		String tituloP = "%"+titulo+"%";
		System.out.println("Teste Nome P: "+tituloP);
		ArrayList<Item> itens = (ArrayList<Item>) itemRepository.consultaItensPorTitulo(tituloP);
		
		if(itens.size() != 0) {
			return itens;
		} else {
			return null;
		}	
	}


}
