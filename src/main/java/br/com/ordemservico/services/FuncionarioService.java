package br.com.ordemservico.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ordemservico.dto.FuncionarioDTO;
import br.com.ordemservico.entities.Funcionario;
import br.com.ordemservico.repositories.FuncionarioRepository;
import br.com.ordemservico.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;


@Service
public class FuncionarioService {
	
	@Autowired  //diz para o service se tem injeção de dependencia
	private FuncionarioRepository repository; //injeção de depedencia para poder acessar o repository
	
	@Transactional(readOnly = true) 
	
	public List<FuncionarioDTO>findAll(){
		List<Funcionario> lista = repository.findAll();
		
		return lista.stream().map(x -> new FuncionarioDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public FuncionarioDTO findById(Long id) {
		Optional<Funcionario> obj = repository.findById(id);
		Funcionario entity = obj.get();
		return new FuncionarioDTO(entity);
	}

	public FuncionarioDTO insert(FuncionarioDTO dto) {
		Funcionario entity = new Funcionario();
		entity.setNome(dto.getNome());
		entity.setEmail(dto.getEmail());
		entity.setTelefone(dto.getTelefone());
		entity.setPerfil(dto.getPerfil());
		entity.setLogin(dto.getLogin());
		entity.setSenha(dto.getSenha());
		
		entity = repository.save(entity);
		
		return new FuncionarioDTO(entity);
	}

	public FuncionarioDTO update(Long id, FuncionarioDTO dto) {
		try {
			Funcionario entity = repository.getReferenceById(id);
			entity.setNome(dto.getNome());
			entity.setEmail(dto.getEmail());
			entity.setTelefone(dto.getTelefone());
			entity.setPerfil(dto.getPerfil());
			entity.setLogin(dto.getLogin());
			entity.setSenha(dto.getSenha());
			
			entity = repository.save(entity);
			return new FuncionarioDTO(entity);
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
