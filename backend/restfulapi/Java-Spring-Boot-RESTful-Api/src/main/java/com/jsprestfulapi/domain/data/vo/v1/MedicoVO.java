package com.jsprestfulapi.domain.data.vo.v1;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;

@JsonPropertyOrder({"idMedico", "idCrm", "limite", "nome"})
public class MedicoVO extends RepresentationModel<MedicoVO> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Mapping("idMedico")
	@JsonProperty("idMedico")
	private Long idMedico;

	@JsonProperty("idCrm")
	private int idCrm;

	@JsonProperty("limite")
	private BigDecimal limite;

	@JsonProperty("nome")
	private String nome;

	public MedicoVO() {}

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
		MedicoVO medicoVO = (MedicoVO) o;
		return idCrm == medicoVO.idCrm &&
				Objects.equals(idMedico, medicoVO.idMedico) &&
				Objects.equals(limite, medicoVO.limite) &&
				Objects.equals(nome, medicoVO.nome);
	}

	@Override
	public int hashCode() {
		return Objects.hash(idMedico, idCrm, limite, nome);
	}

}
