package entidades;

/**
 * Clase que representa a un curso
 */
public class Curso {

	/**
	 * Id que representa a un curso
	 */
	private int id;
	/**
	 * El nombre del curso
	 */
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
	 * Método para devolver el nombre
	 * 
	 * @return El nombre del curso
	 */
	public String getNombre() {
		return nombre;
	}

	@Override
	/**
	 * Método para mostrar la información del objeto
	 * 
	 * @return Una cadena con toda la informacion del objeto
	 */
	public String toString() {
		return "Id: " + id + "\nNombre: " + nombre;
	}

	@Override
	/**
	 * Método para saber si dos objetos son iguales
	 * 
	 * @return True si son iguales, false, si no
	 */
	public boolean equals(Object obj) {
		// Hacemos un cast
		Curso curs = (Curso) obj;

		return this.id == curs.id;
	}
}
