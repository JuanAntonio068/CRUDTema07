package entidades;

/**
 * Clase que representa a un profesor
 */
public class Profesor {
	// Id que representa a un profesor
	private int id;
	// El nombre del profesor
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
	 * Método para cambiar el id
	 * 
	 * @param id El nuevo id del profesor
	 */
	public void setId(int id) {
		this.id = id;
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
	public String toString() {
		return "Id: " + id + "\nNombre: " + nombre;
	}
}
