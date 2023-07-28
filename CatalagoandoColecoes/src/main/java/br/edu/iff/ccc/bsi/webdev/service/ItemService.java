package br.edu.iff.ccc.bsi.webdev.service;

import java.util.Objects;

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
	
	//public boolean save(Item item, Manga manga, Hq hq) {
//	public boolean save(Item item, int t, Hq hq) {
	public boolean save(Item item, int t, Hq hq, String opcao) {
	//public boolean save(int t) {
		//Item i = itemRepository.save(item);
		////if (Objects.isNull(hq)) {
		//if (manga.getTipo() == 0) {
			//Manga m = mangaRepository.save(manga);
		//} else {			
			//Manga m = mangaRepository.save(manga);
//			System.out.println("ISBN" + item.getIsbn());
//			//Item i = itemRepository.save(item);
//			//Hq quadrinho = hqRepository.save(hq);
			
//			TipoManga tipoManga;		
//			tipoManga = TipoManga.toEnum(t);
////			//Manga manga = new Manga();
//			Manga manga = new Manga(item.getIsbn(),item.getTitulo(),item.getVolume(),item.getAutor(),item.getDesenhista(),item.getGenero(),item.getEditoraNacional(),item.getObservacao());
//			manga.setTipo(tipoManga);
//			
//			System.out.println("Tipo " + manga.getTipo().getCode());
//
//			Manga m = mangaRepository.save(manga);
//			//mangaRepository.salvar(manga.getTipo().getCode());
		//}
			
			if(opcao.compareTo("manga") == 0) {
				//System.out.println("Testando Mangá: " + opcao);
				TipoManga tipoManga;		
				tipoManga = TipoManga.toEnum(t);
//				//Manga manga = new Manga();
				Manga manga = new Manga(item.getIsbn(),item.getTitulo(),item.getVolume(),item.getAutor(),item.getDesenhista(),item.getGenero(),item.getEditoraNacional(),item.getObservacao());
				//Manga manga = new Manga();
				manga.setTipo(tipoManga);
				
				//System.out.println("Tipo " + manga.getTipo().getCode());

				Manga m = mangaRepository.save(manga);
			}
		
			if(opcao.compareTo("hq") == 0) {
				//System.out.println("Testando HQ: " + opcao);
				Hq hQ = new Hq(item.getIsbn(),item.getTitulo(),item.getVolume(),item.getAutor(),item.getDesenhista(),item.getGenero(),item.getEditoraNacional(),item.getObservacao());
				//Hq hQ = new Hq();
				hQ.setEditoraOriginal(hq.getEditoraOriginal());
				hQ.setPersonagemGrupo(hq.getPersonagemGrupo());
				
				Hq h = hqRepository.save(hQ);
			}
			return true;
	}

}
