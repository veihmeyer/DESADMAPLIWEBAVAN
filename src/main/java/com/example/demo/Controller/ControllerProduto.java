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

import com.example.demo.Controller.model.Produto;
import com.example.demo.Controller.repository.ProdutoRepository;

@RestController
@RequestMapping("/Produtos")
public class ControllerProduto {

	//@GetMapping
	//public String teste() {
		//return "Fui chamado pelo metódo GET (Produtos)";
	//}
	@Autowired
	private ProdutoRepository repository;
	
	@PostMapping
	public Produto salvar(@RequestBody Produto produto) {
		return this.repository.save(produto);
	}
	
	@PutMapping("/{id}")
	public Produto editar(@PathVariable("id") Long id, @RequestBody Produto produto) {
		Produto clienteDoBancoDeDados = this.repository.findById(id).get();
		BeanUtils.copyProperties(produto, clienteDoBancoDeDados, "id");
		this.repository.save(clienteDoBancoDeDados);
		return clienteDoBancoDeDados;

	}
	@GetMapping
	public List<Produto> listar() {
		return this.repository.findAll();
	}
	
	@DeleteMapping("/{id}")
	public String deletar(@PathVariable("id") Long id) {
		this.repository.deleteById(id);
		return ("Usuário (id) " + (id) + ": apagado com sucesso");
	}
}
