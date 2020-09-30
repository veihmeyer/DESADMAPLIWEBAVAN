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

import com.example.demo.Controller.model.Cliente;
import com.example.demo.Controller.repository.ClienteRepository;




@RestController
@RequestMapping("/Clientes")
public class ControllerClientes {

	//@GetMapping
	//public String teste() {
		//return "Fui chamado pelo metódo GET (Clientes)";
	//}
	@Autowired
	private ClienteRepository repository;
	
	@PostMapping
	public Cliente salvar(@RequestBody Cliente cliente) {
		return this.repository.save(cliente);
	}
	
	@PutMapping("/{id}")
	public Cliente editar(@PathVariable("id") Long id, @RequestBody Cliente cliente) {
		Cliente clienteDoBancoDeDados = this.repository.findById(id).get();
		BeanUtils.copyProperties(cliente, clienteDoBancoDeDados, "id");
		this.repository.save(clienteDoBancoDeDados);
		return clienteDoBancoDeDados;

	}
	@GetMapping
	public List<Cliente> listar() {
		return this.repository.findAll();
	}
	
	@DeleteMapping("/{id}")
	public String deletar(@PathVariable("id") Long id) {
		this.repository.deleteById(id);
		return ("Usuário (id) " + (id) + ": apagado com sucesso");
	}
	
}
