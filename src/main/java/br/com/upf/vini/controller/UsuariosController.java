package br.com.upf.vini.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sun.istack.NotNull;

import br.com.upf.vini.dto.CadastrarUsuario;
import br.com.upf.vini.dto.ConsultarUsuariosResponse;
import br.com.upf.vini.services.UsuariosServices;

@Service
@RestController
@RequestMapping(value = "/usuarios", produces = "application/json;charset=UTF-8")
public class UsuariosController {

	@Autowired
	private UsuariosServices services;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Object> consultarUsuarios() {
		try {

			return new ResponseEntity<Object>(
					ConsultarUsuariosResponse.builder().usuarios(services.consultarUsuarios()).build(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> cadastrarUsuario(@RequestBody(required = true) @NotNull CadastrarUsuario request) {
		try {
			services.cadastrarUsuario(request);
			return new ResponseEntity<Object>(null, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

}
