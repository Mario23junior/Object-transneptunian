package com.br.api.transnetunianos.ModelDTO;

public class TransnetunianosDTO {

	private Long id;
	private Integer numero;
	private String nome;
	private String designacaoProvi;

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

	public String getDesignacaoProvi() {
		return designacaoProvi;
	}

	public void setDesignacaoProvi(String designacaoProvi) {
		this.designacaoProvi = designacaoProvi;
	}
}
