package br.com.ordemservico.services;

import java.util.List;
import java.util.stream.Collectors;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.ordemservico.dto.ClienteDTO;
import br.com.ordemservico.entities.Cliente;
import br.com.ordemservico.repositories.ClienteRepository;
import br.com.ordemservico.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;

import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteService {
	

	@Autowired  //diz para o service se tem injeção de dependencia
	private ClienteRepository repository; //injeção de depedencia para poder acessar o repository
	
	@Transactional(readOnly = true) 
	
	public List<ClienteDTO>findAll(){
		List<Cliente> lista = repository.findAll();
		
		return lista.stream().map(x -> new ClienteDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public ClienteDTO findById(Long id) {
		Optional<Cliente> obj = repository.findById(id);
		Cliente entity = obj.get();
		return new ClienteDTO(entity);
	}

	@Transactional
	public ClienteDTO insert(ClienteDTO dto) {
		Cliente entity = new Cliente();
		entity.setNome(dto.getNome());
		entity.setEmail(dto.getEmail());
		entity.setRua(dto.getRua());
		entity.setBairro(dto.getBairro());
		entity.setNumero(dto.getNumero());
		
		entity = repository.save(entity);
		
		return new ClienteDTO(entity);
	}

	@Transactional
	public ClienteDTO update(Long id, ClienteDTO dto) {
		
		try {
			Cliente entity = repository.getReferenceById(id);
			entity.setNome(dto.getNome());
			entity.setEmail(dto.getEmail());
			entity.setRua(dto.getRua());
			entity.setBairro(dto.getBairro());
			entity.setNumero(dto.getNumero());
			
			entity = repository.save(entity);
			return new ClienteDTO(entity);
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("O recurso com o ID "+id+" não foi localizado");
		}
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("O recurso com o ID"+id+" não foi localizado");
		}
	}

}
