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

import com.br.api.transnetunianos.ModelDTO.CendenciaInformatDTO;
import com.br.api.transnetunianos.service.CendenciaInformatService;

@RestController
@RequestMapping("/api/v1/cendenciaInformate/")
public class CendenciaInformatController {
   
	
	private CendenciaInformatService service;
 	
	public CendenciaInformatController(CendenciaInformatService service) {
		super();
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<CendenciaInformatDTO> save(@RequestBody CendenciaInformatDTO cendenciaInformatDTO) {
		return service.saveBody(cendenciaInformatDTO);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<CendenciaInformatDTO> save(@PathVariable Long id) {
		return service.listId(id);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<CendenciaInformatDTO> update(@PathVariable Long id ,
			@RequestBody CendenciaInformatDTO cendenciaInformatDTO) {
		
		return service.updateIdInfo(id,cendenciaInformatDTO);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<CendenciaInformatDTO> delete(@PathVariable Long id) {
		return service.delete(id);
	}
	
}
