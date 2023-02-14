package ar.edu.unju.edm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unju.edm.dao.IUsuarioPreguntaDao;
import ar.edu.unju.edm.models.Usuario;
import ar.edu.unju.edm.models.UsuarioPregunta;

@Service
public class UsuarioPreguntaServiceIMP implements IUsuarioPreguntaService {
	
	@Autowired
	private IUsuarioPreguntaDao usuarioPreguntaDao;

	@Override
	@Transactional(readOnly = true)
	public List<UsuarioPregunta> findAll() {
		// TODO Auto-generated method stub
		return (List<UsuarioPregunta>) usuarioPreguntaDao.findAll();
	}

	@Override
	public void save(UsuarioPregunta usuarioPregunta) {
		// TODO Auto-generated method stub
		usuarioPreguntaDao.save(usuarioPregunta);
	}

	@Override
	@Transactional(readOnly = true)
	public UsuarioPregunta buscarId(Long id) {
		// TODO Auto-generated method stub
		return usuarioPreguntaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		usuarioPreguntaDao.deleteById(id);
	}


}
