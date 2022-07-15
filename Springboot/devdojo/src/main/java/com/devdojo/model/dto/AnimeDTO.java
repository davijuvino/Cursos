package com.devdojo.model.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class AnimeDTO {
	
	@NotEmpty(message = "name cannot be empty")
	@NotNull
	private String name;

}
