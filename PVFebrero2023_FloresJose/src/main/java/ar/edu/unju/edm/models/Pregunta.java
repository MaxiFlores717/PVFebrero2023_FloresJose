package ar.edu.unju.edm.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Pregunta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "cod_pregunta")
	private Long codPregunta;

	@NotEmpty
	private String enunciado;
	
	@NotNull
	private int nivel;
	
	@NotEmpty
	private String opcion01;
	
	@NotEmpty
	private String opcion02;
	
	@NotEmpty
	private String opcion03;
	
	@NotEmpty
	private String opcion04;
	
	@NotEmpty
	@Column(name = "opcion")
	private String opcionCorrecta;
	
	private Long puntaje;

	public Long getCodPregunta() {
		return codPregunta;
	}

	public void setCodPregunta(Long codPregunta) {
		this.codPregunta = codPregunta;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public String getOpcion01() {
		return opcion01;
	}

	public void setOpcion01(String opcion01) {
		this.opcion01 = opcion01;
	}

	public String getOpcion02() {
		return opcion02;
	}

	public void setOpcion02(String opcion02) {
		this.opcion02 = opcion02;
	}

	public String getOpcion03() {
		return opcion03;
	}

	public void setOpcion03(String opcion03) {
		this.opcion03 = opcion03;
	}

	public String getOpcion04() {
		return opcion04;
	}

	public void setOpcion04(String opcion04) {
		this.opcion04 = opcion04;
	}

	public String getOpcionCorrecta() {
		return opcionCorrecta;
	}

	public void setOpcionCorrecta(String opcionCorrecta) {
		this.opcionCorrecta = opcionCorrecta;
	}

	public Long getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(Long puntaje) {
		this.puntaje = puntaje;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Pregunta(Long codPregunta, @NotEmpty String enunciado, @NotNull int nivel, @NotEmpty String opcion01,
			@NotEmpty String opcion02, @NotEmpty String opcion03, @NotEmpty String opcion04, String opcionCorrecta,
			Long puntaje) {
		super();
		this.codPregunta = codPregunta;
		this.enunciado = enunciado;
		this.nivel = nivel;
		this.opcion01 = opcion01;
		this.opcion02 = opcion02;
		this.opcion03 = opcion03;
		this.opcion04 = opcion04;
		this.opcionCorrecta = opcionCorrecta;
		this.puntaje = puntaje;
	}

	public Pregunta() {
		super();
	}

	
}
