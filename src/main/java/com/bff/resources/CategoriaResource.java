package com.bff.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bff.domain.Categoria;
import com.bff.services.CategoriaService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService service;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<Categoria> listar() {
//		Categoria cat1 = new Categoria(1, "Teste");
//		Categoria cat2 = new Categoria(2, "Teste2");
//
//		List<Categoria> lista = new ArrayList<>();
//		lista.add(cat1);
//		lista.add(cat2);


		return service.listar();
	}
	
	@RequestMapping( value = "/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Categoria obj = service.buscar(id);
		
		return ResponseEntity.ok().body(obj);
	}
}
