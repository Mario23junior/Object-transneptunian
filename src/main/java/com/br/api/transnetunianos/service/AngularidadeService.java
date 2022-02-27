package com.br.api.transnetunianos.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.br.api.transnetunianos.ModelDTO.AngularidadeDTO;
import com.br.api.transnetunianos.exceptions.ReturnErroMessageCostomization;
import com.br.api.transnetunianos.model.Angularidade;
import com.br.api.transnetunianos.repsitory.AgularidadeRepository;

@Service
public class AngularidadeService {
  
	private AgularidadeRepository angulaRepository;
	private ModelMapper mapper;

	public AngularidadeService(AgularidadeRepository angulaRepository, ModelMapper mapper){
 		this.angulaRepository = angulaRepository;
 		this.mapper = mapper;
	}
	
	public ResponseEntity<AngularidadeDTO> saveBody(AngularidadeDTO angularidadeDto) {
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
 		 if(busca != null && busca.getPerielio() != info.getPerielio()) {
 			 throw new ReturnErroMessageCostomization("Informação metrica "+info.getPerielio()+" já esta cadastrada");
 		 }
  	}
	
	
	public ResponseEntity<AngularidadeDTO> listId(Long id) {
		Optional<Angularidade> list = angulaRepository.findById(id);
		if(list.isPresent()) {
			return ResponseEntity.ok(mapper.map(list.get(), AngularidadeDTO.class));
		}else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	
	public ResponseEntity<AngularidadeDTO> updateIdInfo(Long id,AngularidadeDTO angularidadeDto) {
		ValueBeDuplicate(angularidadeDto);
		Optional<Angularidade> updateData = angulaRepository.findById(id);
 		if(updateData.isPresent()) {
 			Angularidade dataGali = updateData.get();
			dataGali.setPerielio (angularidadeDto.getPerielio());
			dataGali.setAfelio(angularidadeDto.getAfelio());
			dataGali.setAfelio(angularidadeDto.getAfelio());
			angulaRepository.save(dataGali);
			return ResponseEntity.ok(mapper.map(dataGali, AngularidadeDTO.class));
			
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	
	public ResponseEntity<AngularidadeDTO> delete(Long id) {
		Optional<Angularidade> findId = angulaRepository.findById(id);
		if(findId.isPresent()) {
			angulaRepository.delete(findId.get());
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
}
