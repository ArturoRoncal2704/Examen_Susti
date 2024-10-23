package com.example.demo.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.EstudianteEntity;
import com.example.demo.repository.EstudianteRepository;
import com.example.demo.service.EstudianteService;

@Service
public class EstudianteServiceImpl implements EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Override
    public List<EstudianteEntity> listarEstudiante() {
        return estudianteRepository.findAll();
    }

    @Override
    public EstudianteEntity buscarEstudiantePorId(String id) {
        return estudianteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
    }

    @Override
    public void crearEstudiante(EstudianteEntity estudianteEntity) {
        estudianteRepository.save(estudianteEntity);
    }

    @Override
    public void actualizarEstudiante(String id, EstudianteEntity estudianteEntity) {
        EstudianteEntity estudianteEncontrado = buscarEstudiantePorId(id);
        estudianteEncontrado.setApellidos(estudianteEntity.getApellidos());
        estudianteEncontrado.setCodAlumno(estudianteEntity.getCodAlumno());
        estudianteEncontrado.setDni(estudianteEntity.getDni());
        estudianteEncontrado.setFechaNaci(estudianteEntity.getFechaNaci());
        estudianteEncontrado.setNombres(estudianteEntity.getNombres());
        estudianteEncontrado.setCursos(estudianteEntity.getCursos());

        estudianteRepository.save(estudianteEncontrado); 
    }

    @Override
    public void eliminarEstudiante(String id) {
        EstudianteEntity estudianteEncontrado = buscarEstudiantePorId(id);
        estudianteRepository.delete(estudianteEncontrado);
    }
}
