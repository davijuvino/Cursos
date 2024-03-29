package com.devdojo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devdojo.model.dto.AnimeDTO;
import com.devdojo.model.entity.Anime;
import com.devdojo.service.AnimeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("animes")
@RequiredArgsConstructor
public class AnimeController {
	
	
	private final AnimeService animeService;
	
	
	
	@GetMapping(path = "/findPage")
	public ResponseEntity<Page<Anime>> findAllPage(Pageable pageable) {
		return ResponseEntity.ok(animeService.findAllPage(pageable)) ;
	}

	@GetMapping
	public ResponseEntity<List<Anime>> findAll() {
		return ResponseEntity.ok(animeService.findAll()) ;
	}
	
	
	@GetMapping(path = "/findName")
	public ResponseEntity<List<Anime>> findByName(@RequestParam String name) {
	    return ResponseEntity.ok(animeService.findByName(name)) ;
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Anime> findById(@PathVariable long id) {
	    return ResponseEntity.ok(animeService.findById(id)) ;
	}
	
	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Anime> save(@RequestBody @Valid AnimeDTO animeDTO){
		return new ResponseEntity<>(animeService.save(animeDTO), HttpStatus.CREATED);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable long id){
		animeService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			
	}
		
	@PutMapping
	public ResponseEntity<Void> update(@RequestBody Anime anime){
		animeService.update(anime);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	

}
