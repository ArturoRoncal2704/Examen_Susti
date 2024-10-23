package com.example.demo.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "curso")
public class CursoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "curso_id")
	private Integer id;
	
	@Column(name = "cod_curso", length = 4, nullable = false)
	private String codCurso;
	
	 @Column(name = "nombre_curso", length = 45, nullable = false)
	private String nombreCurso;
	
	 @Column(length = 45, nullable = false)
	private String ciclo;
	
	@OneToMany(mappedBy = "curso")
	private List<EstudianteCursoEntity> estudiantes;
	

}
