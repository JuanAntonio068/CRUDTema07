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
		// Variable para verificar si se ha sido existoso o no
		boolean res = true;

		// Iniciamos la secuencia
		String sql = "INSERT INTO CALIFICACIONES (id_estudiante, id_curso, id_profesor, tipo_evaluacion, nota, fecha_evaluacion) VALUES (?, ?, ?, ?, ?, ?)";

		// Preparamos el estatement
		PreparedStatement ps;

		// Añadimos los datos del objeto a la base de datos
		try {
			ps = conexion.prepareStatement(sql);
			ps.setInt(1, calf.getEstudianteId());
			ps.setInt(2, calf.getCursoId());
			ps.setInt(3, calf.getProfesorId());
			ps.setString(4, calf.getTipoEvaluacion());
			ps.setDouble(5, calf.getNota());
			ps.setString(6, calf.getFechaEvaluacion());

			ps.executeUpdate();
		} catch (SQLException e) {// Ha dado error
			System.out.println("Error al insertar la calificación: " + e.getMessage());

			// Situamos el valor en false
			res = false;
		}
		// Devolvemos res
		return res;
	}

	/**
	 * Método para listar todas las calificaciones por el id del estudiante
	 * 
	 * @param estudianteId El estudiante
	 * @return La lista con todas las calificiones de ese alumno
	 */
	public List<Calificacion> listarPorEstudiante(int estudianteId) {
		// Declaramos la lista
		List<Calificacion> calificaciones = new ArrayList<>();

		// Iniciamos la secuencia
		String sql = "SELECT * FROM Calificaciones WHERE id_estudiante = ?";

		// Preparamos el statement
		try (PreparedStatement ps = conexion.prepareStatement(sql)) {
			// Buscamos por el id del estudiante
			ps.setInt(1, estudianteId);
			ResultSet rs = ps.executeQuery();

			// Con un bucle añadimos a la lista todo objeto que tenga el mismo idestudiante
			while (rs.next()) {
				calificaciones.add(new Calificacion(rs.getInt("id_calificacion"), rs.getInt("id_estudiante"),
						rs.getInt("id_curso"), rs.getInt("id_profesor"), rs.getString("tipo_evaluacion"),
						rs.getDouble("nota"), rs.getDate("fecha_evaluacion").toString()));
			}
		} catch (SQLException e) {// Ha dado un error
			System.err.println("Error al listar calificaciones por estudiante: " + e.getMessage());
		}
		// Devuelve la lista
		return calificaciones;
	}

	/**
	 * Método para listar todas las calificaciones por el id del curso
	 * 
	 * @param cursoId El curso
	 * @return La lista con todas las calificiones de ese alumno
	 */
	public List<Calificacion> listarPorCurso(int cursoId) {
		// Declaramos la lista
		List<Calificacion> calificaciones = new ArrayList<>();

		// Iniciamos la secuencia
		String sql = "SELECT * FROM Calificaciones WHERE id_curso = ?";

		// Preparamos el statement
		try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
			// Buscamos por el id del curso
			stmt.setInt(1, cursoId);
			ResultSet rs = stmt.executeQuery();

			// Con un bucle añadimos a la lista todo objeto que tenga el mismo idcurso
			while (rs.next()) {
				calificaciones.add(new Calificacion(rs.getInt("id_calificacion"), rs.getInt("id_estudiante"),
						rs.getInt("id_curso"), rs.getInt("id_profesor"), rs.getString("tipo_evaluacion"),
						rs.getDouble("nota"), rs.getDate("fecha_evaluacion").toString()));
			}
		} catch (SQLException e) {// Ha dado un error
			System.err.println("Error al listar calificaciones por curso: " + e.getMessage());
		}
		// Devuelve la lista
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
		// Variable para verificar si se ha sido existoso o no
		boolean res = true;

		// Iniciamos la secuencia
		String sql = "UPDATE Calificaciones SET nota = ? WHERE id_calificacion = ?";

		// Preparamos el statement
		try (PreparedStatement ps = conexion.prepareStatement(sql)) {
			// Modificamos la nota donde coincida el id
			ps.setDouble(1, nota);
			ps.setInt(2, id);

			ps.executeUpdate();
		} catch (SQLException e) {// Ha dado error
			System.err.println("Error al modificar calificación: " + e.getMessage());
			// Cambiamos el valor a false
			res = false;
		}
		// Devolvemos res
		return res;
	}

	/**
	 * Elimina una calificación de la base de datos.
	 * 
	 * @param id ID de la calificación a eliminar.
	 * @return true si la operación fue exitosa, false en caso contrario.
	 */
	public boolean delete(int id) {
		// Variable para verificar si se ha sido existoso o no
		boolean res = true;

		// Iniciamos la secuencia
		String sql = "DELETE FROM Calificaciones WHERE id_calificacion = ?";

		// Preparamos el statement
		try (PreparedStatement ps = conexion.prepareStatement(sql)) {
			// Borramos de la base de datos donde coincida con el id
			ps.setInt(1, id);

			ps.executeUpdate();
		} catch (SQLException e) {// Ha dado error
			System.err.println("Error al eliminar calificación: " + e.getMessage());
			// Cambiamos el valor a false
			res = false;
		}
		// Devolvemos res
		return res;
	}
}
