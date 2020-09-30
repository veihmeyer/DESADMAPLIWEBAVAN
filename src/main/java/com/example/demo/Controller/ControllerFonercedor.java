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

import com.example.demo.Controller.model.Fornecedor;
import com.example.demo.Controller.repository.FornecedorRepository;

@RestController
@RequestMapping("/Fornecedores")
public class ControllerFonercedor {

	//@GetMapping
	//public String teste() {
		//return "Fui chamado pelo metódo GET (Fornecedores)";
	//}
	@Autowired
	private FornecedorRepository repository;
	
	@PostMapping
	public Fornecedor salvar(@RequestBody Fornecedor fornecedor) {
		return this.repository.save(fornecedor);
	}
	
	@PutMapping("/{id}")
	public Fornecedor editar(@PathVariable("id") Long id, @RequestBody Fornecedor fornecedor) {
		Fornecedor clienteDoBancoDeDados = this.repository.findById(id).get();
		BeanUtils.copyProperties(fornecedor, clienteDoBancoDeDados, "id");
		this.repository.save(clienteDoBancoDeDados);
		return clienteDoBancoDeDados;

	}
	@GetMapping
	public List<Fornecedor> listar() {
		return this.repository.findAll();
	}
	
	@DeleteMapping("/{id}")
	public String deletar(@PathVariable("id") Long id) {
		this.repository.deleteById(id);
		return ("Usuário (id) " + (id) + ": apagado com sucesso");
	}
}
