package com.pp.web.servicio;

import java.util.List;

import com.pp.web.entidad.Estudiante;

public interface EstudianteServicio {
	
	public List<Estudiante> listarEstudiantes();
	
	public Estudiante guardarEstudiante();

}
