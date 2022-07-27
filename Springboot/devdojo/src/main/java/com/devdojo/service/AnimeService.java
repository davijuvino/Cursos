package com.devdojo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devdojo.exception.BadRequestException;
import com.devdojo.model.dto.AnimeDTO;
import com.devdojo.model.entity.Anime;
import com.devdojo.repository.AnimeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AnimeService {

	
	private final AnimeRepository animeRepository;
	
	private final ModelMapper modelMapper;
	
	
	public Page<Anime> findAllPage(Pageable pageable) {
		return animeRepository.findAll(pageable);
	}
	
	
	public List<Anime> findAll() {
		return animeRepository.findAll();
	}
	
	
	public List<Anime> findByName(String name) {
		return animeRepository.findByName(name);
	}
	
	
	public Anime findById(Long id) {
		return animeRepository.findById(id)
				.orElseThrow(() -> new BadRequestException("AnimeRepository not found"));
	}

	@Transactional
	public Anime save(AnimeDTO animeDTO) {
		Anime entity = modelMapper.map(animeDTO, Anime.class);
		return animeRepository.save(entity);
	}

	
	public void delete(long id) {
		animeRepository.delete(findById(id));
		
	}

	
	public void update(Anime anime) {
		
		Anime savedAnime = findById(anime.getId());
		
		AnimeDTO newObjetDto = modelMapper.map(anime, AnimeDTO.class);
		Anime newObjet = modelMapper.map(newObjetDto, Anime.class);
		newObjet.setId(savedAnime.getId());
		
		
		animeRepository.save(newObjet);
		
	}


	public Anime save(Anime build) {
		// TODO Auto-generated method stub
		return null;
	}

}
