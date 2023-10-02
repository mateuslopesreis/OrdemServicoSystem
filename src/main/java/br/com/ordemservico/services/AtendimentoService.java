package br.com.ordemservico.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ordemservico.dto.AtendimentoDTO;
import br.com.ordemservico.dto.AtendimentoStatusTecnicoDTO;
import br.com.ordemservico.dto.OrdemServicoTecnicoAtendimentoDTO;
import br.com.ordemservico.entities.Atendimento;
import br.com.ordemservico.repositories.AtendimentoRepository;
import br.com.ordemservico.services.exceptions.DataBaseException;
import br.com.ordemservico.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class AtendimentoService {
	
	@Autowired
	private AtendimentoRepository repository;
	
	@Transactional(readOnly = true) 
	
	public List<AtendimentoDTO>findAll(){
		
		List<Atendimento> lista = repository.findAll();
		
		return lista.stream().map(x -> new AtendimentoDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public AtendimentoDTO findById(Long id) {
		Optional<Atendimento> obj = repository.findById(id);
		Atendimento entity = obj.orElseThrow(
				()-> new ResourceNotFoundException(
						"O registro solicitado não foi localizado."
						));
		return new AtendimentoDTO(entity);
	}
	
	@Transactional(readOnly = true)
	public List<AtendimentoStatusTecnicoDTO> findByStatusTecnicoSQL(int  status, String nome){
		return repository.findByStatusTecnicoSQL(status, nome);
	}
	
	
	@Transactional(readOnly = true)
	public List<OrdemServicoTecnicoAtendimentoDTO> findByTecnicoAtendimentoSQL(int  status){
		return repository.findByTecnicoAtendimentoSQL(status);
	}
	

	public AtendimentoDTO insert(AtendimentoDTO dto) {
		Atendimento entity = new Atendimento();
		entity.setRelatoTecnico(dto.getRelatoTecnico());
		entity.setFuncionario(dto.getFuncionario());
		entity.setOs(dto.getOs());
		
		
		entity = repository.save(entity);
		
		return new AtendimentoDTO(entity);
	}

	@Transactional
	public AtendimentoDTO update(Long id, AtendimentoDTO dto) {
		try {
			Atendimento entity = repository.getReferenceById(id);
			entity.setRelatoTecnico(dto.getRelatoTecnico());
			entity.setFuncionario(dto.getFuncionario());
			entity.setOs(dto.getOs());
			
			entity = repository.save(entity);
			return new AtendimentoDTO(entity);
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
