package br.com.ordemservico.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.ordemservico.dto.OrdemServicoDTO;
import br.com.ordemservico.services.OrdemServicoService;

@Controller
@RequestMapping(value= "/ordem_servico")
public class OrdemServicoResource {

@Autowired
	
	private OrdemServicoService service;
	
	@GetMapping()
	public ResponseEntity<List<OrdemServicoDTO>>findAll(){
		List<OrdemServicoDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value= "/{id}")
	public ResponseEntity<OrdemServicoDTO>findById(@PathVariable Long id){
		OrdemServicoDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@PostMapping
	public ResponseEntity<OrdemServicoDTO> insert(@RequestBody OrdemServicoDTO dto){
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(dto.getId())
				.toUri();
		
		return ResponseEntity.created(uri).body(null);

	}
	
	
	@PutMapping(value="/{id}")
	public ResponseEntity<OrdemServicoDTO> Update(@PathVariable Long id, @RequestBody OrdemServicoDTO dto){
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
