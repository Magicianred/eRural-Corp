package com.community.eRural.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.community.eRural.model.Categorias;

@Repository


public interface CategoriasRepository extends JpaRepository<Categorias, Long> // AQUI É UMA INTERFACE FILHA QUE CHAMA A
																				// MAE COM O EXTENDS(JPA REPOSITORY)
{

	public List<Categorias> findAllByNomeContainingIgnoreCase(String nome);

	public List<Categorias> findAllByDescricaoContainingIgnoreCase(String decricao);

}
