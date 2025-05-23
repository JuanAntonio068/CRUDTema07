package entidades;

/**
 * Clase que representa a un estudiante
 */
public class Estudiante {

	/**
	 * El id que representa al estudiante
	 */
	private int id;
	/**
	 * El nombre del estudiante
	 */
	private String nombre;
	/**
	 * El apellido del estudiante
	 */
	private String apellido;

	/**
	 * Constructor de la clase estudiante
	 * 
	 * @param id       id que representa al estudiante
	 * @param nombre   nombre del estudiante
	 * @param apellido apellido del estudiante
	 */
	public Estudiante(int id, String nombre, String apellido) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	/**
	 * Método para devolver el id
	 * 
	 * @return El id del estudiante
	 */
	public int getId() {
		return id;
	}

	/**
	 * Método para devolver el nombre
	 * 
	 * @return El nombre del estudiante
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Método para devolver el apellido
	 * 
	 * @return El apellido del estudiante
	 */
	public String getApellido() {
		return apellido;
	}

	@Override
	/**
	 * Método para mostrar la información del objeto
	 * 
	 * @return Una cadena con toda la informacion del objeto
	 */
	public String toString() {
		return "Id: " + id + "\nNombre: " + nombre + "\nApellido: " + apellido;
	}

	@Override
	/**
	 * Método para saber si dos objetos son iguales
	 * 
	 * @return True si son iguales, false, si no
	 */
	public boolean equals(Object obj) {
		// Hacemos un cast
		Estudiante est = (Estudiante) obj;

		return this.id == est.id;
	}
}
