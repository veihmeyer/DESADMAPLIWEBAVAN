package com.example.demo.Controller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Controller.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository <Cliente, Long> {

}
