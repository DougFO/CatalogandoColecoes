package br.edu.iff.ccc.bsi.webdev.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iff.ccc.bsi.webdev.entities.Colecao;
import br.edu.iff.ccc.bsi.webdev.entities.Endereco;
import br.edu.iff.ccc.bsi.webdev.entities.Item;
import br.edu.iff.ccc.bsi.webdev.entities.Pessoa;
import br.edu.iff.ccc.bsi.webdev.entities.Usuario;
import br.edu.iff.ccc.bsi.webdev.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository rep;	
	
	@Autowired
	private UsuarioService usuarioService = new UsuarioService();
	
	@Autowired
	private ItemService itemService = new ItemService();
	
	public Pessoa save(Usuario user, Pessoa pessoa, Endereco endereco) {
		if(rep.consultaIdPessoa(pessoa.getCpf()) == null) {
			pessoa.setUsuario(user);
			pessoa.setEndereco(endereco);
			Pessoa p = rep.save(pessoa);
			return p;
		} else {
			System.out.println("Pessoa já está cadastrada!");
		}
				
		return null;
	}
	
	
	public Pessoa remove(Pessoa pessoa) {
		
		if(rep.consultaIdPessoa(pessoa.getCpf()) != null) {
			long id = Long.parseLong(String.valueOf(rep.consultaIdPessoa(pessoa.getCpf())));		
			rep.deleteById(id);
			return pessoa;
		} else {
			System.out.println("Pessoa não está cadastrada!");
		}	
		return null;
	}
	
	
	public Pessoa consultaPessoa(String cpf) {
		Map<String,String> pessoaConsultada = rep.consultaPessoa(cpf);
		Pessoa pessoa = new Pessoa();
		pessoa.setID(Long.parseLong(String.valueOf(pessoaConsultada.get("ID"))));
		pessoa.setCpf(pessoaConsultada.get("CPF"));
		pessoa.setEmail(pessoaConsultada.get("EMAIL"));
		pessoa.setNome(pessoaConsultada.get("NOME"));
		
		Endereco endereco = new Endereco();
		endereco.setCEP(pessoaConsultada.get("CEP"));
		endereco.setBairro(pessoaConsultada.get("BAIRRO"));
		endereco.setCidade(pessoaConsultada.get("CIDADE"));
		endereco.setEstado(pessoaConsultada.get("ESTADO"));
		endereco.setRua(pessoaConsultada.get("RUA"));
		endereco.setNumero(pessoaConsultada.get("NUMERO"));
		
		pessoa.setEndereco(endereco);
		
		Usuario usuario = new Usuario();
		Long idUsuario = this.consultaIDUsuario(cpf);
		usuario = usuarioService.consultaUsuario(idUsuario);
		pessoa.setUsuario(usuario);			
				
		return pessoa;
	}
	
	Long consultaIDUsuario(String cpf) {
		Map<String,String> pessoaConsultada = rep.consultaPessoa(cpf);
		return Long.parseLong(String.valueOf(pessoaConsultada.get("FK_USUARIO")));
	}
	
	
	
	public Pessoa atualizar(Usuario user, Pessoa pessoa, Endereco endereco) {
		if(rep.consultaIdPessoa(pessoa.getCpf()) != null) {
	//		long id = Long.parseLong(String.valueOf(rep.consultaIdPessoa(pessoa.getCpf())));
			Long id = rep.consultaIdPessoa(pessoa.getCpf());
			pessoa.setID(id);
			user.setID(this.consultaIDUsuario(pessoa.getCpf()));
			pessoa.setUsuario(user);
			pessoa.setEndereco(endereco);
			return rep.saveAndFlush(pessoa);
		} else {
			System.out.println("Pessoa não está cadastrada!");
		}
		 return null;
	}
	
	
	public Pessoa criarColecao(Pessoa pessoa, Colecao colecao, Item item, Map<String,String> colecaoCalendar) {
		Long idItem = itemService.consultaIdItem(item.getIsbn());
		
		String data_inicio = colecaoCalendar.get("calendario");
		Calendar cal = Calendar.getInstance();
		try {
			String data = data_inicio;
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH);
			
			cal.setTime(sdf.parse(data));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		colecao.setData_inicio(cal);
		
		if(rep.consultaFKColecao(pessoa.getCpf()) == null) {
			if(rep.consultaIdPessoa(pessoa.getCpf()) != null) {
				if(itemService.consultaIdItem(item.getIsbn()) != null) {
					Pessoa p = this.consultaPessoa(pessoa.getCpf());
					item.setID(idItem);
					colecao.addItem(item);
					p.setColecao(colecao);			
					return rep.saveAndFlush(p);
				} else {
					System.out.println("Item não está cadastrado!");
				}
			} else {
				System.out.println("Pessoa não está cadastrada!");
			}
		} else {
			System.out.println("Essa pessoa já tem uma coleção cadastrada!");
		}
		
		return null;
	}
}
