package br.edu.iff.ccc.bsi.webdev.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.Map;

import org.hibernate.mapping.List;
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
	
	@Autowired
	private ColecaoService colecaoService = new ColecaoService();
	
	//public boolean save(Usuario user, Pessoa pessoa, Endereco endereco) {
	public Pessoa save(Usuario user, Pessoa pessoa, Endereco endereco) {
//		pessoa.setUsuario(usuarioService.save(user));
		if(rep.consultaIdPessoa(pessoa.getCpf()) == null) {
				pessoa.setUsuario(user);
				pessoa.setEndereco(endereco);
				Pessoa p = rep.save(pessoa);
				return p;
		} else {
			System.out.println("Pessoa já está cadastrada!");
		}
		//rep.save(pessoa);
		//return true;
		return null;
	}
	
	
//	public Pessoa remove(Usuario user, Pessoa pessoa, Endereco endereco) {
//	public Pessoa remove(Pessoa pessoa) {
	public Pessoa remove(String cpf) {
//		pessoa.setUsuario(user);
		//usuarioService.remove(Long.parseLong(String.valueOf(rep.consultaFKUsuario(pessoa.getCpf()))));
//		System.out.println("FK_USUARIO: "+rep.consultaFKUsuario(pessoa.getCpf()));
//		usuarioService.remove(rep.consultaFKUsuario(pessoa.getCpf()));
//		pessoa.setEndereco(endereco);
		//long id = Long.parseLong(rep.consultaIdPessoa(pessoa.getCpf()));
		
		
		
		//Map<String,String> pessoaP = rep.consultaPessoa(pessoa.getCpf());
		//rep.deleteById(Long.parseLong(String.valueOf(pessoaP.get("ID"))));		

		long id = Long.parseLong(String.valueOf(rep.consultaIdPessoa(cpf)));
		Pessoa pessoa = this.consultaPessoa(cpf);
//		long idUsuario = rep.consultaFKUsuario(pessoa.getCpf());
		rep.deleteById(id);
		
//		usuarioService.remove(idUsuario);
		if(pessoa.equals(null)) {
			//return false;
			return null;
		}
		//rep.save(pessoa);
		return pessoa;
	}
	
	
	public Pessoa consultaPessoa(String cpf) {
		if(rep.consultaIdPessoa(cpf) != null) {
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
			
			if(colecaoService.consultaColecao(cpf) != null) {
				Colecao c = colecaoService.consultaColecao(cpf);
				pessoa.setColecao(c);
			}
			
			return pessoa;
		} else {
			System.out.println("Pessoa consultada não está cadastrada!");
			return null;
		}
	}
	
	
	public ArrayList<Pessoa> consultaPessoas() {
		return (ArrayList<Pessoa>) rep.findAll();
	}
	
	Long consultaIDUsuario(String cpf) {
		Map<String,String> pessoaConsultada = rep.consultaPessoa(cpf);
		return Long.parseLong(String.valueOf(pessoaConsultada.get("FK_USUARIO")));
	}
	
	//public Pessoa atualizar(Usuario user, Pessoa pessoa, Endereco endereco) {
	public Pessoa atualizar(Usuario user, Pessoa pessoa, Endereco endereco, String cpf) {
//		pessoa.setUsuario(user);
		
//		boolean testeUsuario, testePessoa;
//		long idUsuario = rep.consultaFKUsuario(pessoa.getCpf());
//		user.setID(idUsuario);
//		testeUsuario = usuarioService.atualizar(user);
//		pessoa.setUsuario(user);
//		pessoa.setEndereco(endereco);
//		testePessoa = (rep.atualizar(pessoa.getCpf(), pessoa.getNome(), pessoa.getEmail(), pessoa.getEndereco().getCEP(), pessoa.getEndereco().getRua(), pessoa.getEndereco().getNumero(), pessoa.getEndereco().getBairro(), pessoa.getEndereco().getCidade(), pessoa.getEndereco().getEstado()) == 1);
//		if((testeUsuario)&&(testePessoa)) {
//			return pessoa;
//		} else {
//			return null;
//		}
		
		
		long id = Long.parseLong(String.valueOf(rep.consultaIdPessoa(cpf)));
		pessoa.setID(id);
		user.setID(this.consultaIDUsuario(cpf));
		pessoa.setUsuario(user);
		pessoa.setEndereco(endereco);
		return rep.saveAndFlush(pessoa);
			
//		pessoa.setUsuario(usuarioService.atualizar(user));
//		pessoa.setEndereco(endereco);
//		int i = rep.atualizar(pessoa.getCpf(), pessoa.getNome(), pessoa.getEmail(), pessoa.getEndereco().getCEP(), pessoa.getEndereco().getRua(), pessoa.getEndereco().getNumero(), pessoa.getEndereco().getBairro(), pessoa.getEndereco().getCidade(), pessoa.getEndereco().getEstado());
//		System.out.println("i: "+i);

//		return pessoa;
		
		//erator<Pessoa> pessoas = (Iterator<Pessoa>) rep.findAll();
		
//		Pessoa p = rep.save(pessoa);
		//rep.flush();
//		return p;
	}
	
	public ArrayList<Pessoa> consultaPessoasPorNome(String nome) {
		String nomeP = "%"+nome+"%";
		System.out.println("Teste Nome P: "+nomeP);
		ArrayList<Pessoa> pessoas = (ArrayList<Pessoa>) rep.consultaPessoaPorNome(nomeP);
		
		if(pessoas.size() != 0) {
			return pessoas;
		} else {
			return null;
		}	
	}
	
	
	public Pessoa criarColecao(Pessoa pessoa, Item item, Map<String,String> dadosColecao) {
//		Long idPessoa = rep.consultaIdPessoa(pessoa.getCpf());
		Colecao colecao = new Colecao();
		colecao.setNome(dadosColecao.get("nome"));
		colecao.setObservacao(dadosColecao.get("observacao"));
		Long idItem = itemService.consultaIdItem(item.getIsbn());
//		System.out.println("Observacao C: "+colecao.getObservacao());
		if(dadosColecao.get("calendario") != null) {
			String data_inicio = dadosColecao.get("calendario");
			Calendar cal = Calendar.getInstance();
			try {
				String data = data_inicio;
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH);
				
				cal.setTime(sdf.parse(data));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			colecao.setData_inicio(cal);		
		}
			
		if(rep.consultaFKColecao(pessoa.getCpf()) == null) {
			if(rep.consultaIdPessoa(pessoa.getCpf()) != null) {
				if(itemService.consultaIdItem(item.getIsbn()) != null) {
		//			pessoa.setID(idPessoa);
					Pessoa p = this.consultaPessoa(pessoa.getCpf());
					item.setID(idItem);
					colecao.addItem(item);
					p.setColecao(colecao);			
		//			return colecaoService.save(pessoa, colecao, item);
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
	
	
	public Pessoa atualizarColecao(String cpf, Colecao colecao, Map<String,String> dadosAtualizacao) {
		String cpfPessoa = cpf;
		if(rep.consultaIdPessoa(cpfPessoa) != null) {
			if(rep.consultaFKColecao(cpfPessoa) != null) {
				Colecao c = colecaoService.consultaColecao(cpfPessoa);
				c.setNome(colecao.getNome());
				c.setObservacao(colecao.getObservacao());
				
				if(dadosAtualizacao.get("calendario") != null) {
					Calendar cal = Calendar.getInstance();
					try {
						String data_inicio = dadosAtualizacao.get("calendario");
						String data = data_inicio;
						SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH);
						
						cal.setTime(sdf.parse(data));
					} catch (ParseException e) {
						e.printStackTrace();
					}
					
					c.setData_inicio(cal);
				}						
				
				Pessoa pessoa = this.consultaPessoa(cpfPessoa);
				pessoa.setColecao(c);
				
				return rep.saveAndFlush(pessoa);
			} else {
				System.out.println("Essa pessoa não tem uma coleção cadastrada!");
			}
		} else {
			System.out.println("Pessoa não está cadastrada!");			
		}
		
		return null;
	}
	
	public Pessoa removerColecao(String cpf) {
		String cpfPessoa = cpf;
		if(rep.consultaIdPessoa(cpfPessoa) != null) {
			if(rep.consultaFKColecao(cpfPessoa) != null) {
				Pessoa p = this.consultaPessoa(cpfPessoa);
				Colecao colecao = colecaoService.consultaColecao(cpfPessoa);
				p.setColecao(null);
				rep.saveAndFlush(p);
				colecaoService.removeColecao(colecao);
				return p;
			} else {
				System.out.println("Essa pessoa não tem uma coleção cadastrada!");
			}
		} else {
			System.out.println("Pessoa não está cadastrada!");			
		}
		
		return null;
	}
	
	
	
	public Pessoa addItem(String cpf, String isbn) {
		String cpfPessoa = cpf;
		if(rep.consultaIdPessoa(cpfPessoa) != null) {
			if(rep.consultaFKColecao(cpfPessoa) != null) {
				Pessoa p = this.consultaPessoa(cpfPessoa);
				Colecao colecao = colecaoService.consultaColecao(cpfPessoa);
				boolean verifica = false; 
				
				ArrayList<Item> itens = new ArrayList<Item>();
				itens = (ArrayList<Item>) colecao.getItens();
				
				for(int i=0;i<itens.size();i++) {
					if(itens.get(i).getIsbn().compareTo(isbn) == 0) {
						verifica = true;
					}
				}
				
				if(verifica == false) {
					Item item = itemService.consultaItem(isbn);
					if(item != null) {
						colecao.addItem(item);
						p.setColecao(colecao);
						rep.saveAndFlush(p);
						return p;
					} else {
						System.out.println("O item não está cadastrado no sistema!");
					}
				} else {
					System.out.println("O item já está cadastrado na coleção!");
					return null;					
				}
				
			} else {
				System.out.println("Essa pessoa não tem uma coleção cadastrada!");
			}
		} else {
			System.out.println("Pessoa não está cadastrada!");			
		}
		return null;
	}
	
	
	
	public Pessoa removeItem(String cpf, String isbn) {
		String cpfPessoa = cpf;
		if(rep.consultaIdPessoa(cpfPessoa) != null) {
			if(rep.consultaFKColecao(cpfPessoa) != null) {
				Pessoa p = this.consultaPessoa(cpfPessoa);
				Colecao colecao = colecaoService.consultaColecao(cpfPessoa);
				boolean verifica = false; 
				
				ArrayList<Item> itens = new ArrayList<Item>();
				itens = (ArrayList<Item>) colecao.getItens();
				
				for(int i=0;i<itens.size();i++) {
					if(itens.get(i).getIsbn().compareTo(isbn) == 0) {
						verifica = true;
					}
				}
				
				Item item = itemService.consultaItem(isbn);
				if(item != null) {
					if(verifica == true) {					
							colecao.removeItem(item);
							p.setColecao(colecao);
							rep.saveAndFlush(p);
							return p;					
					} else {
						System.out.println("O item não está cadastrado na coleção!");
						return null;					
					}
				} else {
					System.out.println("O item não está cadastrado no sistema!");
				}	
				
			} else {
				System.out.println("Essa pessoa não tem uma coleção cadastrada!");
			}
		} else {
			System.out.println("Pessoa não está cadastrada!");			
		}
		return null;
	}
	
	
	public ArrayList<Colecao> consultaColecoes() {
		return colecaoService.consultaColecoes();
	}
	
}
