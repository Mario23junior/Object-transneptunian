package com.br.api.transnetunianos.repsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.api.transnetunianos.model.CendenciaInformat;
import com.br.api.transnetunianos.model.Designacao;

public interface DesignacaoRepository extends JpaRepository<Designacao, Long>{

	CendenciaInformat findByRessonanciaOrbitalNetuno(Double magnitudeAbsoluta);

}
