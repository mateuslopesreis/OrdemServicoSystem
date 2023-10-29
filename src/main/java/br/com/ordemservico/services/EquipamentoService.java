package br.com.ordemservico.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ordemservico.dto.ClienteDTO;
import br.com.ordemservico.dto.EquipamentoDTO;
import br.com.ordemservico.entities.Cliente;
import br.com.ordemservico.entities.Equipamento;
import br.com.ordemservico.enums.Dispositivo;
import br.com.ordemservico.enums.TipoServico;
import br.com.ordemservico.repositories.EquipamentoRepository;
import br.com.ordemservico.services.exceptions.DataBaseException;
import br.com.ordemservico.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class EquipamentoService {

	@Autowired  //diz para o service se tem injeção de dependencia
	private EquipamentoRepository repository; //injeção de depedencia para poder acessar o repository
	
	@Transactional(readOnly = true) 
	
	public List<EquipamentoDTO>findAll(){
		List<Equipamento> lista = repository.findAll();
		
		return lista.stream().map(x ->  new EquipamentoDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public EquipamentoDTO findById(Long id) {
		Optional<Equipamento> obj = repository.findById(id);
		Equipamento entity = obj.get();
		return new EquipamentoDTO(entity);
	}

	@Transactional
	public EquipamentoDTO insert(EquipamentoDTO dto) {
		Equipamento entity = new Equipamento();
		entity.setNome(dto.getNome());
		entity.setDescricao(dto.getDescricao());
		entity.setDispositivo(Dispositivo.toEnum(dto.getDispositivo().getCod()));
		entity.setMarca(dto.getMarca());
		entity.setFoto(dto.getFoto());
		entity.setQuantidade(dto.getQuantidade());
		
		entity = repository.save(entity);
		
		return new EquipamentoDTO(entity);
	}


	@Transactional
	public EquipamentoDTO update(Long id, EquipamentoDTO dto) {
		
		try {
			Equipamento entity = repository.getReferenceById(id);
		
			entity.setNome(dto.getNome());
			entity.setDescricao(dto.getDescricao());
			entity.setDispositivo(Dispositivo.toEnum(dto.getDispositivo().getCod()));   
			entity.setMarca(dto.getMarca());
			entity.setFoto(dto.getFoto());
			entity.setQuantidade(dto.getQuantidade());
			
			
			entity = repository.save(entity);
			return new EquipamentoDTO(entity);
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
