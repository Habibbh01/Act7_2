package act3y4;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Empleados.Empleado;


public class EmpleadoDAOFichero implements EmpleadoDAO{
	
	private List<Empleado> empleados = new ArrayList<>();
	String fichero = "src/act3y4/Empleados.csv";
	/**
	 * List<Empleado> getEmpleados(): consulta la lista completa de empleados del
	 * fichero CSV y la devuelve.
	 */
	@Override
	public List<Empleado> getEmpleados() {
		Scanner sc = null;
		String rutaFichero = fichero;
		try {
			sc = new Scanner(new File(rutaFichero));

			while (sc.hasNextLine()) {
				String linea = sc.nextLine();
				String[] separacionLineas = linea.split(" ,");
				Empleado emp = new Empleado(separacionLineas[0], separacionLineas[1], separacionLineas[2],
						Integer.valueOf(separacionLineas[3]));
				empleados.add(emp);
			}
		} catch (Exception ex) {
			System.out.println("Mensaje: " + ex.getMessage());
		} finally {
			if (sc != null)
				sc.close();
		}
		return empleados;	
	}
	/**
	 * boolean registrar (Empleado empleado): inserta un empleado al final del
	 * archivo CSV y devuelve true si se consiguió insertar.
	 */
	@Override
	public boolean registrar(Empleado empleado) {
		String dni = empleado.getDni();
		String nombre = empleado.getNombre();
		String apellidos = empleado.getApellidos();
		double sueldo = empleado.getSueldo();

		String[] lineas = { dni, nombre, apellidos, String.valueOf(sueldo), "\n" };
		String rutaFichero = fichero;
		FileWriter fichero = null;
		try {
			fichero = new FileWriter(rutaFichero, true);
			for (String linea : lineas) {
				fichero.write(linea + ",");
			}
			fichero.close();
		} catch (Exception ex) {
			System.out.println("Mensaje de la excepcion: " + ex.getMessage());
		}
		return false;	}

	@Override
	public Empleado buscar(String dni) {
		return null;
	}

	@Override
	public boolean eliminar(String dni) {
		return false;
	}

	@Override
	public boolean modificar(String dni, double sueldo) {
		return false;
	}


}
