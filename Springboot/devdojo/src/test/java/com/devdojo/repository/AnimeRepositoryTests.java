package com.devdojo.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.devdojo.model.entity.Anime;

@ActiveProfiles("test")
@DataJpaTest
public class AnimeRepositoryTests {

	@Autowired
	private AnimeRepository repository;

	@Test
	void testSaved() {
		assertThat(repository.save(Anime.builder()
			  .id(1L)
			  .name("AA")
			  .build())).isNotNull();
	}
}
