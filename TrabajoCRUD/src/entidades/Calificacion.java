package entidades;

/**
 * Clase que representa una calificacion
 */
public class Calificacion {

	// id que representa a una calificacion
	private int id;
	// id que represente a un estudiante
	private int estudianteId;
	// id que representa a un curso
	private int cursoId;
	// id que representa a un profesor
	private int profesorId;
	// El tipo de la evaluacion
	private String tipoEvaluacion;
	// La nota de la calificacion
	private double nota;
	// La fecha de la evaluacion
	private String fechaEvaluacion;

	/**
	 * El constructor de la clase calificaion
	 * 
	 * @param estudianteId    id que represente a un estudiante
	 * @param cursoId         id que representa a un curso
	 * @param profesorId      id que representa a un profesor
	 * @param tipoEvaluacion  El tipo de la evaluacion
	 * @param nota            La nota de la calificacion
	 * @param fechaEvaluacion La fecha de la evaluacion
	 */
	public Calificacion(int estudianteId, int cursoId, int profesorId, String tipoEvaluacion, double nota,
			String fechaEvaluacion) {
		this.estudianteId = estudianteId;
		this.cursoId = cursoId;
		this.profesorId = profesorId;
		this.tipoEvaluacion = tipoEvaluacion;
		this.nota = nota;
		this.fechaEvaluacion = fechaEvaluacion;
	}

	/**
	 * El constructor de la clase calificaion
	 * 
	 * @param id              id que representa a una calificación
	 * @param estudianteId    id que represente a un estudiante
	 * @param cursoId         id que representa a un curso
	 * @param profesorId      id que representa a un profesor
	 * @param tipoEvaluacion  El tipo de la evaluacion
	 * @param nota            La nota de la calificacion
	 * @param fechaEvaluacion La fecha de la evaluacion
	 */
	public Calificacion(int id, int estudianteId, int cursoId, int profesorId, String tipoEvaluacion, double nota,
			String fechaEvaluacion) {
		super();
		this.id = id;
		this.estudianteId = estudianteId;
		this.cursoId = cursoId;
		this.profesorId = profesorId;
		this.tipoEvaluacion = tipoEvaluacion;
		this.nota = nota;
		this.fechaEvaluacion = fechaEvaluacion;
	}

	/**
	 * Método que devuelve el id
	 * 
	 * @return El id de la calificación
	 */
	public int getId() {
		return id;
	}

	/**
	 * Método para modificar el id
	 * 
	 * @param id el nuevo id de la calificación
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Método que devuelve el id del estudiante
	 * 
	 * @return El id del estudiante
	 */
	public int getEstudianteId() {
		return estudianteId;
	}

	/**
	 * Método que devuelve el id del curso
	 * 
	 * @return El id del curso
	 */
	public int getCursoId() {
		return cursoId;
	}

	/**
	 * Método que devuelve el id del profesor
	 * 
	 * @return El id del profesor
	 */
	public int getProfesorId() {
		return profesorId;
	}

	/**
	 * Método que devuelve el tipo de evaluación
	 * 
	 * @return El tipo de evaluacion de la calificación
	 */
	public String getTipoEvaluacion() {
		return tipoEvaluacion;
	}

	/**
	 * Método que devuelve la nota
	 * 
	 * @return La nota de la calificación
	 */
	public double getNota() {
		return nota;
	}

	/**
	 * Método que devuelve la fecha de evaluación
	 * 
	 * @return La fecha de evaluación de la calificación
	 */
	public String getFechaEvaluacion() {
		return fechaEvaluacion;
	}

	@Override
	public String toString() {
		return "Id: " + id + "\nEstudianteId: " + estudianteId + "\nCursoId: " + cursoId + "\nProfesorId: "
				+ "\nTipo Evaluación: " + tipoEvaluacion + "\nNota: " + nota + "\nFecha evaluación: " + fechaEvaluacion;
	}
}
