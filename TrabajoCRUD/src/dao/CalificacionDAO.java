package dao;

import static utils.Constantes.CONTRASEÑA;
import static utils.Constantes.URL;
import static utils.Constantes.USUARIO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Calificacion;

/**
 * Clase para manejar la modificación de la base de datos
 */
public class CalificacionDAO {

	// La conexion con la base de datos
	private Connection conexion;

	/**
	 * Construcor de la clase CalificacionDAO
	 */
	public CalificacionDAO() {
		try {
			conexion = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
		} catch (SQLException e) {
			System.out.println("Error al crear la conexión con la base de datos: " + e.getMessage());
		}
	}

	/**
	 * Método para devolver la conexión
	 * 
	 * @return La conexión con la base de datos
	 */
	public Connection getConexion() {
		return conexion;
	}

	/**
	 * Método para añadir una calificación
	 * 
	 * @param calf La nueva calificación
	 * @return Devuelve true si se ha podido añadir y false si no
	 */
	public boolean create(Calificacion calf) {
		boolean res = false;
		String sql = "INSERT INTO CALIFICACIONES (id_estudiante, id_curso, id_profesor, tipo_evaluacion, nota, fecha_evaluacion) VALUES (?, ?, ?, ?, ?, ?";

		PreparedStatement ps;

		try {
			ps = conexion.prepareStatement(sql);
			ps.setInt(1, calf.getEstudianteId());
			ps.setInt(2, calf.getCursoId());
			ps.setInt(3, calf.getProfesorId());
			ps.setString(4, calf.getTipoEvaluacion());
			ps.setDouble(5, calf.getNota());
			ps.setDate(6, Date.valueOf(calf.getFechaEvaluacion()));

			ps.executeUpdate();
			res = true;
		} catch (SQLException e) {
			System.out.println("Error al insertar la calificación: " + e.getMessage());
		}
		return res;
	}

	/**
	 * Método para listar todas las calificaciones por el id del estudiante
	 * 
	 * @param estudianteId El estudiante
	 * @return La lista con todas las calificiones de ese alumno
	 */
	public List<Calificacion> listarPorEstudiante(int estudianteId) {
		List<Calificacion> calificaciones = new ArrayList<>();
		String sql = "SELECT * FROM Calificaciones WHERE id_estudiante = ?";

		try (PreparedStatement ps = conexion.prepareStatement(sql)) {
			ps.setInt(1, estudianteId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				calificaciones.add(new Calificacion(rs.getInt("id_calificacion"), rs.getInt("id_estudiante"),
						rs.getInt("id_curso"), rs.getInt("id_profesor"), rs.getString("tipo_evaluacion"),
						rs.getDouble("nota"), rs.getDate("fecha_evaluacion").toString()));
			}
		} catch (SQLException e) {
			System.err.println("Error al listar calificaciones por estudiante: " + e.getMessage());
		}
		return calificaciones;
	}

	/**
	 * Método para listar todas las calificaciones por el id del curso
	 * 
	 * @param cursoId El curso
	 * @return La lista con todas las calificiones de ese alumno
	 */
	public List<Calificacion> listarPorCurso(int cursoId) {
		List<Calificacion> calificaciones = new ArrayList<>();
		String sql = "SELECT * FROM Calificaciones WHERE id_curso = ?";

		try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
			stmt.setInt(1, cursoId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				calificaciones.add(new Calificacion(rs.getInt("id_calificacion"), rs.getInt("id_estudiante"),
						rs.getInt("id_curso"), rs.getInt("id_profesor"), rs.getString("tipo_evaluacion"),
						rs.getDouble("nota"), rs.getDate("fecha_evaluacion").toString()));
			}
		} catch (SQLException e) {
			System.err.println("Error al listar calificaciones por curso: " + e.getMessage());
		}
		return calificaciones;
	}

	/**
	 * Modifica la nota de una calificación existente.
	 * 
	 * @param id   ID de la calificación.
	 * @param Nota Nueva nota a asignar.
	 * @return true Si la operación fue exitosa, false en caso contrario.
	 */
	public boolean update(int id, double nota) {
		boolean res = false;

		String sql = "UPDATE Calificaciones SET nota = ? WHERE id_calificacion = ?";

		try (PreparedStatement ps = conexion.prepareStatement(sql)) {
			ps.setDouble(1, nota);
			ps.setInt(2, id);
			res = true;
		} catch (SQLException e) {
			System.err.println("Error al modificar calificación: " + e.getMessage());
		}
		return res;
	}

	/**
	 * Elimina una calificación de la base de datos.
	 * 
	 * @param id ID de la calificación a eliminar.
	 * @return true si la operación fue exitosa, false en caso contrario.
	 */
	public boolean delete(int id) {
		boolean res = false;
		String sql = "DELETE FROM Calificaciones WHERE id_calificacion = ?";
		try (PreparedStatement ps = conexion.prepareStatement(sql)) {
			ps.setInt(1, id);
			res = true;
		} catch (SQLException e) {
			System.err.println("Error al eliminar calificación: " + e.getMessage());
		}
		return res;
	}
}
