package com.br.api.transnetunianos.service;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.br.api.transnetunianos.ModelDTO.AngularidadeDTO;
import com.br.api.transnetunianos.model.Angularidade;
import com.br.api.transnetunianos.repsitory.AgularidadeRepository;

@Service
public class AngularidadeService {
  
	private AgularidadeRepository angulaRepository;
	private ModelMapper mapper;

	public AngularidadeService(AgularidadeRepository angulaRepository) {
 		this.angulaRepository = angulaRepository;
	}
	
	public ResponseEntity<AngularidadeDTO> saveBodyAngularidade(AngularidadeDTO angularidadeDto) {
		ValueBeDuplicate(angularidadeDto);
		Angularidade body = bodySave(mapper.map(angularidadeDto,Angularidade.class));
		return ResponseEntity
				  .status(HttpStatus.OK)
				  .body(mapper.map(body, AngularidadeDTO.class));
	}

	private Angularidade bodySave(Angularidade angularidade) {
 		return angulaRepository.save(angularidade);
	}

	private void ValueBeDuplicate(AngularidadeDTO angularidadeDto) {
 		Angularidade info = mapper.map(angularidadeDto, Angularidade.class);
 		Angularidade busca = angulaRepository.findByPerielio(info.getPerielio());
 		 if(busca != null && busca.getId() != info.getId()) {
 			 //throw new MessageErrorReturnException("Informação sobre " +busca+ "já esta cadastrada na base de dados");
 		 }
  	}
	
	
}
