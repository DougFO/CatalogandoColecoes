package br.edu.iff.ccc.bsi.webdev.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
	
	//private Item consultaIdItem(String isbn) {
//	private Long consultaIdItem(String isbn) {
//		String IdItemBD = itemRepository.consultaIdItem(isbn);
//		return Long.parseLong(IdItemBD);
//	}
	
	private Map<String,String> consultaItem(String isbn) {
		Map<String,String> itemMap = itemRepository.consultaItem(isbn);
		//return Long.parseLong(IdItemBD);
		return itemMap;
	}
	
	public boolean save(String nome, String observacao, String data_inicio, String cpf, String isbn) throws ParseException {
//		Long idPessoa = this.consultaIdPessoa(cpf);
//		Long idItem = this.consultaIdItem(isbn);
		
		Map<String,String> dadosPessoa = this.consultaPessoa(cpf);
		Map<String,String> dadosItem = this.consultaItem(isbn);
		
		Pessoa pessoa = new Pessoa();
		pessoa.setID(Long.parseLong(dadosPessoa.get("ID")));
		pessoa.setCpf(dadosPessoa.get("CPF"));
		pessoa.setNome(dadosPessoa.get("NOME"));
		pessoa.setEmail(dadosPessoa.get("EMAIL"));
		
		Item item = new Item();
		item.setID(Long.parseLong(dadosItem.get("ID")));
		item.setIsbn(dadosItem.get("ISBN"));
		item.setTitulo(dadosItem.get("TITULO"));
		item.setVolume(dadosItem.get("VOLUME"));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    Calendar c = Calendar.getInstance();     
	    c.setTime(sdf.parse(data_inicio));
	    //aqui está o "pulo do gato"
	    //System.out.println("Teste: "+c);
	    //System.out.println(new java.sql.Date(c.getTimeInMillis()));
	    
	    Colecao colecao = new Colecao(nome,observacao,c,pessoa);
	    colecao.addItem(item);
	    return true;
	}

}
