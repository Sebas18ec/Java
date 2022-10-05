package com.pp.web.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pp.web.entidad.Estudiante;
import com.pp.web.repositorio.EstudianteRepositorio;

@Service
public class EstudianteServicioImpl implements EstudianteServicio{

	
	@Autowired
	private EstudianteRepositorio repositorio;
	
	@Override
	public List<Estudiante> listarEstudiantes() {
		
		return repositorio.findAll();
	}

	@Override
	public Estudiante guardarEstudiante() {
		// TODO Auto-generated method stub
		return null;
	}

}
