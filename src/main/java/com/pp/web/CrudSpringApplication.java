package com.pp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pp.web.entidad.Estudiante;
import com.pp.web.repositorio.EstudianteRepositorio;

@SpringBootApplication
public class CrudSpringApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
	}

	
	@Autowired
	private EstudianteRepositorio repositorio;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		/*Estudiante e1 = new Estudiante("Carlos","Ochoa","hola@mail.com");
		repositorio.save(e1);
		

		Estudiante e2 = new Estudiante("Miguel","Ramirez","hola2@mail.com");
		repositorio.save(e2);
		*/
	}

}
