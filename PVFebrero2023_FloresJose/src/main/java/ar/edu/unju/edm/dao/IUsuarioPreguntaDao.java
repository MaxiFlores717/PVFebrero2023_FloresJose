package ar.edu.unju.edm.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.edm.models.UsuarioPregunta;

@Repository
public interface IUsuarioPreguntaDao extends CrudRepository<UsuarioPregunta, Long>{

	
}
