package ar.edu.unju.edm.service;

import java.util.List;

import ar.edu.unju.edm.models.UsuarioPregunta;

public interface IUsuarioPreguntaService {
	
	public List<UsuarioPregunta> findAll();
	public void save(UsuarioPregunta usuarioPregunta);
	public UsuarioPregunta buscarId(Long id);
	public void eliminar(Long id);

}
