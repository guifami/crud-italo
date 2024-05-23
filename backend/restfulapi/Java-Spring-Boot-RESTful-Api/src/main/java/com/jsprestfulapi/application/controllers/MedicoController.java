package com.jsprestfulapi.application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.jsprestfulapi.application.services.MedicoServices;
import com.jsprestfulapi.domain.data.vo.v1.MedicoVO;
import com.jsprestfulapi.util.MediaType;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.math.BigDecimal;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/medico/v1")
@Tag(name = "Médicos", description = "Endpoints para gerenciamento de Médicos")
public class MedicoController {
	
	@Autowired
	private MedicoServices medicoServices;
	
	@GetMapping(produces = {
			MediaType.APPLICATION_JSON, 
			MediaType.APPLICATION_XML,
			MediaType.APPLICATION_YML})
	@Operation(summary = "Busca todos os médicos", description = "Busca todos os médicos", tags = {"Médicos"},
				responses = {
					@ApiResponse(description = "Success", responseCode = "200", 
						content = {
							@Content(
								mediaType = "application/json",
								array = @ArraySchema(schema = @Schema(implementation = MedicoVO.class))
							)
						}),
					@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
					@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
					@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
					@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
				}
			)
	
	public ResponseEntity<PagedModel<EntityModel<MedicoVO>>> findAll(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size,
			@RequestParam(value = "direction", defaultValue = "asc") String direction
			){
		
		var sortDirection = "desc".equalsIgnoreCase(direction) ? Direction.DESC : Direction.ASC;
		
		Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, "nome"));
		return ResponseEntity.ok(medicoServices.findAll(pageable));
	}
	
	@GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	@Operation(summary = "Encontrar um Médico", description = "Médico Encontrado", tags = {"Médicos"},
	responses = {
		@ApiResponse(description = "Success", responseCode = "200", 
			content = @Content(schema = @Schema(implementation = MedicoVO.class))
		),
		@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
		@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
		@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
		@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
		@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
		}
	)
	public MedicoVO findById(@PathVariable(value = "id") Long id){
		return medicoServices.findById(id);
	}
	
	@PostMapping(consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML}, 
				 produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	@Operation(summary = "Adicionar um Médico", description = "Adicionado um Médico em JSON, XML ou YML", tags = {"Médicos"},
	responses = {
		@ApiResponse(description = "Success", responseCode = "200", 
			content = @Content(schema = @Schema(implementation = MedicoVO.class))
		),
		@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
		@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
		@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
		}
	)
	public MedicoVO create(@RequestBody MedicoVO person){
		return medicoServices.create(person);
	}

	@PatchMapping(value = "/{id}", consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, "application/x-yaml"},
			produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, "application/x-yaml"})
	@Operation(summary = "Atualizar o limite do Médico", description = "Atualizado", tags = {"Médicos"},
			responses = {
					@ApiResponse(description = "Success", responseCode = "200",
							content = @Content(schema = @Schema(implementation = MedicoVO.class))
					),
					@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
					@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
					@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
					@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
			}
	)
	public MedicoVO update(@PathVariable("id") Long id, @RequestBody Map<String, BigDecimal> updateData) {
		BigDecimal limite = updateData.get("limite");
		return medicoServices.updateLimite(id, limite);
	}
	
	@DeleteMapping(value = "/{id}")
	@Operation(summary = "Deletar um Médico", description = "Deletado", tags = {"Médicos"},
	responses = {
		@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
		@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
		@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
		@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
		@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
		}
	)
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){
		medicoServices.delete(id);
		return ResponseEntity.noContent().build();
	}
}