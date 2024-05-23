package com.jsprestfulapi.application.services;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Service;

import com.jsprestfulapi.application.controllers.MedicoController;
import com.jsprestfulapi.application.mapper.DozerMapper;
import com.jsprestfulapi.domain.data.model.Medico;
import com.jsprestfulapi.domain.data.vo.v1.MedicoVO;
import com.jsprestfulapi.infrastructure.exceptions.RequiredObjectIsNullException;
import com.jsprestfulapi.infrastructure.exceptions.ResourceNotFoundException;
import com.jsprestfulapi.infrastructure.repositories.MedicoRepository;

import jakarta.transaction.Transactional;

import java.math.BigDecimal;

@Service
public class MedicoServices {

	@Autowired
	private MedicoRepository medicoRepository;
	
	@Autowired
	private PagedResourcesAssembler<MedicoVO> _assembler;
	
	public PagedModel<EntityModel<MedicoVO>> findAll(Pageable pageable) {
		
		var personPage = medicoRepository.findAll(pageable);
		
		var personVosPage = personPage.map(p -> DozerMapper.parseObject(p, MedicoVO.class));
		personVosPage.map(p -> p.add(linkTo(methodOn(MedicoController.class).findById(p.getIdMedico())).withSelfRel()));
		
		Link link = linkTo(methodOn(MedicoController.class).findAll(pageable.getPageNumber(), pageable.getPageSize(), "asc")).withSelfRel();
		return _assembler.toModel(personVosPage, link);
	}

	public MedicoVO findById(Long id) {
		
		var entity = medicoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Nenhum médico encontrado para este ID!"));
		var vo = DozerMapper.parseObject(entity, MedicoVO.class);
		vo.add(linkTo(methodOn(MedicoController.class).findById(id)).withSelfRel());
		return vo;
	}
	
	public MedicoVO create(MedicoVO medicoVO) {
		
		if(medicoVO == null) throw new RequiredObjectIsNullException();
		
		var entity = DozerMapper.parseObject(medicoVO, Medico.class);
		var vo = DozerMapper.parseObject(medicoRepository.save(entity), MedicoVO.class);
		vo.add(linkTo(methodOn(MedicoController.class).findById(vo.getIdMedico())).withSelfRel());
		return vo;
	}

	@Transactional
	public MedicoVO updateLimite(Long id, BigDecimal limite) {

		if (id == null) throw new RequiredObjectIsNullException();

		var entity = medicoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Nenhum médico encontrado para este ID!"));
		entity.setLimite(limite);

		var vo = DozerMapper.parseObject(medicoRepository.save(entity), MedicoVO.class);

		vo.add(linkTo(methodOn(MedicoController.class).findById(vo.getIdMedico())).withSelfRel());
		return vo;
	}
	
	public void delete(Long id) {
		
		var entity = medicoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		medicoRepository.delete(entity);
		
	}
	
}
