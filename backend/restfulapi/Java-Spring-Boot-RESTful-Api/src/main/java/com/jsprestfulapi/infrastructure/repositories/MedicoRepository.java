package com.jsprestfulapi.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jsprestfulapi.domain.data.model.Medico;

import java.math.BigDecimal;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long>{

}
