package br.com.ordemservico.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ordemservico.dto.ClienteDTO;
import br.com.ordemservico.services.ClienteService;

@RestController
@RequestMapping(value= "/cliente")
public class ClienteResource {

	@Autowired
	
	private ClienteService service;
	
	@GetMapping()
	public ResponseEntity<List<ClienteDTO>>findAll(){
		List<ClienteDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value= "/{id}")
	public ResponseEntity<ClienteDTO>findById(@PathVariable Long id){
		ClienteDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	
}
