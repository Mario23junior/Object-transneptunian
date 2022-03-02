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

import com.br.api.transnetunianos.ModelDTO.TransnetunianosDTO;
import com.br.api.transnetunianos.service.transnetunianosService;

@RestController
@RequestMapping("/api/v1/transnetuniano/")
public class TransnetunianosController {

	private transnetunianosService service;

	public TransnetunianosController(transnetunianosService service) {
			this.service = service;
		}

	@PostMapping
	public ResponseEntity<TransnetunianosDTO> save(@RequestBody TransnetunianosDTO transnetunianosDto) {
		return service.saveBody(transnetunianosDto);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<TransnetunianosDTO> list(@PathVariable Long id) {
		return service.listId(id);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<TransnetunianosDTO> update (@PathVariable Long id,@RequestBody TransnetunianosDTO transnetunianosDto) {
		return service.updateIdInfo(id, transnetunianosDto);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<TransnetunianosDTO> delete (@PathVariable Long id) {
		return service.delete(id);
	}
}
