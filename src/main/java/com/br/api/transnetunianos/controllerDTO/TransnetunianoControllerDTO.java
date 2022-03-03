package com.br.api.transnetunianos.controllerDTO;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.api.transnetunianos.ModelDTO.TransnetunianosDTO;
import com.br.api.transnetunianos.ServiceDTO.TransnetunianoService;

@RestController
@RequestMapping("/api/v1/data/result/")
public class TransnetunianoControllerDTO {
   
	private TransnetunianoService service;
	
	public TransnetunianoControllerDTO(TransnetunianoService service) {
		this.service = service;
	}
	
	@GetMapping
	public List<TransnetunianosDTO> listAllFinal() {
		return service.listDataAllBase();
 		
	}
}
