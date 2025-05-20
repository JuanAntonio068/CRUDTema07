package entidades;

/**
 * Clase que representa a un curso
 */
public class Curso {

	// Id que representa a un curso
	private int id;
	// El nombre del curso
	private String nombre;

	/**
	 * Constructor de la clase curso
	 * 
	 * @param id     Id que representa a un curso
	 * @param nombre nombre del curso
	 */
	public Curso(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	/**
	 * Método para devolver el id
	 * 
	 * @return El id del curso
	 */
	public int getId() {
		return id;
	}

	/**
	 * Método para cambiar el id
	 * 
	 * @param id El nuevo id del curso
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Método para devolver el nombre
	 * 
	 * @return El nombre del curso
	 */
	public String getNombre() {
		return nombre;
	}

}
