package br.com.ordemservico.services;

import java.util.List;
import java.util.stream.Collectors;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ordemservico.dto.ClienteDTO;
import br.com.ordemservico.entities.Cliente;
import br.com.ordemservico.repositories.ClienteRepository;
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

}
