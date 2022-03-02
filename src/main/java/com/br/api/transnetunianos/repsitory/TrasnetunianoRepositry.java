package com.br.api.transnetunianos.repsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.api.transnetunianos.model.Transnetunianos;

public interface TrasnetunianoRepositry extends JpaRepository<Transnetunianos, Long>{

	Transnetunianos findByNome(Long id);

}
