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

import br.com.ordemservico.dto.AtendimentoDTO;
import br.com.ordemservico.dto.AtendimentoStatusFechadoTecnicoDTO;
import br.com.ordemservico.dto.AtendimentoStatusTecnicoDTO;
import br.com.ordemservico.dto.ClienteDTO;
import br.com.ordemservico.dto.NumeroAtendimentoDTO;
import br.com.ordemservico.dto.OrdemServicoTecnicoAtendimentoDTO;
import br.com.ordemservico.dto.OrdemServicoTecnicoSemAtendimentoDTO;
import br.com.ordemservico.dto.TipoServicoAtendimentosDTO;
import br.com.ordemservico.services.AtendimentoService;

@RestController
@RequestMapping(value = "/atendimentos")
public class AtendimentoResource {
	
	@Autowired
	private AtendimentoService service;
	
	@GetMapping
	public ResponseEntity<List<AtendimentoDTO>> findAll(){
		List<AtendimentoDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<AtendimentoDTO>findById(@PathVariable Long id){
		AtendimentoDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@GetMapping(value = "/statustecnicosql/{status}/{nome}")
	public ResponseEntity<List<AtendimentoStatusTecnicoDTO>> findByStatusTecnicoSQL(@PathVariable int status, @PathVariable String nome){
		List<AtendimentoStatusTecnicoDTO> lista = service.findByStatusTecnicoSQL(status, nome);
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value = "/statusfechadotecnicosql/{status}/{nome}")
	public ResponseEntity<List<AtendimentoStatusFechadoTecnicoDTO>> findByStatusFechadoTecnicoSQL(@PathVariable int status, @PathVariable String nome){
		List<AtendimentoStatusFechadoTecnicoDTO> lista = service.findByStatusFechadoTecnicoSQL(status, nome);
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value = "/tecnicoatendimentosql/{status}")
	public ResponseEntity<List<OrdemServicoTecnicoAtendimentoDTO>> findByTecnicoAtendimentoSQL(@PathVariable int status){
		List<OrdemServicoTecnicoAtendimentoDTO> lista = service.findByTecnicoAtendimentoSQL(status);
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value = "/tecnicosematendimentosql/{status}")
	public ResponseEntity<List<OrdemServicoTecnicoSemAtendimentoDTO>> findByTecnicoSemAtendimentoSQL(@PathVariable int status){
		List<OrdemServicoTecnicoSemAtendimentoDTO> lista = service.findByTecnicoSemAtendimentoSQL(status);
		return ResponseEntity.ok().body(lista);
	}
	
	@GetMapping(value = "/numeroatendimentosql/{nome}")
	public ResponseEntity<List<NumeroAtendimentoDTO>> findByNumeroAtendimentoSQL(@PathVariable String nome){
		List<NumeroAtendimentoDTO> lista = service.findByNumeroAtendimentoSQL(nome);
		return ResponseEntity.ok().body(lista);
	}
	
//	@GetMapping(value = "/tiposervicoatendimentossql")
//	public ResponseEntity<List<TipoServicoAtendimentosDTO>> findByTipoServicoAtendimentosSQL(){
//		List<TipoServicoAtendimentosDTO> lista = service.findByTipoServicoAtendimentosSQL();
//		return ResponseEntity.ok().body(lista);
//	}
	
	
	@PostMapping
	public ResponseEntity<AtendimentoDTO> insert(@RequestBody AtendimentoDTO dto){
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(dto.getId())
				.toUri();
		
		return ResponseEntity.created(uri).body(null);

	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<AtendimentoDTO> Update(@PathVariable Long id, @RequestBody AtendimentoDTO dto){
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	

}
