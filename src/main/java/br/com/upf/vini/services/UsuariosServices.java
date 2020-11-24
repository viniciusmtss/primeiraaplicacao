package br.com.upf.vini.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.upf.vini.dao.UsuariosDao;
import br.com.upf.vini.dto.CadastrarUsuario;
import br.com.upf.vini.dto.EditarUsuario;
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
	
	public void editarUsuario(String idUsuario ,EditarUsuario request) throws Exception {
		
		if (request.getNome()==null|| request.getNome().isEmpty()) {
			throw new Exception("O nome é obrigatorio");
		}
		dao.editarUsuario(idUsuario, request);
		 
		
	}
	
	public void deletarUsuario(String idUsuario) {
		

		
		dao.deletarUsuario(idUsuario);
	
	}

}
