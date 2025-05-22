package interfaz;

import java.util.List;
import java.util.Scanner;

import dao.CalificacionDAO;
import entidades.Calificacion;

public class Main {

	// Declaramaos el escaner
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		// Declaramos el objeto
		Calificacion calf;

		// Declaramos el DAO
		CalificacionDAO calfDAO = new CalificacionDAO();

		// Lista donde añadir calificaciones
		List<Calificacion> calificaciones;

		// Variable para guardar la opción del usuario
		int opcion;

		// Variable para guardar el id de una calificacion
		int id;

		// Variable para guardar el id de un estudiante
		int estudianteId;

		// Variable para guardar el id de un curso
		int cursoId;

		// Variable para guardar la nota
		double nota;

		// Valida si la conexion ha sido correcta
		if (calfDAO.getConexion() != null) {
			// Bucle que se repite hasta que el usuario decide salir
			do {
				// Llamamos a la función para imprimir el menú
				menu();
				// Leeemos la opción que ha elegido el usuario
				opcion = sc.nextInt();
				// Limpiamos el escaner
				sc.nextLine();

				// Switch para marcar las diferentes opciones
				switch (opcion) {
				// El usuario ha elegido agregar una calificacion
				case 1 -> {
					// Llamamos a la funcion para pedir los datos y crear el objeto
					calf = leerDatosCalificacion();

					// Verificamos
					if (calfDAO.create(calf)) {// Se ha añadido correctamente
						System.out.println("Calificación añadida exitosamente.");
					} else {// No se ha podido añadir
						System.out.println("Error al añadir la calificación.");
					}
				}
				// El usuario ha elegido listar todas las calificaciones de un estudiante
				case 2 -> {

					// Llamamos al método y lo guardamos
					estudianteId = pedirEstudianteId();

					// Llamamos al método y lo guardamos
					calificaciones = calfDAO.listarPorEstudiante(estudianteId);

					// Comprobamos de que la lista no esté vacía
					if (calificaciones.isEmpty()) {// La lista está vacía
						System.out.println("No se encontraron calificaciones para este estudiante.");
					} else {
						// Imprimimos el resultado
						System.out.println("\n--- Calificaciones del Estudiante ---");
						for (Calificacion c : calificaciones) {
							System.out.println(c);
						}
					}
				}
				// El usuario ha elegido listar todas las calificaciones de un curso
				case 3 -> {
					// Llamamos al método y lo guardamos
					cursoId = pedirCursoId();

					// Llamamos al método y lo guardamos
					calificaciones = calfDAO.listarPorCurso(cursoId);

					// Comprobamos de que la lista no esté vacía
					if (calificaciones.isEmpty()) {// La lista está vacía
						System.out.println("No se encontraron calificaciones para este curso.");
					} else {
						// Imprimimos el resultado
						System.out.println("\n--- Calificaciones del Curso ---");
						for (Calificacion c : calificaciones) {
							System.out.println(c);
						}
					}
				}
				// El usuario ha elegido modificar una calificación
				case 4 -> {
					// Llamamos al método y lo guardamos
					id = pedirId();

					// Llamamos al método y la guardamos
					nota = pedirNota();

					// Verificamos
					if (calfDAO.update(id, nota)) {// La nota se ha podido modificar
						System.out.println("Calificación modificada exitosamente.");
					} else {// No se ha podido modificar
						System.out.println("Error al modificar la calificación.");
					}
				}
				// El usuario ha elegido eliminar una calificación
				case 5 -> {
					// Llamamos al método y lo guardamos
					id = pedirId();

					// Verificamos
					if (calfDAO.delete(id)) {// Se ha podido eliminar
						System.out.println("Calificación eliminada exitosamente.");
					} else {// No se ha podido eliminar
						System.out.println("Error al eliminar la calificación. Verifique el ID.");
					}
				}
				// El usuario ha elegido salir del bucle
				case 0 -> {
					System.out.println("Saliendo...");
				}
				// El usuario no ha elegido una opción incorrecta
				default -> {
					System.out.println("Opción incorrecta \nElige una opción válida");
				}
				}
			} while (opcion != 0);

			// Cerramos el escaner
			sc.close();
		}
	}

	// Método para mostar el menú
	public static void menu() {
		System.out.println("1. Crear calificación");
		System.out.println("2. Listar todas las calificaciones de un estudiante");
		System.out.println("3. Listar todas las calificaciones de un curso");
		System.out.println("4. Modificar una calificación");
		System.out.println("5. Eliminar calificación");
		System.out.println("0. Salir");
	}

	// Método para leer los datos
	public static Calificacion leerDatosCalificacion() {
		// Declaramos el objeto
		Calificacion c1 = null;

		// Variable para guardar el id del estudiante
		int idEstudiante;

		// Variable para guardar el id del curso
		int idCurso;

		// Variable para guardar el id del profesor
		int idProfesor;

		// Variable para guardar el tipo de evaluación
		String tipoEvaluacion;

		// Variable para guardar la nota
		double nota;

		// Variable para guardar la fecha de evaluación
		String fechaEvaluacion;

		// Ejecutamos la función para pedir el id del estudiante y lo guardamos
		idEstudiante = pedirEstudianteId();

		// Ejecutamos la función para pedir el id del curso y lo guardamos
		idCurso = pedirCursoId();

		// Ejecutamos la función para pedir el id del profesor y lo guardamos
		idProfesor = pedirProfesorId();

		// Preguntamos por el tipo de evaluación y lo guardamos
		System.out.println("Introduce el tipo de evaluación");
		tipoEvaluacion = sc.nextLine();

		// Ejecutamos la función para pedir la nota y la guardamos
		nota = pedirNota();

		// Preguntamos por la fecha de evaluación y lo guardamos
		System.out.println("Introduce la fecha de evaluación");
		fechaEvaluacion = sc.nextLine();

		// Creamos el objeto con todos los datos
		c1 = new Calificacion(idEstudiante, idCurso, idProfesor, tipoEvaluacion, nota, fechaEvaluacion);

		// Devolvemos el objeto
		return c1;
	}

	// Método para pedir el id de la calificación
	public static int pedirId() {
		// Variable para guardar el id de la calificación
		int id;

		// Preguntamos el id de la calificación y lo guardamos
		System.out.println("Introduce el id de la calificación");
		id = sc.nextInt();

		// Limpiamos el escaner
		sc.nextLine();

		// Devolvemos el id de la calificación
		return id;
	}

	// Método para pedir el id del estudiante
	public static int pedirEstudianteId() {
		// Variable para guardar la id del estudiante
		int idEstudiante;

		// Preguntamos por el id del estudiante y lo guardamos
		System.out.println("Introduce el id del estudiante");
		idEstudiante = sc.nextInt();
		// Limpiamos el escaner
		sc.nextLine();

		// Devolvemos el id del estudiante
		return idEstudiante;
	}

	// Método para pedir el id del curso
	public static int pedirCursoId() {
		// Variable para guardar la id del curso
		int idCurso;

		// Preguntamos por el id del curso y lo guardamos
		System.out.println("Introduce el id del curso");
		idCurso = sc.nextInt();
		// Limpiamos el escaner
		sc.nextLine();

		// Devolvemos el id del curso
		return idCurso;
	}

	// Método para pedir el id del profesor
	public static int pedirProfesorId() {
		// Variable para guardar el id del profesor
		int idProfesor;

		// Preguntamos por el id del profesor y lo guardamos
		System.out.println("Introduce el id del profesor");
		idProfesor = sc.nextInt();
		// Limpiamos el escaner
		sc.nextLine();

		// Devolvemos el id del profesor
		return idProfesor;
	}

	// Método para pedir la nota
	public static double pedirNota() {
		// Variable para guardar la nota
		double nota;

		// Preguntamos por la nota y la guardamos
		System.out.println("Introduce la nota");
		nota = sc.nextDouble();
		// Limpiamos el escaner
		sc.nextLine();

		// Devolvemos la nota
		return nota;
	}
}
