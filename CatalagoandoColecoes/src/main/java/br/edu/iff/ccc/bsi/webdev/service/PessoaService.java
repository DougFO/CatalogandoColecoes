package br.edu.iff.ccc.bsi.webdev.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
	
	@Autowired
	private ColecaoService colecaoService = new ColecaoService();
	
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
	
	
	public Pessoa remove(String cpf) {
		
		if(rep.consultaIdPessoa(cpf) != null) {
			long id = Long.parseLong(String.valueOf(rep.consultaIdPessoa(cpf)));
			Pessoa pessoa = this.consultaPessoa(cpf);
			rep.deleteById(id);			
			return pessoa;
		} else {
			System.out.println("Pessoa não está cadastrada!");
		}	
		return null;
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
	
	
	
	public Pessoa atualizar(Usuario user, Pessoa pessoa, Endereco endereco, String cpf) {
		if(rep.consultaIdPessoa(cpf) != null) {
	//		long id = Long.parseLong(String.valueOf(rep.consultaIdPessoa(pessoa.getCpf())));
			Long id = rep.consultaIdPessoa(cpf);
			pessoa.setID(id);
			user.setID(this.consultaIDUsuario(cpf));
			pessoa.setUsuario(user);
			pessoa.setEndereco(endereco);
			return rep.saveAndFlush(pessoa);
		} else {
			System.out.println("Pessoa não está cadastrada!");
		}
		 return null;
	}
	
	
	public Pessoa criarColecao(Pessoa pessoa, Item item, Map<String,String> dadosColecao) {
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
