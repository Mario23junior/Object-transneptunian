package com.br.api.transnetunianos.ModelDTO;

public class TransnetunianosDTO {

	private Long id;
	private Integer numero;
	private String nome;
	private Double designacaoProvi;

	public TransnetunianosDTO() {
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

	public Double getDesignacaoProvi() {
		return designacaoProvi;
	}

	public void setDesignacaoProvi(Double designacaoProvi) {
		this.designacaoProvi = designacaoProvi;
	}
}
