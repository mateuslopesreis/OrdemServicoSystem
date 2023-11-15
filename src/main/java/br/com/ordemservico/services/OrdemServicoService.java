package br.com.ordemservico.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ordemservico.dto.OrdemServicoDTO;
import br.com.ordemservico.entities.OrdemServico;
import br.com.ordemservico.enums.Prioridade;
import br.com.ordemservico.enums.Status;
import br.com.ordemservico.enums.TipoServico;
import br.com.ordemservico.repositories.OrdemServicoRepository;
import br.com.ordemservico.services.exceptions.DataBaseException;
import br.com.ordemservico.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class OrdemServicoService {

	@Autowired  //diz para o service se tem injeção de dependencia
	private OrdemServicoRepository repository; //injeção de depedencia para poder acessar o repository
	
	@Transactional(readOnly = true) 
	
	public List<OrdemServicoDTO>findAll(){
		List<OrdemServico> lista = repository.findAll();
		
		return lista.stream().map(x -> new OrdemServicoDTO(x, x.getAtendimentos())).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public OrdemServicoDTO findById(Long id) {
		Optional<OrdemServico> obj = repository.findById(id);
		OrdemServico entity = obj.get();
		return new OrdemServicoDTO(entity, entity.getAtendimentos());
	}

	@Transactional
	public OrdemServicoDTO insert(OrdemServicoDTO dto) {
		OrdemServico entity = new OrdemServico();
		entity.setTitulo(dto.getTitulo());
	//	entity.setDataAbertura(dto.getDataAbertura());
	//	entity.setDataFechamento(dto.getDataFechamento());
		entity.setTipoServico(TipoServico.toEnum(dto.getTipoServico().getCod()));  
		entity.setPrioridade(Prioridade.toEnum(dto.getPrioridade().getCod()));   
		entity.setStatus(Status.toEnum(dto.getStatus().getCod()));
		entity.setDescricao(dto.getDescricao());
		entity.setCliente(dto.getCliente());
		
		
		
		
		entity = repository.save(entity);
		
		return new OrdemServicoDTO(entity);
	}
	
	//private OrdemServico fromDTO(OrdemServicoDTO obj) {
	//	OrdemServico newObj = new OrdemServico();
	//	newObj.setId(obj.getId());
	//	newObj.setPrioridade(Prioridade.toEnum(obj.getPrioridade()));
	//	if(newObj.getStatus().getCod().equals(2)) {
	//		newObj.setDataFechamento(LocalDateTime.now());
			
	//	}
	//	return repository.save(newObj);
//	}
	

	@Transactional
	public OrdemServicoDTO update(Long id, OrdemServicoDTO dto) {
		
		try {
			OrdemServico entity = repository.getReferenceById(id);
		
			entity.setTitulo(dto.getTitulo());
			entity.setDataAbertura(dto.getDataAbertura());
			entity.setDataFechamento(dto.getDataFechamento());
			entity.setTipoServico(TipoServico.toEnum(dto.getTipoServico().getCod()));  
			entity.setPrioridade(Prioridade.toEnum(dto.getPrioridade().getCod()));   
			entity.setStatus(Status.toEnum(dto.getStatus().getCod()));
			entity.setDescricao(dto.getDescricao());
			entity.setCliente(dto.getCliente());
			
			if(entity.getStatus().getCod().equals(2)) {
				entity.setDataFechamento(LocalDateTime.now());
				
			}
			
			entity = repository.save(entity);
			return new OrdemServicoDTO(entity);
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
