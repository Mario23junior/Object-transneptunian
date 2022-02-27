package com.br.api.transnetunianos.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.api.transnetunianos.ModelDTO.AngularidadeDTO;
import com.br.api.transnetunianos.service.AngularidadeService;

@RestController
@RequestMapping("/api/v1/angularidade/")
public class AngularidadeController {
   
	private AngularidadeService service;
	
	public AngularidadeController(AngularidadeService service) {
	    this.service = service;
	}
	
	@PostMapping
	public ResponseEntity<AngularidadeDTO> save(@RequestBody AngularidadeDTO angularidadeDto) {
		return service.saveBody(angularidadeDto);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<AngularidadeDTO> list(@PathVariable Long id) {
		return service.listId(id);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<AngularidadeDTO> update(@PathVariable Long id , @RequestBody AngularidadeDTO angularidadeDto) {
		return service.updateIdInfo(id, angularidadeDto);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<AngularidadeDTO> deleteData(@PathVariable Long id) {
		return service.delete(id);
	}
}
