package com.rintio.tigry.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class Hello {

	@GetMapping(value = "/")
	public String getMessage() {
		log.info("Page d'acceuil appelée");
		return "index";
	}
}
