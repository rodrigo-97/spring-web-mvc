package com.bootcamp.spring.springwebmvc.rest;

import java.util.List;

import javax.validation.Valid;

import com.bootcamp.spring.springwebmvc.models.Jedi;
import com.bootcamp.spring.springwebmvc.repositories.JediRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class JediResource {
	@Autowired
	private JediRepository jediRepository;

	@GetMapping("/api/jedi")
	public List<Jedi> getAllJedi() {
		return jediRepository.getJedis();
	}

	@PostMapping("/api/jedi")
	public Jedi addJedi(@Valid @RequestBody Jedi jedi) {
		final Jedi newJedi = jedi;
		jediRepository.add(newJedi);
		return newJedi;
	}
}
