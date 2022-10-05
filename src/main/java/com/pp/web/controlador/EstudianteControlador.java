package com.pp.web.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
	
	
	@PostMapping("/estudiantes")
	public String guardarEstudiante(@ModelAttribute("estudiante")Estudiante estudiante) {
		servicio.guardarEstudiante(estudiante);
		return "redirect:/estudiantes";
	}
	
	
	@GetMapping("/estudiantes/editar/{id}")
	public String editarEstudianteFormulario(@PathVariable Long id, Model modelo)
	{
		modelo.addAttribute("estudiante",servicio.obtenerEstudiantePorId(id));
		return "editar_estudiante";
	}
	
	@PostMapping("/estudiantes/{id}")
	public String actualizarEstudiante(@PathVariable Long id, @ModelAttribute("estudiante")Estudiante estudiante, Model modelo ) {
		
		Estudiante estudianteExistente = servicio.obtenerEstudiantePorId(id);
		
		estudianteExistente.setId(id);
		estudianteExistente.setNombre(estudiante.getNombre());
		estudianteExistente.setApellido(estudiante.getApellido());
		estudianteExistente.setEmail(estudiante.getEmail());
		
		servicio.actualizarEstudiante(estudianteExistente);
		
		return "redirect:/estudiantes";
		
	}
	
	@GetMapping("/estudiantes/{id}")
	public String eliminarEstudiante(@PathVariable Long id) {
		servicio.eliminarEstudiante(id);
		return "redirect:/estudiantes";
	}
	
	
}
