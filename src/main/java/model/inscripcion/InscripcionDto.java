package model.inscripcion;

import java.sql.Date;

import giis.demo.util.Util;

public class InscripcionDto {

	public String idCompeticion;
	public String emailAtleta;
	public String nombreAtleta;
	public String nombreCompeticion;
	public String categoria;
	public Date fechaInscripcion;
	public double cuotaInscripcion;
	public String estadoInscripcion;
	public Date fechaCambioEstado;
	public int poisicion;
	public double tiempo;

	public String getIdCompeticion() {
		return idCompeticion;
	}

	public String getEstadoInscripcion() {
		return estadoInscripcion;
	}

	public String getFechaCambioEstado() {
		return Util.dateToIsoString(new java.util.Date(fechaCambioEstado.getTime()));
	}

	public String getEmailAtleta() {
		return emailAtleta;
	}

	public void setEmailAtleta(String emailAtleta) {
		this.emailAtleta = emailAtleta;
	}

	public String getNombreAtleta() {
		return nombreAtleta;
	}

	public void setNombreAtleta(String nombreAtleta) {
		this.nombreAtleta = nombreAtleta;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getFechaInscripcion() {
		return Util.dateToIsoString(new java.util.Date(fechaInscripcion.getTime()));
	}

	public void setFechaInscripcion(String fechaInscripcion) {
		this.fechaInscripcion = new java.sql.Date(Util.isoStringToDate(fechaInscripcion).getTime());
	}

	public double getCuotaInscripcion() {
		return cuotaInscripcion;
	}

	public void setCuotaInscripcion(double cuotaInscripcion) {
		this.cuotaInscripcion = cuotaInscripcion;
	}

	public int getPoisicion() {
		return poisicion;
	}

	public void setPoisicion(int poisicion) {
		this.poisicion = poisicion;
	}

	public double getTiempo() {
		return tiempo;
	}

	public void setTiempo(double tiempo) {
		this.tiempo = tiempo;
	}

	public void setIdCompeticion(String idCompeticion) {
		this.idCompeticion = idCompeticion;
	}

	public void setEstadoInscripcion(String estadoInscripcion) {
		this.estadoInscripcion = estadoInscripcion;
	}

	public void setFechaCambioEstado(String fechaCambioEstado) {
		this.fechaCambioEstado = new java.sql.Date(Util.isoStringToDate(fechaCambioEstado).getTime());
	}

	public String getNombreCompeticion() {
		return nombreCompeticion;
	}

	public void setNombreCompeticion(String nombreCompeticion) {
		this.nombreCompeticion = nombreCompeticion;
	}

}
