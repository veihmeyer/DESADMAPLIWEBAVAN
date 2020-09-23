package com.example.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Endereco")
public class ControllerEndereco {

	@GetMapping
	public String teste() {
		return "Fui chamado pelo metódo GET (Endereco)";
	}
}
