package com.br.api.transnetunianos.ModelDTO;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

public class TransnetunianosDTO {

	private Long id;
	private Integer numero;
	private String nome;
	private String designacaoProvi;
	
	@OneToMany(mappedBy = "Transnetunianos", cascade = CascadeType.ALL)
	private List <AngularidadeDTO> angularidadeDto;
	
	@OneToMany(mappedBy = "Transnetunianos", cascade = CascadeType.ALL)
    private List <CendenciaInformatDTO> cendenciaInformatDto;
	
	@OneToMany(mappedBy = "Transnetunianos", cascade = CascadeType.ALL)
	private DesignacaoDTO designacaoDto;

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

	public List<AngularidadeDTO> getAngularidadeDto() {
		return angularidadeDto;
	}

	public void setAngularidadeDto(List<AngularidadeDTO> angularidadeDto) {
		this.angularidadeDto = angularidadeDto;
	}

	public List<CendenciaInformatDTO> getCendenciaInformatDto() {
		return cendenciaInformatDto;
	}

	public void setCendenciaInformatDto(List<CendenciaInformatDTO> cendenciaInformatDto) {
		this.cendenciaInformatDto = cendenciaInformatDto;
	}

	public DesignacaoDTO getDesignacaoDto() {
		return designacaoDto;
	}

	public void setDesignacaoDto(DesignacaoDTO designacaoDto) {
		this.designacaoDto = designacaoDto;
	}
	
	
}
