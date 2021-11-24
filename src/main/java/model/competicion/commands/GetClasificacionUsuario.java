package model.competicion.commands;

import java.util.List;

import model.atleta.AtletaDto;
import model.competicion.ClasificacionDto;
import model.competicion.CompeticionDto;
import util.database.Database;

public class GetClasificacionUsuario {
	
	private static String GETACLASIFICACIONUSUARIO = "select c.dorsal, c.tiempoSalida, c.tiempoLlegada, a.sexo, a.nombre, i.categoria, c.posicion "
													 + "from Clasificacion c, Inscripcion i, Atleta a"
													 + " where c.emailAtleta = ? and c.idCompeticion = ? and c.emailAtleta = i.emailAtleta and c.idCompeticion = i.idCompeticion and c.emailAtleta = a.email";

	private Database db = Database.getInstance();

	private AtletaDto atleta;
	private CompeticionDto competicion;

	public GetClasificacionUsuario(AtletaDto atleta, CompeticionDto competicion) {
		this.atleta = atleta;
		this.competicion = competicion;
		checkParams();
	}

	private void checkParams() {
		if (atleta == null) {
			throw new IllegalArgumentException("Atleta no válido");
		}
		if (competicion == null) {
			throw new IllegalArgumentException("Competicion no válida");
		}
	}

	public List<ClasificacionDto> execute() {
		return db.executeQueryPojo(ClasificacionDto.class, GETACLASIFICACIONUSUARIO, atleta.email, competicion.id);
	}

}
