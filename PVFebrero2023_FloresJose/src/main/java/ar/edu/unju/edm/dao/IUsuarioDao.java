package ar.edu.unju.edm.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.edm.models.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long>{
	/*
	 * dao es una clase que implementa(UsuarioDaoIMP) y provee(IUsuarioDao) una interfaz comun para acceder y trabajar con los datos 
	 * esta interfaz tiene que tener los metodos necesarios para recuperar y almacenar los datos(contrato de implementacion)
	 * con las operaciones basicas: listar, eliminar, obtener x id, guardar.
	 * en este caso la vamos a implementar con el entity manager de jpa
	 */

//	public List<Usuario> findAll();
//	public void save(Usuario usuario);
//	public Usuario buscarDni(Long dni);
//	public void eliminar(Long DNI);

	
	
}
