package com.bootcamp.spring.springwebmvc.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Jedi {

	@NotBlank
	@NotNull
	private String name;

	@NotBlank
	@NotNull
	private String lastName;

	public Jedi() {
	}

	public Jedi(String name, String lastName) {
		this.name = name;
		this.lastName = lastName;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
