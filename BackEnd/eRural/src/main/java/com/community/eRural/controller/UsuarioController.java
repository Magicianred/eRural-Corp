package com.community.eRural.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.community.eRural.Service.UsuarioService;
import com.community.eRural.model.Usuario;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {
	
		
	@Autowired
	private UsuarioService service;
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Usuario> Post(@RequestBody Usuario usuario){
		Optional<Usuario> user = service.CadastrarUsuario(usuario);
		try {
			return ResponseEntity.ok(user.get());
		}catch(Exception e ) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	/*@PostMapping("/logar")
	public ResponseEntity<UserLogin> Autentication(@RequestBody Optional<UserLogin> user) {
		return usuarioService.Logar(user).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
				
				AQUI NÃO ESTA FUNCIONANDO POIS AINDA FALTA A CAMADA DE SECURITY
										(IGNORAR)
	}*/
	
}
