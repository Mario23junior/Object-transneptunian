package com.br.api.transnetunianos.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.br.api.transnetunianos.ModelDTO.TransnetunianosDTO;
import com.br.api.transnetunianos.exceptions.ReturnErroMessageCostomization;
import com.br.api.transnetunianos.model.Transnetunianos;
import com.br.api.transnetunianos.repsitory.TrasnetunianoRepositry;

@Service
public class transnetunianosService {
	
	private TrasnetunianoRepositry repositiry;
	private ModelMapper mapper;
	
	public transnetunianosService(TrasnetunianoRepositry repositiry, ModelMapper mapper) {
		this.repositiry = repositiry;
		this.mapper = mapper;
	}

	public ResponseEntity<TransnetunianosDTO> saveBody(TransnetunianosDTO transnetunianosDto) {
		ValueBeDuplicate(transnetunianosDto);
		Transnetunianos body = bodySave(mapper.map(transnetunianosDto, Transnetunianos.class));
		return ResponseEntity
				  .status(HttpStatus.OK)
				  .body(mapper.map(body, TransnetunianosDTO.class));
	}

	private Transnetunianos bodySave(Transnetunianos transnetunianos) {
 		return repositiry.save(transnetunianos);
	}

	private void ValueBeDuplicate(TransnetunianosDTO transnetunianosDto) {
		Transnetunianos info = mapper.map(transnetunianosDto, Transnetunianos.class);
		Transnetunianos busca = repositiry.findByNome(info.getId());
 		 if(busca != null && busca.getNome() != info.getNome()) {
 			 throw new ReturnErroMessageCostomization("Informação metrica "+info.getNome()+" já esta cadastrada");
 		 }
  	}
	
	
	public ResponseEntity<TransnetunianosDTO> listId(Long id) {
		Optional<Transnetunianos> list = repositiry.findById(id);
		if(list.isPresent()) {
			return ResponseEntity.ok(mapper.map(list.get(), TransnetunianosDTO.class));
		}else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	
	public ResponseEntity<TransnetunianosDTO> updateIdInfo(Long id,TransnetunianosDTO transnetuDto) {
		ValueBeDuplicate(transnetuDto);
		Optional<Transnetunianos> updateData = repositiry.findById(id);
 		if(updateData.isPresent()) {
 			Transnetunianos dataGali = updateData.get();
			dataGali.setNumero(transnetuDto.getNumero());
			dataGali.setNome(transnetuDto.getNome());
			dataGali.setDesignacaoProvi(transnetuDto.getDesignacaoProvi());
			repositiry.save(dataGali);
			return ResponseEntity.ok(mapper.map(dataGali, TransnetunianosDTO.class));
			
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	
	public ResponseEntity<TransnetunianosDTO> delete(Long id) {
		Optional<Transnetunianos> findId = repositiry.findById(id);
		if(findId.isPresent()) {
			repositiry.delete(findId.get());
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

}
