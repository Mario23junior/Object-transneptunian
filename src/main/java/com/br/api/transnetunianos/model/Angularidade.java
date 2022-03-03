package com.br.api.transnetunianos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Angularidade {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Double perielio;
	private Double afelio;
	private Double excentricidadeOrbital;
	
	@ManyToOne
	private Transnetunianos transnetunianos;
	
	public Angularidade() {
		// TODO Auto-generated constructor stub
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

	public Transnetunianos getTransnetunianos() {
		return transnetunianos;
	}

	public void setTransnetunianos(Transnetunianos transnetunianos) {
		this.transnetunianos = transnetunianos;
	}
	
	
	

}
