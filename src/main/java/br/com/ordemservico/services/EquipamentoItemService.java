package br.com.ordemservico.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ordemservico.dto.EquipamentoItemDTO;
import br.com.ordemservico.entities.EquipamentoItem;
import br.com.ordemservico.enums.Situacao;
import br.com.ordemservico.repositories.EquipamentoItemRepository;
import br.com.ordemservico.services.exceptions.DataBaseException;
import br.com.ordemservico.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;


@Service
public class EquipamentoItemService {
	
	@Autowired  //diz para o service se tem injeção de dependencia
	private EquipamentoItemRepository repository; //injeção de depedencia para poder acessar o repository
	
	@Transactional(readOnly = true) 
	
	public List<EquipamentoItemDTO>findAll(){
		List<EquipamentoItem> lista = repository.findAll();
		
		return lista.stream().map(x -> new EquipamentoItemDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public EquipamentoItemDTO findById(Long id) {
		Optional<EquipamentoItem> obj = repository.findById(id);
		EquipamentoItem entity = obj.get();
		return new EquipamentoItemDTO(entity);
	}

	@Transactional
	public EquipamentoItemDTO insert(EquipamentoItemDTO dto) {
		EquipamentoItem entity = new EquipamentoItem();
		entity.setSerial(dto.getSerial());
		entity.setSituacao(dto.getSituacao());
		entity.setEquipamento(dto.getEquipamento());

		
		entity = repository.save(entity);
		
		return new EquipamentoItemDTO(entity);
	}

	@Transactional
	public EquipamentoItemDTO update(Long id, EquipamentoItemDTO dto) {
		
		try {
			EquipamentoItem entity = repository.getReferenceById(id);
			entity.setSerial(dto.getSerial());
			entity.setSituacao(dto.getSituacao());
			entity.setEquipamento(dto.getEquipamento());

			
			entity = repository.save(entity);
			return new EquipamentoItemDTO(entity);
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
