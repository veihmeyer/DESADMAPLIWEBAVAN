package com.example.demo.Controller.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Controller.model.Endereco;

public interface EnderecoRepository extends JpaRepository <Endereco, Long> {

}
