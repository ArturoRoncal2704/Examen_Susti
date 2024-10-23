package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "estudiante_curso")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

	public class EstudianteCursoEntity {
		
		@Id
	    @ManyToOne
	    @JoinColumn(name = "tb_estudiante_dni", nullable = false)
	    private EstudianteEntity estudiante;

		@Id
	    @ManyToOne
	    @JoinColumn(name = "curso_curso_id", nullable = false)
	    private CursoEntity curso;
}
