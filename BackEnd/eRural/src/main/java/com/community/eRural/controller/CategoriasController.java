package com.community.eRural.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.community.eRural.Repository.CategoriasRepository;
import com.community.eRural.model.Categorias;

@RestController //ESSE CHAMA A BIBLIOTECA CONTROLLER 
@RequestMapping("/categorias")//SERVE P/ FAZER UM EDPOINT
@CrossOrigin(origins= "*", allowedHeaders = "*")// ESSES * SERVE P/ RODAR EM VARIAS FRAMEWORKS
public class CategoriasController {
	
	@Autowired// SERVE P/ INSERIR(INJETAR) A CATEGORIASREPOSITORY
	private CategoriasRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Categorias>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Categorias> GetById(@PathVariable long id) {//PROCURAR NA URL @PATHVARIABLE
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());//LAMBDA
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Categorias>> GetByNome(@PathVariable String nome) {
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));//FAZ PARTE DO CATEGORIASREPOSITORY
	}
	
	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<List<Categorias>> GetByDescricao(@PathVariable String descricao) {
		return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(descricao));//FAZ PARTE DO CATEGORIASREPOSITORY
	}
	
	@PostMapping//INSERIR DADOS NO BANCO
	public ResponseEntity<Categorias> post(@RequestBody Categorias categorias) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categorias));
	}

	@PutMapping//CRINADO ALTERAÇÕES
	public ResponseEntity<Categorias> put(@RequestBody Categorias categorias) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(categorias));
	}

	@DeleteMapping("/{id}")//APAGAR DADOS DA TABELA PELO ID
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}

}
