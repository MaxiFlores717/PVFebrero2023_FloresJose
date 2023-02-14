package ar.edu.unju.edm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unju.edm.dao.IPreguntaDao;
import ar.edu.unju.edm.dao.IUsuarioDao;
import ar.edu.unju.edm.models.Pregunta;
import ar.edu.unju.edm.models.Usuario;

@Service
public class PreguntaServiceIMP implements IPreguntaService {
	
	@Autowired
	private IPreguntaDao preguntaDao;

	@Override
	@Transactional(readOnly = true)
	public List<Pregunta> findAll() {
		// TODO Auto-generated method stub
		return (List<Pregunta>) preguntaDao.findAll();
	}

	@Override
	public void save(Pregunta pregunta) {
		// TODO Auto-generated method stub
		preguntaDao.save(pregunta);
	}

	@Override
	@Transactional(readOnly = true)
	public Pregunta buscarId(Long codigo) {
		// TODO Auto-generated method stub
		return preguntaDao.findById(codigo).orElse(null);
	}

	@Override
	@Transactional
	public void eliminar(Long codigo) {
		// TODO Auto-generated method stub
		preguntaDao.deleteById(codigo);
	}

	@Override
	public List<Pregunta> findByNivel(int nivel) {
		// TODO Auto-generated method stub
		List<Pregunta> preguntas =new ArrayList<>();
		List<Pregunta> preguntas2 =new ArrayList<>();
		preguntas=(List<Pregunta>) preguntaDao.findAll();
		for(int i=0; i<preguntas.size(); i++) {
			if(preguntas.get(i).getNivel()==nivel) {
				preguntas2.add(preguntas.get(i));
			}
		}
		return preguntas2;
	}


}
