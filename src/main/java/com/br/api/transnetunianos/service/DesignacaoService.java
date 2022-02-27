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

			public ResponseEntity<DesignacaoDTO> saveBody(DesignacaoDTO DesignacaoDto) {
				ValueBeDuplicate(DesignacaoDto);
				Designacao body = bodySave(mapper.map(DesignacaoDto,Designacao.class));
				return ResponseEntity
						  .status(HttpStatus.OK)
						  .body(mapper.map(body, DesignacaoDTO.class));
			}

			private Designacao bodySave(Designacao designacao) {
		 		return repository.save(designacao);
			}

			private void ValueBeDuplicate(DesignacaoDTO DesignacaoDto) {
		 		CendenciaInformat info = mapper.map(DesignacaoDto, CendenciaInformat.class);
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
//			
//		
//			public ResponseEntity<CendenciaInformatDTO> updateIdInfo(Long id,CendenciaInformatDTO cendenciaInformatDto) {
//	 			Optional<CendenciaInformat> updateData = cendriRepository.findById(id);
//		 		if(updateData.isPresent()) {
//		 			CendenciaInformat dataGali = updateData.get();
//					dataGali.setInclinacaoOrbitalGraus(cendenciaInformatDto.getInclinacaoOrbitalGraus());
//					dataGali.setMagnitudeAbsoluta(cendenciaInformatDto.getMagnitudeAbsoluta());
//	 				cendriRepository.save(dataGali);
//					return ResponseEntity.ok(mapper.map(dataGali, CendenciaInformatDTO.class));
//					
//				} else {
//					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//				}
//			}
//			
//			
//			public ResponseEntity<CendenciaInformatDTO> delete(Long id) {
//				Optional<CendenciaInformat> findId = cendriRepository.findById(id);
//				if(findId.isPresent()) {
//					cendriRepository.delete(findId.get());
//				return new ResponseEntity<>(HttpStatus.OK);
//				} else {
//					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//				}
//			}
}
