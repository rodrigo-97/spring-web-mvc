package com.bootcamp.spring.springwebmvc.repositories;

import java.util.ArrayList;
import java.util.List;
import com.bootcamp.spring.springwebmvc.models.Jedi;
import org.springframework.stereotype.Repository;

@Repository
public class JediRepository {
	private List<Jedi> jedi;

	public JediRepository() {
		jedi = new ArrayList<Jedi>();
	}

	public List<Jedi> getJedis() {
		return jedi;
	}

	public void add(final Jedi jedi) {
		this.jedi.add(jedi);
	}
}
