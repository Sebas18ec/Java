package com.pp.web.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pp.web.entidad.Estudiante;
import com.pp.web.servicio.EstudianteServicio;

@Controller
public class EstudianteControlador {

	@Autowired
	private EstudianteServicio servicio;
	
	@GetMapping({"/estudiantes","/"})
	public String listarEstudiantes(Model modelo) {
		modelo.addAttribute("estudiantes",servicio.listarEstudiantes());
		return "estudiantes";
	}
	
	@GetMapping("/estudiantes/nuevo")
	public String crearEstudianteFormulario(Model modelo) {
		
		Estudiante estudiante = new Estudiante();
		modelo.addAttribute("estudiante",estudiante);
		return "crear_estudiante";
		
	}
}
