package com.br.api.transnetunianos.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.br.api.transnetunianos.ModelDTO.DesignacaoDTO;
import com.br.api.transnetunianos.exceptions.ReturnErroMessageCostomization;
import com.br.api.transnetunianos.model.CendenciaInformat;
import com.br.api.transnetunianos.model.Designacao;
import com.br.api.transnetunianos.repsitory.DesignacaoRepository;

@Service
public class DesignacaoService {
   
	 private DesignacaoRepository repository;
	 private ModelMapper mapper;
		
	    public DesignacaoService(DesignacaoRepository repository, ModelMapper mapper) {
	 	this.repository = repository;
		this.mapper = mapper;
	}

			public ResponseEntity<DesignacaoDTO> saveBody(Designacao dsesignacao) {
				ValueBeDuplicate(dsesignacao);
				Designacao body = bodySave(mapper.map(dsesignacao,Designacao.class));
				return ResponseEntity
						  .status(HttpStatus.OK)
						  .body(mapper.map(body, DesignacaoDTO.class));
			}

			private Designacao bodySave(Designacao designacao) {
		 		return repository.save(designacao);
			}

			private void ValueBeDuplicate(Designacao dsesignacao) {
		 		CendenciaInformat info = mapper.map(dsesignacao, CendenciaInformat.class);
		 		CendenciaInformat busca = repository.findByRessonanciaOrbitalNetuno(info.getMagnitudeAbsoluta());
		 		 if(busca != null && busca.getMagnitudeAbsoluta() != info.getMagnitudeAbsoluta()) {
		 			 throw new ReturnErroMessageCostomization("Ressonancia orbital de neturno "+info.getMagnitudeAbsoluta()+" já esta cadastrada");
		 		 }
		  	}
			
			
			public ResponseEntity<DesignacaoDTO> listId(Long id) {
				Optional<Designacao> list = repository.findById(id);
				if(list.isPresent()) {
					return ResponseEntity.ok(mapper.map(list.get(), DesignacaoDTO.class));
				}else {
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
			}
			
		
			public ResponseEntity<DesignacaoDTO> updateIdInfo(Long id, DesignacaoDTO designacaoDto) {
	 			Optional<Designacao> updateData = repository.findById(id);
		 		if(updateData.isPresent()) {
		 			Designacao dataGali = updateData.get();
					dataGali.setData(designacaoDto.getData());
					dataGali.setLocaliazcao(designacaoDto.getLocaliazcao());
					dataGali.setRessonanciaOrbitalNetuno(designacaoDto.getRessonanciaOrbitalNetuno());
 					repository.save(dataGali);
					return ResponseEntity.ok(mapper.map(dataGali, DesignacaoDTO.class));
					
				} else {
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
			}
			
			
			public ResponseEntity<DesignacaoDTO> delete(Long id) {
				Optional<Designacao> findId = repository.findById(id);
				if(findId.isPresent()) {
					repository.delete(findId.get());
				return new ResponseEntity<>(HttpStatus.OK);
				} else {
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
			}
}
