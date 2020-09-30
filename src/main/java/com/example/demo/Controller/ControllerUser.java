package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Controller.model.User;
import com.example.demo.Controller.repository.UserRepository;

@RestController
@RequestMapping("/User")
public class ControllerUser {
	@Autowired
	private UserRepository repository;
	
	@PostMapping
	public User salvar(@RequestBody User user) {
		return this.repository.save(user);
	}
	
	@PutMapping("/{id}")
	public User editar(@PathVariable("id") Long id, @RequestBody User user) {
		User clienteDoBancoDeDados = this.repository.findById(id).get();
		BeanUtils.copyProperties(user, clienteDoBancoDeDados, "id");
		this.repository.save(clienteDoBancoDeDados);
		return clienteDoBancoDeDados;

	}
	@GetMapping
	public List<User> listar() {
		return this.repository.findAll();
	}
	
	@DeleteMapping("/{id}")
	public String deletar(@PathVariable("id") Long id) {
		this.repository.deleteById(id);
		return ("Usuário (id) " + (id) + ": apagado com sucesso");
	}
}
