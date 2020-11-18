package br.com.upf.vini.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.upf.vini.dao.UsuariosDao;
import br.com.upf.vini.dto.CadastrarUsuario;
import br.com.upf.vini.model.Usuarios;

@Service
public class UsuariosServices {
	
	@Autowired
	private UsuariosDao dao;
	
	public List<Usuarios> consultarUsuarios(){
		return dao.consultarUsuarios();
	}
	
	public void cadastrarUsuario(CadastrarUsuario request) {
		
		dao.cadastrarUsuario(request);
		
		
	}
	
	public void editarUsuario(EditarUsuario request) {
		
		dao.editarUsuario(request);
		
	}

}
