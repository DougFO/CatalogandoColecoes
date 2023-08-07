package br.edu.iff.ccc.bsi.webdev.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iff.ccc.bsi.webdev.entities.Colecao;
import br.edu.iff.ccc.bsi.webdev.entities.Item;
import br.edu.iff.ccc.bsi.webdev.entities.Pessoa;
import br.edu.iff.ccc.bsi.webdev.repository.ColecaoRepository;
import br.edu.iff.ccc.bsi.webdev.repository.ItemRepository;
import br.edu.iff.ccc.bsi.webdev.repository.PessoaRepository;

@Service
public class ColecaoService {
	
	@Autowired
	private ColecaoRepository colecaoRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	//private Pessoa consultaIdPessoa(String cpf) {
//	private Long consultaIdPessoa(String cpf) {
//		String IdPessoaBD = pessoaRepository.consultaIdPessoa(cpf);
//		return Long.parseLong(IdPessoaBD);
//	}
	
	private Map<String,String> consultaPessoa(String cpf) {
		Map<String,String> pessoaMap = pessoaRepository.consultaPessoa(cpf);
		return pessoaMap;
	}
	
	public Long consultaIdItem(String isbn) {
		if(itemRepository.consultaIdItem(isbn).get("ID") != null) {
			Long IdItemBD = (Long.parseLong(String.valueOf(itemRepository.consultaIdItem(isbn).get("ID"))));
			return IdItemBD;
		}	else {
			return null;
		}
	}
	
	private Map<String,String> consultaItem(String isbn) {
		Map<String,String> itemMap = itemRepository.consultaItem(isbn);
		return itemMap;
	}
	
	public boolean save(String nome, String observacao, String data_inicio, String cpf, String isbn) throws ParseException {
		
		Map<String,String> dadosPessoa = this.consultaPessoa(cpf);
		Map<String,String> dadosItem = this.consultaItem(isbn);
		
		Pessoa pessoa = new Pessoa();
		pessoa.setID(Long.parseLong(String.valueOf(dadosPessoa.get("ID"))));
		pessoa.setCpf(dadosPessoa.get("CPF"));
		pessoa.setNome(dadosPessoa.get("NOME"));
		pessoa.setEmail(dadosPessoa.get("EMAIL"));
		
		Item item = new Item();

		item.setID(Long.parseLong(String.valueOf(dadosItem.get("ID"))));
		item.setIsbn(dadosItem.get("ISBN"));
		item.setTitulo(dadosItem.get("TITULO"));
		item.setVolume(dadosItem.get("VOLUME"));
		

		Calendar cal = Calendar.getInstance();
		try {
			String data = data_inicio;
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH);
			
			cal.setTime(sdf.parse(data));
		} catch (ParseException e) {
			e.printStackTrace();
		}

	    Colecao colecao = new Colecao(nome,observacao,cal,pessoa);
	    System.out.println("Nome Titulo: "+item.getTitulo());
	    colecao.addItem(item);
	    if(colecaoRepository.save(colecao) != null) {
	    	return true;
	    } else {
	    	return false;
	    }
	}
	
	public Map<String,String> consultaColecao(String cpf) {
		Map<String,String> colecaoConsultada = colecaoRepository.consultaColecao(cpf);
		return colecaoConsultada;
	}
	
	public Long verificaColecao(String cpf) {
		if(colecaoRepository.verificaColecao(cpf).get("ID") != null) {
			return (Long.parseLong(String.valueOf(colecaoRepository.verificaColecao(cpf).get("ID"))));
		} else {
			return null;
		}
	}
	
	public boolean AddItem(Long idColecao, Long idItem) {
		System.out.println("IdColecaoS: "+idColecao);
		System.out.println("IdItemS: "+idItem);
		if(colecaoRepository.AddItem(idColecao, idItem) == 1) {
			return true;
		} else {
			return false;
		}
	}

}
