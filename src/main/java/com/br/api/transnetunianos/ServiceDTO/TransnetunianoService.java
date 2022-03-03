package com.br.api.transnetunianos.ServiceDTO;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import com.br.api.transnetunianos.ModelDTO.TransnetunianosDTO;
import com.br.api.transnetunianos.model.Transnetunianos;
import com.br.api.transnetunianos.repsitory.TrasnetunianoRepositry;
@Service
public class TransnetunianoService {
   
	private ModelMapper mapper;
	private TrasnetunianoRepositry repositry;
	
	public TransnetunianoService(ModelMapper mapper, TrasnetunianoRepositry repositry) {
 		this.mapper = mapper;
		this.repositry = repositry;
	}
	
	public List<TransnetunianosDTO> listDataTransnetuniano() {
		return ((List<Transnetunianos>) repositry
				.findAll())
				.stream()
				.map(this::ConverterEntity)
				.collect(Collectors.toList());
	}

	private TransnetunianosDTO ConverterEntity(Transnetunianos transnetunianos) {
		mapper.getConfiguration()
		.setMatchingStrategy(MatchingStrategies.LOOSE);
		TransnetunianosDTO trans = mapper.map(transnetunianos, TransnetunianosDTO.class);
		return trans;
	}	
	
	public List<TransnetunianosDTO> listDataAllBase() {
		List<TransnetunianosDTO> list = listDataTransnetuniano();
		return list
				 .stream()
				 .collect(Collectors.toList());
	}
	
	
}
