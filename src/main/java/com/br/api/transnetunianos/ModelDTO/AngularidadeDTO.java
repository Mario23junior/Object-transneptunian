package com.br.api.transnetunianos.ModelDTO;

import javax.persistence.ManyToOne;

public class AngularidadeDTO {
   
	private Long id;
	private Double perielio;
	private Double afelio;
	private Double excentricidadeOrbital;
	
	@ManyToOne
 	private TransnetunianosDTO transnetunianosDto;
	
	public AngularidadeDTO() {
 	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getPerielio() {
		return perielio;
	}

	public void setPerielio(Double perielio) {
		this.perielio = perielio;
	}

	public Double getAfelio() {
		return afelio;
	}

	public void setAfelio(Double afelio) {
		this.afelio = afelio;
	}

	public Double getExcentricidadeOrbital() {
		return excentricidadeOrbital;
	}

	public void setExcentricidadeOrbital(Double excentricidadeOrbital) {
		this.excentricidadeOrbital = excentricidadeOrbital;
	}

	public TransnetunianosDTO getTransnetunianosDto() {
		return transnetunianosDto;
	}

	public void setTransnetunianosDto(TransnetunianosDTO transnetunianosDto) {
		this.transnetunianosDto = transnetunianosDto;
	}
	
	
	
}
