package br.com.restapi.forum.controller;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.restapi.forum.dto.AtualizarTopicoFormDTO;
import br.com.restapi.forum.dto.TopicoDTO;
import br.com.restapi.forum.dto.TopicoFormDTO;
import br.com.restapi.forum.model.Topico;
import br.com.restapi.forum.repository.CursoRepository;
import br.com.restapi.forum.repository.TopicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/topicos")
public class TopicosController {
	
	@Autowired
	TopicoRepository topicoRepository;
	
	@Autowired
	CursoRepository cursoRepository;

	@GetMapping
	@Cacheable(value = "listaTopicos")
	public Page<Topico> lista(@RequestParam(required = false) String nomeCurso, 
			@PageableDefault(sort = "dataCriacao", direction = Direction.ASC, page = 0, size = 10) Pageable paginacao){	
				
		if(nomeCurso != null) {
			Page<Topico> topicos = topicoRepository.findAllByCursoNome(nomeCurso, paginacao);
			return topicos;

		} else {
			Page<Topico> topicos = topicoRepository.findAll(paginacao);
			return topicos;
		}
				
	}
	
	@PostMapping
	@Transactional
	@CacheEvict(value = "listaTopicos", allEntries = true)
	public ResponseEntity<Topico> cadastrar(@Valid @RequestBody TopicoFormDTO form,  UriComponentsBuilder uriBuilder) {
		Topico topico = form.toTopico(cursoRepository);
		topicoRepository.save(topico);
		
		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
		return ResponseEntity.created(uri).body(topico);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TopicoDTO> detalhar(@PathVariable Long id) {		
		Optional<Topico> optTopico = topicoRepository.findById(id);
		TopicoDTO topico = new TopicoDTO();
		
		if(!optTopico.isPresent())
			return ResponseEntity.notFound().build();
		
		topico.toDTO(optTopico.get());
		return ResponseEntity.ok(topico);
	}
	
	@PutMapping("/{id}")
	@Transactional
	@CacheEvict(value = "listaTopicos", allEntries = true)
	public ResponseEntity<Topico> atualizar(@PathVariable Long id, @Valid @RequestBody AtualizarTopicoFormDTO form) {
		
		Optional<Topico> optTopico = topicoRepository.findById(id);

		if(!optTopico.isPresent())
			return ResponseEntity.notFound().build();
		
		Topico topico = form.atualizarTopico(optTopico.get(), topicoRepository);
		return ResponseEntity.ok(topico);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	@CacheEvict(value = "listaTopicos", allEntries = true)
	public ResponseEntity<?> atualizar(@PathVariable Long id) {
		
		Optional<Topico> optTopico = topicoRepository.findById(id);

		if(!optTopico.isPresent())
			return ResponseEntity.notFound().build();
		
		topicoRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}

