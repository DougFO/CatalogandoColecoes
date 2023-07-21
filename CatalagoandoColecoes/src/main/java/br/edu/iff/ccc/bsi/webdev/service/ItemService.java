package br.edu.iff.ccc.bsi.webdev.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iff.ccc.bsi.webdev.entities.Hq;
import br.edu.iff.ccc.bsi.webdev.entities.Item;
import br.edu.iff.ccc.bsi.webdev.entities.Manga;
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
	
	public boolean save(Item item, Manga manga, Hq hq) {
		Item i = itemRepository.save(item);
		if (Objects.isNull(hq)) {
		//if (manga.getTipo() == 0) {
			Manga m = mangaRepository.save(manga);
		} else {
			Hq quadrinho = hqRepository.save(hq);
		}
		return true;
	}

}
