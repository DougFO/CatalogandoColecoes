package br.edu.iff.ccc.bsi.webdev.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iff.ccc.bsi.webdev.entities.Colecao;
import br.edu.iff.ccc.bsi.webdev.entities.Item;
import br.edu.iff.ccc.bsi.webdev.entities.Pessoa;
import br.edu.iff.ccc.bsi.webdev.repository.ColecaoRepository;


@Service
public class ColecaoService {
	
	@Autowired
	private ColecaoRepository colecaoRepository;
	
	
	@Autowired
	private ItemService itemService = new ItemService();
	
//	@Autowired
//	private PessoaService pessoaService = new PessoaService();

	
	//public boolean save(String nome, String observacao, String data_inicio, String cpf, String isbn) throws ParseException {
//	public Colecao save(String nome, String observacao, String data_inicio, String cpf, String isbn) throws ParseException { 02/10/2023
//		
//		Pessoa pessoa = pessoaService.consultaPessoa(cpf);
//		Item item = itemService.consultaItem(isbn);		
//		
//		if(colecaoRepository.verificaColecao(cpf) != null) {
//			//return false;
//			return null;
//		}
//
//		Calendar cal = Calendar.getInstance();
//		try {
//			String data = data_inicio;
//			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH);
//			
//			cal.setTime(sdf.parse(data));
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		
//		//System.out.println("Calendar: "+cal);
//
//	    Colecao colecao = new Colecao(nome,observacao,cal,pessoa);
//	    //System.out.println("Nome Titulo: "+item.getTitulo());
//	    colecao.addItem(item);
//	    if(colecaoRepository.save(colecao) != null) {
//	    	//return true;
//	    	return colecao;
//	    } else {
//	    	//return false;
//	    	return null;
//	    }
//	}
	
//	public Long verificaColecao(String cpf) {
//		if(colecaoRepository.verificaColecao(cpf) != null) {
//			return (colecaoRepository.verificaColecao(cpf));
//		} else {
//			return null;
//		}
//	}
	
	public List<Item> consultaItens(String cpf) {
		Long id = colecaoRepository.verificaColecao(cpf);
		if(id != null) {
			List<Long> itensColecao = colecaoRepository.consultaItensColecao(id);
			List<Item> itens = new ArrayList<Item>();
			for(int i=0;i<itensColecao.size();i++) {
				itens.add(itemService.consultaItemById(itensColecao.get(i)));
			}
			return itens;
		} else {
			return null;
		}
	}
	

	public Colecao consultaColecao(String cpf) {
		if(colecaoRepository.verificaColecao(cpf) != null) {
			Map<String,String> colecaoConsultada = colecaoRepository.consultaColecao(cpf);
			
			Colecao colecao = new Colecao();
			colecao.setID(Long.parseLong(String.valueOf(colecaoConsultada.get("ID"))));
			colecao.setNome(colecaoConsultada.get("NOME"));
			colecao.setObservacao(colecaoConsultada.get("OBSERVACAO"));
	
			Calendar cal = Calendar.getInstance();
			try {
				String data = String.valueOf(colecaoConsultada.get("DATA_INICIO"));
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH);
				
				cal.setTime(sdf.parse(data.substring(0, 10)));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			colecao.setData_inicio(cal);
			
//			Pessoa pessoa = pessoaService.consultaPessoa(cpf);
//			colecao.setPessoa(pessoa); 01/10/2023
			
			List<Item> itensConsultados = this.consultaItens(cpf);
			for(int i=0;i<itensConsultados.size();i++) {
				colecao.addItem(itensConsultados.get(i));
			}
			
			return colecao;
		} else {
			return null;
		}
	}
		
	
//	public boolean AddItem(String cpfPessoa, String isbnItem) {
//		if((cpfPessoa == "")||(isbnItem == "")) {
//			return false;
//		}
//		
//		Long idColecao = this.verificaColecao(cpfPessoa);
//		Long idItem = itemService.consultaIdItem(isbnItem);
//		
//		if(colecaoRepository.AddItem(idColecao, idItem) == 1) {
//			return true;
//		} else {
//			return false;
//		}
//	}
	
	public boolean AddItem(String cpfPessoa, String isbnItem) {
		if((cpfPessoa == "")||(isbnItem == "")) {
			return false;
		}

		if(itemService.verificaItem(isbnItem)) {
			Colecao colecao = this.consultaColecao(cpfPessoa);
			Item itemNovo = itemService.consultaItem(isbnItem);
			colecao.addItem(itemNovo);
			
			Colecao colecaoTeste = colecaoRepository.saveAndFlush(colecao);
			if(colecaoTeste.equals(null)) {
				return false;
			} else {
				return true;
			}
		} else {
			return false;
		}	
	}
	
	public List<Colecao> consultaColecoes() {
		return colecaoRepository.findAll();
	}
	
//	public boolean atualizaColecao(Map<String,String> colecaoMap) { 02/10/2023
//			Colecao colecao = new Colecao();
//			colecao.setNome(colecaoMap.get("nome"));
//			colecao.setObservacao(colecaoMap.get("observacao"));
//			
//			Calendar cal = Calendar.getInstance();
//			try {
//				String data = String.valueOf(colecaoMap.get("data_inicio"));
//				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH);
//				
//				cal.setTime(sdf.parse(data.substring(0, 10)));
//			} catch (ParseException e) {
//				e.printStackTrace();
//			}
//			colecao.setData_inicio(cal);
//			
//			Pessoa pessoa = pessoaService.consultaPessoa(colecaoMap.get("pessoa"));
////			colecao.setPessoa(pessoa); 01/10/2023
//			
////			colecao.setID(colecaoRepository.verificaColecao(colecao.getPessoa().getCpf())); 01/10/2023
//			
//			//System.out.println("Cpf Colecao: "+colecao.getPessoa().getCpf());
//			
////			Colecao colecaoConsultada = this.consultaColecao(colecao.getPessoa().getCpf()); 01/10/2023
//			
////			List<Item> itens = colecaoConsultada.getItens(); 01/10/2023
////			for(int i=0;i<itens.size();i++) {
////				colecao.addItem(itens.get(i));
////			}
//			
//			Colecao colecaoVerifica = colecaoRepository.saveAndFlush(colecao);
//			if(colecaoVerifica == null) {
//				return false;
//			}
//			return true;
//	}
	
	public boolean removeItem(String cpf, String isbn) {
		Colecao colecao = this.consultaColecao(cpf);
		Item item = itemService.consultaItem(isbn);
		if(item != null) {
			boolean verifica = colecao.removeItem(item);
			if(verifica == true) {
				Colecao colecaoVerifica = colecaoRepository.saveAndFlush(colecao);
				if(colecaoVerifica == null) {
					return false;
				} else {
					return true;
				}
			}
		} else {
			return false;
		}
		return false;
	}
	
	public Item consultaItemColecao(String cpf, String isbn) {
		if(colecaoRepository.verificaColecao(cpf) != null) {
			Colecao colecao = this.consultaColecao(cpf);
			Item item = itemService.consultaItem(isbn);
			if(item != null) {
				if(colecao.itemIsSet(item) == true) {
					return item;
				} else {
					return null;
				}
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
	
	public void removeColecao(Colecao colecao) {
		colecaoRepository.deleteById(colecao.getID());
	}



}
