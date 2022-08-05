package com.devdojo.controller;

import java.util.Collections;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.devdojo.model.dto.AnimeDTO;
import com.devdojo.model.entity.Anime;
import com.devdojo.service.AnimeService;


@ExtendWith(SpringExtension.class)
public class AnimeControllerTests {


	@InjectMocks  /*Tests de Classes*/
	private AnimeController injectMockController;
	
	
	@Mock   /*Tests de Classes dentro do controller*/
	private AnimeService mockChamaClasseService;
	
	@BeforeEach
	void setup() {
		
		//PageImpl<Anime> LISTPAGE = new PageImpl<>(List.of(Anime.builder().id(1L).name("AA").build()));
		/*Quando chamar o seviço mockado ira retornar o valor definido (LISTPAGE) por isso passamos (any) */
//		BDDMockito.when(mockChamaClasseService.listAll(
//				ArgumentMatchers.any()))
//		.thenReturn(LISTPAGE);
		
	
		Mockito.when(mockChamaClasseService.findAllPage(Mockito.any())).thenReturn(new PageImpl<>(List.of(Anime.builder().id(1L).name("AA").build())));
		Mockito.when(mockChamaClasseService.findAll()).thenReturn(List.of(Anime.builder().id(1L).name("AA").build()));
		Mockito.when(mockChamaClasseService.findById(Mockito.anyLong())).thenReturn(Anime.builder().id(1L).name("AA").build());
		Mockito.when(mockChamaClasseService.findByName(Mockito.anyString())).thenReturn(List.of(Anime.builder().id(1L).name("AA").build()));
		Mockito.when(mockChamaClasseService.save(Mockito.any(AnimeDTO.class))).thenReturn(Anime.builder().id(1L).name("AA").build());
		Mockito.doNothing()
		.when(mockChamaClasseService).update(Mockito.any(Anime.class));
		
		Mockito.doNothing()
		.when(mockChamaClasseService).delete(Mockito.anyLong());
		
	}
	
	@Test
	@DisplayName("List returns list of anime inside page object when successful")
	void list_ReturnOfAnimesInsidePage_whenSuccessful() {
		Anime expecteName = Anime.builder().id(1L).name("AA").build();
		
		Page<Anime> mockPage = injectMockController.findAllPage(null).getBody();
		
		Assertions.assertThat(mockPage.toList()
				.get(0)
				.getName())
		.isEqualTo(expecteName.getName());
		
	}
	
	
	@Test
	@DisplayName("List returns list of anime when successful")
	void findAll_ReturnOfAnimes_whenSuccessful() {
		Anime expecteName = Anime.builder().id(1L).name("AA").build();
		
		List<Anime> mockAnimelist = injectMockController.findAll().getBody();
		
		Assertions.assertThat(mockAnimelist.get(0).getName())
		.isEqualTo(expecteName.getName());
		
	}
	
	
	@Test
	@DisplayName("Find By id returns anime when successful")
	void findById_ReturnOfAnime_whenSuccessful() {
		Anime expecteID = Anime.builder().id(1L).name("AA").build();
		
		Anime mockAnimeId = injectMockController.findById(0).getBody();
		
		Assertions.assertThat(mockAnimeId.getId())
		.isEqualTo(expecteID.getId());
		
	}
	
	
	@Test
	@DisplayName("Find By name returns anime when successful")
	void findByName_ReturnOfAnime_whenSuccessful() {
	
        Anime expecteName = Anime.builder().id(1L).name("AA").build();
		List<Anime> mockAnimeName = injectMockController.findByName("").getBody();
		
		Assertions.assertThat(
				mockAnimeName.get(0).getName())
		.isEqualTo(expecteName.getName());
		
	}
	
	
	
	@Test
	@DisplayName("Find By returns an empty list of  when anime is not found")
	void findByName_ReturnAnEmptyListOfwhenAnime_IsNotFound() {
		Mockito.when(mockChamaClasseService.findByName(
				Mockito.anyString()))
		.thenReturn(Collections.emptyList());
		
		List<Anime> mockAnimes = injectMockController.findByName("").getBody();
		
		Assertions.assertThat(mockAnimes)
		.isNotNull()
		.isEmpty();
		
	}
	
	
	
	@Test
	@DisplayName("Save returns anime when successful")
	void givenSaveMethodMocked_WhenSaveInvoked_ValueReturnedWhenSuccessful() {

		Anime mockAnime = injectMockController.save(AnimeDTO.builder().build()).getBody();
		
		Assertions.assertThat(mockAnime)
		.isNotNull()
		.isEqualTo(Anime.builder()
				.id(1l)
				.name("AA").build());
		
	}	
	
	
	
	@Test
	@DisplayName("Update returns anime when successful")
	void givenUpdateMethodMocked_WhenUpdateInvoked_ValueVoidWhenSuccessful() {

		Assertions.assertThatCode(() -> injectMockController.update(
				Anime.builder().build()).getBody())
		.doesNotThrowAnyException();
		
	}
	
	
	
	@Test
	@DisplayName("Delete returns anime when successful")
	void givenDeleteMethodMocked_WhenDeleteInvoked_ValueVoidWhenSuccessful() {

		Assertions.assertThatCode(() -> injectMockController.delete(1))
		.doesNotThrowAnyException();
		
	}
	
	
	
	
}
