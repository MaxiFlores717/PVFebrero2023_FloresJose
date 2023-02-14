package ar.edu.unju.edm.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class UsuarioPregunta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long codUsuarioPregunta;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="dni")
	private Usuario usuario;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="codPregunta")
	private Pregunta pregunta;
	
	private int PuntajeObtenido;

	public Long getCodUsuarioPregunta() {
		return codUsuarioPregunta;
	}

	public void setCodUsuarioPregunta(Long codUsuarioPregunta) {
		this.codUsuarioPregunta = codUsuarioPregunta;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Pregunta getPregunta() {
		return pregunta;
	}

	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}

	public int getPuntajeObtenido() {
		return PuntajeObtenido;
	}

	public void setPuntajeObtenido(int puntajeObtenido) {
		PuntajeObtenido = puntajeObtenido;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public UsuarioPregunta(Long codUsuarioPregunta, Usuario usuario, Pregunta pregunta, int puntajeObtenido) {
		super();
		this.codUsuarioPregunta = codUsuarioPregunta;
		this.usuario = usuario;
		this.pregunta = pregunta;
		PuntajeObtenido = puntajeObtenido;
	}

	public UsuarioPregunta() {
		super();
	}


	
	
	
}
