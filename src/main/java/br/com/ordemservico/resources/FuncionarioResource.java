package br.com.ordemservico.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.ordemservico.dto.FuncionarioDTO;
import br.com.ordemservico.services.FuncionarioService;

@RestController
@RequestMapping(value= "/funcionarios")
public class FuncionarioResource {
	
@Autowired
	
	private FuncionarioService service;
	
	@GetMapping()
	public ResponseEntity<List<FuncionarioDTO>>findAll(){
		List<FuncionarioDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value= "/{id}")
	public ResponseEntity<FuncionarioDTO>findById(@PathVariable Long id){
		FuncionarioDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	
	
	
	
	
	@PostMapping
	public ResponseEntity<FuncionarioDTO> insert(@RequestBody FuncionarioDTO dto){
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(dto.getId())
				.toUri();
		
		return ResponseEntity.created(uri).body(null);

	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<FuncionarioDTO> Update(@PathVariable Long id, @RequestBody FuncionarioDTO dto){
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	

}
