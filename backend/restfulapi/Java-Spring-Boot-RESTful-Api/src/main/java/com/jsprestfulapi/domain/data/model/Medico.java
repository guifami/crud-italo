package com.jsprestfulapi.domain.data.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "MEDICO")
public class Medico implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idMedico", nullable = false)
	private Long idMedico;

	@Column(name = "idCrm", nullable = false)
	private int idCrm;

	@Column(name = "limite", precision = 10, scale = 2)
	private BigDecimal limite;

	@Column(name = "nome", nullable = false, length = 50)
	private String nome;

	public Medico() {}

	public Long getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(Long idMedico) {
		this.idMedico = idMedico;
	}

	public int getIdCrm() {
		return idCrm;
	}

	public void setIdCrm(int idCrm) {
		this.idCrm = idCrm;
	}

	public BigDecimal getLimite() {
		return limite;
	}

	public void setLimite(BigDecimal limite) {
		this.limite = limite;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Medico medico = (Medico) o;
		return idCrm == medico.idCrm &&
				Objects.equals(idMedico, medico.idMedico) &&
				Objects.equals(limite, medico.limite) &&
				Objects.equals(nome, medico.nome);
	}

	@Override
	public int hashCode() {
		return Objects.hash(idMedico, idCrm, limite, nome);
	}

}
