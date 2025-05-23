package entidades;

/**
 * Clase que representa a un profesor
 */
public class Profesor {
	/**
	 * Id que representa a un profesor
	 */
	private int id;
	/**
	 * El nombre del profesor
	 */
	private String nombre;

	/**
	 * Constructor de la clase profesor
	 * 
	 * @param id     Id que representa a un profesor
	 * @param nombre nombre del profesor
	 */
	public Profesor(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	/**
	 * Método para devolver el id
	 * 
	 * @return El id del profesor
	 */
	public int getId() {
		return id;
	}

	/**
	 * Método para devolver el nombre
	 * 
	 * @return El nombre del profesor
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
		Profesor prof = (Profesor) obj;

		return this.id == prof.id;
	}
}
