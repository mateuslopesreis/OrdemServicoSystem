package br.com.ordemservico.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ordemservico.dto.ComodatoDTO;
import br.com.ordemservico.dto.EquipamentoItemDTO;
import br.com.ordemservico.entities.Comodato;
import br.com.ordemservico.enums.Situacao;
import br.com.ordemservico.repositories.ComodatoRepository;
import br.com.ordemservico.services.exceptions.DataBaseException;
import br.com.ordemservico.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ComodatoService {
	
	
	@Autowired  //diz para o service se tem injeção de dependencia
	private ComodatoRepository repository; //injeção de depedencia para poder acessar o repository
	
	@Transactional(readOnly = true) 
	
	public List<ComodatoDTO>findAll(){
		List<Comodato> lista = repository.findAll();
		
		return lista.stream().map(x -> new ComodatoDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public ComodatoDTO findById(Long id) {
		Optional<Comodato> obj = repository.findById(id);
		Comodato entity = obj.get();
		return new ComodatoDTO(entity);
	}

	@Transactional
	public ComodatoDTO insert(ComodatoDTO dto) {
		Comodato entity = new Comodato();
		entity.setDataInstalacao(dto.getDataInstalacao());
		entity.setDataDevolucao(dto.getDataDevolucao());
		entity.setOs(dto.getOs());
		entity.setEquipamentoItem(dto.getEquipamentoItem());
		
		entity = repository.save(entity);
		
		return new ComodatoDTO(entity);
	}

	@Transactional
	public ComodatoDTO update(Long id, ComodatoDTO dto) {
		
		try {
			Comodato entity = repository.getReferenceById(id);
			
			if(org.springframework.util.StringUtils.hasText(dto.getDataDevolucao())) {
				entity.getEquipamentoItem().setSituacao(Situacao.DISPONIVEL);
			} else {
			
			entity.setDataInstalacao(dto.getDataInstalacao());
			entity.setDataDevolucao(dto.getDataDevolucao());
			entity.setOs(dto.getOs());
			entity.setEquipamentoItem(dto.getEquipamentoItem());
			}
			
			entity = repository.save(entity);
			return new ComodatoDTO(entity);
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("O recurso com o ID "+id+" não foi localizado");
		}
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}catch(DataIntegrityViolationException e) {
			throw new DataBaseException("Violação de Integridade");
		}
	}
	}
