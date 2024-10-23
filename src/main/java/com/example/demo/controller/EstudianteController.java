package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.EstudianteEntity;
import com.example.demo.service.EstudianteService;

@Controller
public class EstudianteController {

	@Autowired
	private EstudianteService estudianteService;
	
	@GetMapping("/")
	public String listarEstudiante(Model model) {
		List<EstudianteEntity> listarEstudiante = estudianteService.listarEstudiante();
		model.addAttribute("listaest", listarEstudiante);
		return "lista_estudiante";
	}
	@GetMapping("/registrar_estudiante")
	public String mostrarRegistrarEstudiante(Model model) {
		model.addAttribute("estudiante", new EstudianteEntity());
		return "registrar_estudiante";
	}
	@PostMapping("registrar_estudiante")
	public String registrarEstudiante(@ModelAttribute("estudiante")EstudianteEntity estudianteEntity,
			Model model) {
		estudianteService.crearEstudiante(estudianteEntity);
		return "redirect:/";
	}
	@GetMapping("/detalle_estudiante/{id}")
	public String verDetalle(Model model, @PathVariable("id") String id) {
	    EstudianteEntity estudiante = estudianteService.buscarEstudiantePorId(id);
	    
	    if (estudiante == null) {
	        model.addAttribute("error", "Estudiante no encontrado");
	        return "lista_estudiante"; 
	    }

	    model.addAttribute("estudiante", estudiante);
	    return "detalle_estudiante";
	}

	
	@GetMapping("/delete/{id}")
	public String deleteEstudiante(Model model, @PathVariable("id") String id) {
		estudianteService.eliminarEstudiante(id);
		return "redirect:/";
	}
	
	@GetMapping("/editar_estudiante/{id}")
	public String mostrarActualizar(@PathVariable("id") String id, Model model) {
	    EstudianteEntity estudiante = estudianteService.buscarEstudiantePorId(id);
	    if (estudiante == null) {
	        model.addAttribute("error", "Estudiante no encontrado");
	        return "lista_estudiante"; 
	    }
	    model.addAttribute("estudiante", estudiante);
	    return "editar_estudiante";
	}

	
	@PostMapping("/editar_estudiante/{id}")
	public String actualizarEstudiante(@PathVariable("id")String id, 
			@ModelAttribute("estudiante") EstudianteEntity estudiante, Model model) {
		estudianteService.actualizarEstudiante(id, estudiante);
		return "redirect:/";
	}
	
	@GetMapping("/buscar_estudiante")
	public String buscarEstudiante(@RequestParam("id") String id, Model model) {
	    EstudianteEntity estudiante = estudianteService.buscarEstudiantePorId(id);
	    
	    if (estudiante != null) {
	        model.addAttribute("listaest", List.of(estudiante)); 
	    } else {
	        model.addAttribute("error", "ID no encontrado: " + id); 
	        model.addAttribute("listaest", estudianteService.listarEstudiante()); 
	    }
	    
	    return "lista_estudiante"; 
	}


	
}
