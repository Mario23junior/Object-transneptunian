package com.br.api.transnetunianos.repsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.api.transnetunianos.model.Angularidade;

public interface AgularidadeRepository extends JpaRepository<Angularidade, Long>{

	Angularidade findByPerielio(Double perielio);

}
