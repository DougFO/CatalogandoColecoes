package br.edu.iff.ccc.bsi.webdev.service;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iff.ccc.bsi.webdev.entities.Usuario;
import br.edu.iff.ccc.bsi.webdev.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository reu;
	
	Usuario save(Usuario user) {
		return reu.save(user);
	}
	
	Usuario consultaUsuario(Long id) {
		Usuario usuario = new Usuario();
		Map<String,String> usuarioConsultado = reu.consultaUsuario(id);
		usuario.setID(Long.parseLong(String.valueOf(usuarioConsultado.get("ID"))));
		usuario.setUsername(usuarioConsultado.get("USERNAME"));
		usuario.setPassword(usuarioConsultado.get("PASSWORD"));
		usuario.setNivel(Integer.parseInt(String.valueOf(usuarioConsultado.get("NIVEL"))));
		return usuario;
	}
	
	void remove(long id) {
		reu.deleteById(id);
	}
	
}
