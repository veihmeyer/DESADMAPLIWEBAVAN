package com.example.demo.Controller.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Controller.model.User;

public interface UserRepository extends JpaRepository <User, Long> {

}
