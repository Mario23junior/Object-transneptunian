package com.br.api.transnetunianos.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.api.transnetunianos.ModelDTO.DesignacaoDTO;
import com.br.api.transnetunianos.service.DesignacaoService;

@RestController
@RequestMapping("/api/v1/designacao/")
public class DesignacaoController {

	private DesignacaoService service;

	public DesignacaoController(DesignacaoService service) {
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<DesignacaoDTO> save(@RequestBody DesignacaoDTO DesignacaoDTO) {
		return service.saveBody(DesignacaoDTO);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<DesignacaoDTO> list(@PathVariable Long id) {
		return service.listId(id);
	}
}
