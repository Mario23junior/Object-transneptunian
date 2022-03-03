package com.br.api.transnetunianos.ModelDTO;

import javax.persistence.ManyToOne;

public class CendenciaInformatDTO {
  
	private Long id;
	private Double inclinacaoOrbitalGraus;
	private Double magnitudeAbsoluta;
	
	@ManyToOne
 	private TransnetunianosDTO transnetunianosDto;
	
	public CendenciaInformatDTO() {
 	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getInclinacaoOrbitalGraus() {
		return inclinacaoOrbitalGraus;
	}

	public void setInclinacaoOrbitalGraus(Double inclinacaoOrbitalGraus) {
		this.inclinacaoOrbitalGraus = inclinacaoOrbitalGraus;
	}

	public Double getMagnitudeAbsoluta() {
		return magnitudeAbsoluta;
	}

	public void setMagnitudeAbsoluta(Double magnitudeAbsoluta) {
		this.magnitudeAbsoluta = magnitudeAbsoluta;
	}

	public TransnetunianosDTO getTransnetunianosDto() {
		return transnetunianosDto;
	}

	public void setTransnetunianosDto(TransnetunianosDTO transnetunianosDto) {
		this.transnetunianosDto = transnetunianosDto;
	}
	
	
}
