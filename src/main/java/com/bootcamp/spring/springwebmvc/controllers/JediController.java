package com.bootcamp.spring.springwebmvc.controllers;

import javax.validation.Valid;

import com.bootcamp.spring.springwebmvc.models.Jedi;
import com.bootcamp.spring.springwebmvc.repositories.JediRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class JediController {

	@Autowired
	private JediRepository jediRepository;

	@GetMapping("/jedi")
	public ModelAndView jedi() {
		final ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("allJedi", jediRepository.getJedis());

		return modelAndView;
	}

	@PostMapping("/jedi")
	public String createJedi(@Valid @ModelAttribute Jedi jedi, BindingResult result,
			RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return "newJedi.html";
		}

		jediRepository.add(jedi);
		redirectAttributes.addFlashAttribute("message", "Jedi cadastrado com sucesso");
		return "redirect:jedi";
	}

	@GetMapping("/jedi/new")
	public ModelAndView newJedi() {
		final ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("newJedi");
		modelAndView.addObject("jedi", new Jedi());

		return modelAndView;
	}
}
