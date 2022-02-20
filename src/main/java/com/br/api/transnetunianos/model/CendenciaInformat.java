package com.br.api.transnetunianos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CendenciaInformat {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Double inclinacaoOrbitalGraus;
	private Double magnitudeAbsoluta;
	
	public CendenciaInformat() {
		// TODO Auto-generated constructor stub
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
	
	
}
