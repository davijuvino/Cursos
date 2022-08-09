package com.devdojo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.devdojo.model.dto.AnimeDTO;
import com.devdojo.model.entity.Anime;
import com.devdojo.repository.AnimeRepository;


@ExtendWith(SpringExtension.class)
public class AnimeServiceTests {


	@InjectMocks  /*Tests de Classes*/
	private AnimeService injectMockService;
	
	
	@Mock   /*Tests de Classes dentro do service*/
	private AnimeRepository repositoryMock;
	
	@Mock
	private ModelMapper modelMapper;
	
	
	@BeforeEach
	void setup() {	
	
		Mockito.when(repositoryMock.findAll(Mockito.any(
				PageRequest.class))).thenReturn(
						new PageImpl<>(List.of(Anime.builder().id(1L).name("AA").build())));
		
		Mockito.when(repositoryMock.findAll()).thenReturn(List.of(Anime.builder().id(1L).name("AA").build()));
		
		Mockito.when(repositoryMock.findById(Mockito.anyLong())).thenReturn(Optional.of(Anime.builder().id(1L).name("AA")
				.build()));
		
		Mockito.when(repositoryMock.findByName(Mockito.anyString())).thenReturn(List.of(Anime.builder().id(1L).name("AA")
				.build()));
		
		Mockito.when(repositoryMock.save(/*modelMapper.map(AnimeDTO.class, Anime.class)*/Mockito.any())).thenReturn(
				Anime.builder().id(1L).name("AA").build());
		
		
		Mockito.doNothing()
		.when(repositoryMock).delete(Mockito.any(Anime.class));
		
	}
	
	@Test
	@DisplayName("find all page returns list of anime inside page object when successful")
	void findAllPage_ReturnOfAnimesInsidePage_whenSuccessful() {
		Anime expecteName = Anime.builder().id(1L).name("AA").build();
		
		Page<Anime> mockPage = injectMockService.findAllPage(PageRequest.of(1,1));
		
		Assertions.assertThat(mockPage.toList()
				.get(0)
				.getName())
		.isEqualTo(expecteName.getName());
		
	}
	
	
	@Test
	@DisplayName("List returns list of anime when successful")
	void findAll_ReturnOfAnimes_whenSuccessful() {
		Anime expecteName = Anime.builder().id(1L).name("AA").build();
		
		List<Anime> mockAnimelist = injectMockService.findAll();
		
		Assertions.assertThat(mockAnimelist.get(0).getName())
		.isEqualTo(expecteName.getName());
		
	}
	
	
	@Test
	@DisplayName("Find By id returns anime when successful")
	void findById_ReturnOfAnime_whenSuccessful() {
		Anime expecteID = Anime.builder().id(1L).name("AA").build();
		
		Anime mockAnimeId = injectMockService.findById(1L);
		
		Assertions.assertThat(mockAnimeId.getId())
		.isEqualTo(expecteID.getId());
		
	}
	
	
	@Test
	@DisplayName("Find By name returns anime when successful")
	void findByName_ReturnOfAnime_whenSuccessful() {
	
        Anime expecteName = Anime.builder().id(1L).name("AA").build();
		List<Anime> mockAnimeName = injectMockService.findByName("");
		
		Assertions.assertThat(
				mockAnimeName.get(0).getName())
		.isEqualTo(expecteName.getName());
		
	}
	
	
	
	@Test
	@DisplayName("Find By name returns an empty list of  when anime is not found")
	void findByName_ReturnAnEmptyListOfwhenAnime_IsNotFound() {
		Mockito.when(repositoryMock.findByName(
				Mockito.anyString()))
		.thenReturn(Collections.emptyList());
		
		List<Anime> mockAnimes = injectMockService.findByName("");
		
		Assertions.assertThat(mockAnimes)
		.isNotNull()
		.isEmpty();
		
	}
	
	
	
	@Test
	@DisplayName("Save returns anime when successful")
	void givenSaveMethodMocked_WhenSaveInvoked_ValueReturnedWhenSuccessful() {
		
		Anime mockAnime = injectMockService.save(AnimeDTO.builder().build());
		
		Assertions.assertThat(mockAnime)
		.isNotNull()
		.isEqualTo(Anime.builder()
				.id(1l)
				.name("AA").build());
		
	}	
	
	
	
//	@Test
//	@DisplayName("Update returns anime when successful")
//	void givenUpdateMethodMocked_WhenUpdateInvoked_ValueVoidWhenSuccessful() {
//
//		Assertions.assertThatCode(() -> injectMockService.update(
//				Anime.builder().build()))
//		.doesNotThrowAnyException();
//		
//	}
//	
	
	
	@Test
	@DisplayName("Delete returns anime when successful")
	void givenDeleteMethodMocked_WhenDeleteInvoked_ValueVoidWhenSuccessful() {

		Assertions.assertThatCode(() -> injectMockService.delete(1))
		.doesNotThrowAnyException();
		
	}
	
}