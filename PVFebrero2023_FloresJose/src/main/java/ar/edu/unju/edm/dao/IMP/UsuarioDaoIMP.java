//package ar.edu.unju.edm.dao.IMP;
//
//import java.util.List;
//
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import ar.edu.unju.edm.dao.IUsuarioDao;
//import ar.edu.unju.edm.models.Usuario;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.PersistenceContext;
//
//@Repository
///*
// * Es una anotación de Spring para marcar la clase como un componente de
// * persistencia de acceso a datos.
// * 
// * Internamente el repository es un estereotipo de la clase @component y por lo
// * tanto marca la clase como
// * 
// * componente de spring y lo registra dentro del contenedor de Spring, lo marca
// * como un tipo o estereotipo
// * 
// * repository, un repository que aparte de ser un beans de acceso a dato, se
// * encarga de traducir correctamente
// * 
// * y con detalle las excepciones que pueden ocurrir.
// */
//public class UsuarioDaoIMP implements IUsuarioDao {
//
//	/*
//	 * Ayer utilizamos la anotación @persistesContext que contiene la unidad de
//	 * persistencia.
//	 * 
//	 * de forma automática va a inyectar el EntityManager según la configuración de
//	 * la Unidad de persistencia
//	 * 
//	 * que contiene el data sources que contiene el proveedor JPA, nosotros
//	 * configuramos sql
//	 */
//	@PersistenceContext
//	/*
//	 * el entitymanager se encarga de manejar las clases de entidades, el ciclo de
//	 * vida, las persiste dentro del contexto, las actualiza las elimina, puede
//	 * realizar consultas, es decir todas las operaciones de bd pero a nivel de
//	 * objeto a travez de las clases entity es decir son consultas que van a la
//	 * clase entity, no a la tabla.
//	 */
//	private EntityManager em;
//
//	@SuppressWarnings("unchecked")
////	@Transactional(readOnly = true)
//	/*
//	 * con esta anotación marcamos el método como transaccional y le colocamos
//	 * solamente de lectura ya que es una consulta
//	 */
//	@Override
//	public List<Usuario> findAll() {
//		// TODO Auto-generated method stub
//
//		return em.createQuery("from Usuario").getResultList();
//	}
//
//	@Override
//	public void save(Usuario usuario) {
//		// TODO Auto-generated method stub
//		if ((usuario.getDNI() != null) && (usuario.getDNI() > 0)) {
//			em.merge(usuario); //lo que hace es actualizar los datos existentes pero no funciona en nuestro caso, buscar otra forma
////			igualmente si no sabes como mejor usa la forma del profe del curso pero usa id como clave primaria, no dni
//		} else {
//			em.persist(usuario);//toma el objeto cliente y lo guarda dentro del contexto de persistencia dentro del contexto JPA
//			//y con el metodo flush() va a sincronizar con la bd y va a realizar el insert en la tabla todo esto lo hace por debajo
////			ya que esta en el contexto de persistencia, el objeto es manejado por JPA
//		}
//
//	}
//
//	@Override
//	public Usuario buscarDni(Long dni) {
//		// TODO Auto-generated method stub
//		return em.find(Usuario.class, dni);//find es para buscar, primero le damos el nombre de la clase y luego le damos el dni
//	}
//
//	@Override
//	public void eliminar(Long dni) {
//		// TODO Auto-generated method stub
//		Usuario usuario = buscarDni(dni);
//		em.remove(usuario);
//	}
//
//}
