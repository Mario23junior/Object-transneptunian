package com.br.api.transnetunianos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Designacao {
  
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String data;
	private String localiazcao;
	private String ressonanciaOrbitalNetuno;
	
	public Designacao() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getLocaliazcao() {
		return localiazcao;
	}

	public void setLocaliazcao(String localiazcao) {
		this.localiazcao = localiazcao;
	}

	public String getRessonanciaOrbitalNetuno() {
		return ressonanciaOrbitalNetuno;
	}

	public void setRessonanciaOrbitalNetuno(String ressonanciaOrbitalNetuno) {
		this.ressonanciaOrbitalNetuno = ressonanciaOrbitalNetuno;
	}
	
	
}
