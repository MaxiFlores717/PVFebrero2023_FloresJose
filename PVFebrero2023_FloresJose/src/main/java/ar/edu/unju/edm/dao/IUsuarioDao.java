package ar.edu.unju.edm.dao;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.edm.models.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long>{
	
	
}
