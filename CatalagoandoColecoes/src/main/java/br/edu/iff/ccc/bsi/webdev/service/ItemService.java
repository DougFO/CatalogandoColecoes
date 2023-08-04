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

	public boolean save(Item item, int t, Hq hq, String opcao) {

			
			if(opcao.compareTo("manga") == 0) {
				TipoManga tipoManga;		
				tipoManga = TipoManga.toEnum(t);
				Manga manga = new Manga(item.getIsbn(),item.getTitulo(),item.getVolume(),item.getAutor(),item.getDesenhista(),item.getGenero(),item.getEditoraNacional(),item.getObservacao());
				manga.setTipo(tipoManga);

				Manga m = mangaRepository.save(manga);
			}
		
			if(opcao.compareTo("hq") == 0) {
				Hq hQ = new Hq(item.getIsbn(),item.getTitulo(),item.getVolume(),item.getAutor(),item.getDesenhista(),item.getGenero(),item.getEditoraNacional(),item.getObservacao());
				hQ.setEditoraOriginal(hq.getEditoraOriginal());
				hQ.setPersonagemGrupo(hq.getPersonagemGrupo());
				
				Hq h = hqRepository.save(hQ);
			}
			return true;
	}

}
