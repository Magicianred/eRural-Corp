package com.community.eRural.Service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.community.eRural.Repository.UsuarioRepository;
import com.community.eRural.model.Usuario;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	//usuarios diferentes não podem possuir o mesmo email
	
	public Optional<Usuario> CadastrarUsuario(Usuario email){
	
		if(repository.findByEmail(email.getEmail()).isPresent()) {
			return null;
		}
		return Optional.of(repository.save(email));
	}
	
	/*public Optional<UserLogin> Logar (Optional<UserLogin> user){
	
	Optional<Usuario> usuario = repository.findByUsuario(user.get().getUsuario());
	if(usuario.isPresent()) {
		user.get().setUsuario(usuario.get().getUsuario());
		user.get().setSenha(usuario.get().getSenha());

		return user;
			
	}
	return null;
	
			AQUI NÃO ESTA FUNCIONANDO POIS AINDA FALTA A CAMADA DE SECURITY
										(IGNORAR)
	}*/
	
}
