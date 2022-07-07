package com.devdojo.service;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.devdojo.model.dto.AnimeDTO;
import com.devdojo.model.entity.Anime;
import com.devdojo.repository.AnimeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AnimeService {

	
	private final AnimeRepository animeRepository;
	
	public List<Anime> listAll() {
		return animeRepository.findAll();
	}
	
	public Anime findById(Long id) {
		return animeRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "AnimeRepository not found"));
	}

	public Anime save(AnimeDTO animeDTO) {
		return animeRepository.save(Anime.builder().name(animeDTO.getName()).build());
	}

	public void delete(long id) {
		animeRepository.delete(findById(id));
		
	}

	public void update(Anime anime) {
		
		Anime animeUpdate = animeRepository.findById(anime.getId())
		.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "AnimeRepository not found"));
		
		Anime newobjet = Anime.builder()
				.id(animeUpdate.getId())
				.name(anime.getName())
				.build();
		
		animeRepository.save(newobjet);
		
	}
}
