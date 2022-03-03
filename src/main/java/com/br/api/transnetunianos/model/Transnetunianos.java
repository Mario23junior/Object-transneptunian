package com.br.api.transnetunianos.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Transnetunianos {
  
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Integer numero;
	private String nome;
	private String designacaoProvi;
	
	@OneToMany(mappedBy = "transnetunianos", cascade = CascadeType.ALL)
	private List <Angularidade> angularidade;
	
	@OneToMany(mappedBy = "transnetunianos", cascade = CascadeType.ALL)
    private List <CendenciaInformat> cendenciaInformat;
	
	@OneToMany(mappedBy = "transnetunianos", cascade = CascadeType.ALL)
	private List <Designacao> designacao;
    
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

	public List<Angularidade> getAngularidade() {
		return angularidade;
	}

	public void setAngularidade(List<Angularidade> angularidade) {
		this.angularidade = angularidade;
	}

	public List<CendenciaInformat> getCendenciaInformat() {
		return cendenciaInformat;
	}

	public void setCendenciaInformat(List<CendenciaInformat> cendenciaInformat) {
		this.cendenciaInformat = cendenciaInformat;
	}

	public List<Designacao> getDesignacao() {
		return designacao;
	}

	public void setDesignacao(List<Designacao> designacao) {
		this.designacao = designacao;
	}
	
	
	
}
