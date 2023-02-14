package ar.edu.unju.edm.service;

import java.util.List;

import ar.edu.unju.edm.models.Pregunta;

public interface IPreguntaService {
	
	public List<Pregunta> findAll();
	public void save(Pregunta pregunta);
	public Pregunta buscarId(Long codigo);
	public void eliminar(Long codigo);
	public List<Pregunta> findByNivel(int nivel);
 
}
