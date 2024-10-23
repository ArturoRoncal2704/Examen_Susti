package com.example.demo.model;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tb_estudiante")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EstudianteEntity {
	
		@Id
		@Column(length = 8,nullable = false)
		private String dni;
		
		@Column(name="cod_alumno",length = 6,nullable = false)
		private String codAlumno;
		
		@Column(length = 45, nullable = false)
		private String nombres;	

		@Column(length = 45, nullable = false)
		private String apellidos;
		
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		@Column(name="fecha_nacimiento")
		private Date fechaNaci;
		
		@OneToMany(mappedBy = "estudiante")
	    private List<EstudianteCursoEntity> cursos;
		
}
