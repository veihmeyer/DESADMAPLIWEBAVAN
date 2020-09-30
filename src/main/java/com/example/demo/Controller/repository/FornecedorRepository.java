package com.example.demo.Controller.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Controller.model.Fornecedor;

public interface FornecedorRepository extends JpaRepository <Fornecedor, Long> {

}
