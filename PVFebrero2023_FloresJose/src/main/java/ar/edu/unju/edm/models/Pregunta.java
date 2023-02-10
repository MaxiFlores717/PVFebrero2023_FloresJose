package ar.edu.unju.edm.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pregunta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "cod_pregunta")
	private Long codPregunta;
	private String enunciado;
	private int nivel;
	private int opcion01;
	private int opcion02;
	private int opcion03;
	private int opcion04;
	@Column(name = "opcion")
	private int opcionCorrecta;
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
	public int getOpcion01() {
		return opcion01;
	}
	public void setOpcion01(int opcion01) {
		this.opcion01 = opcion01;
	}
	public int getOpcion02() {
		return opcion02;
	}
	public void setOpcion02(int opcion02) {
		this.opcion02 = opcion02;
	}
	public int getOpcion03() {
		return opcion03;
	}
	public void setOpcion03(int opcion03) {
		this.opcion03 = opcion03;
	}
	public int getOpcion04() {
		return opcion04;
	}
	public void setOpcion04(int opcion04) {
		this.opcion04 = opcion04;
	}
	public int getOpcionCorrecta() {
		return opcionCorrecta;
	}
	public void setOpcionCorrecta(int opcionCorrecta) {
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
	
	

}
