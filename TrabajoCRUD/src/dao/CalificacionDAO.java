package dao;

import static utils.Constantes.CONTRASEÑA;
import static utils.Constantes.URL;
import static utils.Constantes.USUARIO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entidades.Calificacion;

/**
 * Clase para manejar la modificación de la base de datos
 */
public class CalificacionDAO {

	// La conexion con la base de datos
	private Connection conexion;

	// Constructor de la clase calificacionDAO
	public CalificacionDAO() {
		try {
			conexion = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
		} catch (SQLException e) {
			System.out.println("Error al crear la conexión con la base de datos: " + e.getMessage());
		}
	}

	public void create(Calificacion calf) {
		String sql = "INSERT INTO CALIFICACIONES (id_estudiante, id_curso, id_profesor, tipo_evaluacion, nota, fecha_evaluacion) VALUES (?, ?, ?, ?, ?, ?";

		PreparedStatement ps;

		try {
			ps = conexion.prepareStatement(sql);
			ps.setInt(1, calf.getEstudianteId());
			ps.setInt(2, calf.getCursoId());
			ps.setInt(3, calf.getProfesorId());
			ps.setString(4, calf.getTipoEvaluacion());
			ps.setDouble(5, calf.getNota());
			ps.setString(7, calf.getFechaEvaluacion());

			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al insertar la calificación: " + e.getMessage());
		}
	}
}
