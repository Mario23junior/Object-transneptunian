package com.br.api.transnetunianos.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.br.api.transnetunianos.ModelDTO.CendenciaInformatDTO;
import com.br.api.transnetunianos.exceptions.ReturnErroMessageCostomization;
import com.br.api.transnetunianos.model.CendenciaInformat;
import com.br.api.transnetunianos.repsitory.CendenciaInforRepository;

@Service
public class CendenciaInformatService {

   private CendenciaInforRepository cendriRepository;
   private ModelMapper mapper;
		
    public CendenciaInformatService(CendenciaInforRepository cendriRepository, ModelMapper mapper) {
 	this.cendriRepository = cendriRepository;
	this.mapper = mapper;
}

		public ResponseEntity<CendenciaInformatDTO> saveBody(CendenciaInformatDTO cendenciaInformatDto) {
			ValueBeDuplicate(cendenciaInformatDto);
			CendenciaInformat body = bodySave(mapper.map(cendenciaInformatDto,CendenciaInformat.class));
			return ResponseEntity
					  .status(HttpStatus.OK)
					  .body(mapper.map(body, CendenciaInformatDTO.class));
		}

		private CendenciaInformat bodySave(CendenciaInformat cendenciaInformat) {
	 		return cendriRepository.save(cendenciaInformat);
		}

		private void ValueBeDuplicate(CendenciaInformatDTO cendenciaInformatDto) {
	 		CendenciaInformat info = mapper.map(cendenciaInformatDto, CendenciaInformat.class);
	 		CendenciaInformat busca = cendriRepository.findByMagnitudeAbsoluta(info.getMagnitudeAbsoluta());
	 		 if(busca != null && busca.getMagnitudeAbsoluta() != info.getMagnitudeAbsoluta()) {
	 			 throw new ReturnErroMessageCostomization("Informação metrica "+info.getMagnitudeAbsoluta()+" já esta cadastrada");
	 		 }
	  	}
		
		
		public ResponseEntity<CendenciaInformatDTO> listId(Long id) {
			Optional<CendenciaInformat> list = cendriRepository.findById(id);
			if(list.isPresent()) {
				return ResponseEntity.ok(mapper.map(list.get(), CendenciaInformatDTO.class));
			}else {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		}
//		
//		
//		public ResponseEntity<AngularidadeDTO> updateIdInfo(Long id,AngularidadeDTO angularidadeDto) {
//			ValueBeDuplicate(angularidadeDto);
//			Optional<Angularidade> updateData = angulaRepository.findById(id);
//	 		if(updateData.isPresent()) {
//	 			Angularidade dataGali = updateData.get();
//				dataGali.setPerielio (angularidadeDto.getPerielio());
//				dataGali.setAfelio(angularidadeDto.getAfelio());
//				dataGali.setAfelio(angularidadeDto.getAfelio());
//				angulaRepository.save(dataGali);
//				return ResponseEntity.ok(mapper.map(dataGali, AngularidadeDTO.class));
//				
//			} else {
//				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//			}
//		}
//		
//		
//		public ResponseEntity<AngularidadeDTO> delete(Long id) {
//			Optional<Angularidade> findId = angulaRepository.findById(id);
//			if(findId.isPresent()) {
//				angulaRepository.delete(findId.get());
//				return new ResponseEntity<>(HttpStatus.OK);
//			} else {
//				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//			}
//		}
		
	//}

}
