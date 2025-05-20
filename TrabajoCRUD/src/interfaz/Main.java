package interfaz;

import java.util.Scanner;

import entidades.Calificacion;
import entidades.Curso;
import entidades.Estudiante;
import entidades.Profesor;

public class Main {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

	}

	// Método para mostar el menú
	public void menu() {
		System.out.println("1. Crear calificación");
		System.out.println("2. Listar todas las calificaciones de un estudiante");
		System.out.println("3. Listar todas las calificaciones de un curso");
		System.out.println("4. Modificar una calificación");
		System.out.println("5. Eliminar calificación");
	}

	// Método para leer los datos
	public Calificacion leerDatos() {
		Calificacion c1 = null; 
		Estudiante e1 = null;
		Curso cu1 = null;
		Profesor p1 = null;
		
		
	}
}
