package com.community.eRural.Repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.community.eRural.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long>{
	public List<Usuario> findByNomeContainingIgnoreCase(String nome);//teste 
	public Optional<Usuario> findByEmail(String email); 
}
