package ar.edu.unju.edm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unju.edm.dao.IUsuarioDao;
import ar.edu.unju.edm.models.Usuario;

@Service
/*
 * una clase servis.
 * 
 * Está basado en el patrón de diseño de fachada, un único punto de acceso hacia
 * distintos DAOS o repository. 
 * Dentro de una clase de servicio Podríamos tener como atributo y
 * podríamos operar con diferentes clases DAO, Además evitamos tener que acceder de forma directa a los daos 
 * dentro de los controladores.
 * 
 * Entonces la idea en la clase servis por cada método en la clase DAO vamos a tener métodos en el cliente servis, es decir tendremos
 * los mismos metodos en ambas clases.
 */
public class UsuarioServiceIMP implements IUsuarioService {
	
	@Autowired
	private IUsuarioDao usuarioDao;
	
	/*
	 * entonces la implementación es bastante simple como es una fachada accedemos a los métodos

del Dao por ejemplo acá sería el findAll y demas.

entonces es una fachada, aca tenemos un solo dao(private IUsuarioDao usuarioDao;) pero podriamos tener diferentes dao y 
dentro del servis accedemos a los distintos daos como un único punto de acceso.

Otra característica de la clase servis es que podemos manejar la transacción sin tener que implementar

las anotaciones transaccional en el dao.

entonces cambie todos los transaccional

incluso dentro de un método en la clase servis podremos interactuar con diferentes lado y todos dentro

de la misma transacción.

Esa sería la idea

en vez de inyectar de forma directa el cliente dad en el controller inyectamos el cliente servis asiq lo voy a cambiar.

y los métodos son exactamente lo mismo ya que es una fachada implementa el patrón de diseño fachada entonces no hay q cambiar casi nada 

en el controller


la notación @service Básicamente es un @component, no probé nada más, pero la idea es que indique de qué se trata de una capa de 

servicio, una fachada, un patrón de diseño, eso es lo que representa esta anotación.

La capa de servicio una muy buena práctica recomendada por sobre implementar los DAOS de forma directa en el controlador.

	 */

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return (List<Usuario>) usuarioDao.findAll();
		/*
		 * agregamos en IUsuarioDao un extends de una interfaz de spring CrudRepository que tiene todos estos metodos ya listos
		 * y que no tengo q hacer nada asiq cambie los personalizados x los de la interfaz asiq tenemos esas 2 formas
		 */
	}

	@Override
	@Transactional
	public void save(Usuario usuario) {
		// TODO Auto-generated method stub
		usuarioDao.save(usuario);
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario buscarDni(Long dni) {
		// TODO Auto-generated method stub
		
		return usuarioDao.findById(dni).orElse(null);
	}

	@Override
	@Transactional
	public void eliminar(Long DNI) {
		// TODO Auto-generated method stub
		usuarioDao.deleteById(DNI);
	}

}
