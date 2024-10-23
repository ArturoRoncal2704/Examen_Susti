package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.EstudianteEntity;

@Service
public interface EstudianteService {

	
	List<EstudianteEntity>listarEstudiante();
	EstudianteEntity buscarEstudiantePorId(String id);
	void crearEstudiante(EstudianteEntity estudianteEntity);
	void actualizarEstudiante(String id, EstudianteEntity estudianteEntity);
	void eliminarEstudiante(String id);
}
