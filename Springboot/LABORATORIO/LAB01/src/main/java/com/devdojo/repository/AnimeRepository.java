package com.devdojo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devdojo.model.entity.Anime;


public interface AnimeRepository extends JpaRepository<Anime, Long>  {

	List<Anime> findByName(String name);
}
