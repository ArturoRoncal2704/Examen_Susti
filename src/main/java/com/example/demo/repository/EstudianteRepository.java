package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.EstudianteEntity;

public interface EstudianteRepository extends JpaRepository<EstudianteEntity, String>{

}
