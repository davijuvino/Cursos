package com.devdojo.controller;

import java.time.LocalDateTime;
import java.util.List;


import org.springframework.http.HttpStatus;
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

import com.devdojo.model.dto.AnimeDTO;
import com.devdojo.model.entity.Anime;
import com.devdojo.service.AnimeService;
import com.devdojo.util.DateUtil;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("animes")
@Log4j2
@RequiredArgsConstructor
public class AnimalController {
	
	
	private final DateUtil dateUtil;
	
	
	private final AnimeService animeService;
	
	
	
	@GetMapping
	public ResponseEntity<List<Anime>> list() {
	    log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
		return ResponseEntity.ok(animeService.listAll()) ;
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
	public ResponseEntity<Anime> save(@RequestBody AnimeDTO animeDTO){
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
