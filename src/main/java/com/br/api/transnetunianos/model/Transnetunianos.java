package com.br.api.transnetunianos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transnetunianos {
  
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Integer numero;
	private String nome;
	private String designacaoProvi;
	
	public Transnetunianos() {
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDesignacaoProvi() {
		return designacaoProvi;
	}
	public void setDesignacaoProvi(String designacaoProvi) {
		this.designacaoProvi = designacaoProvi;
	}
	
	
}
