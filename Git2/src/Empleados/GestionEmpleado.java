package Empleados;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Persistencia.EmpleadoDaoBD;
import act3y4.EmpleadoDAO;
import act3y4.EmpleadoDAOFichero;


public class GestionEmpleado {	
	private EmpleadoDaoBD db = new EmpleadoDaoBD();
	private EmpleadoDAOFichero dbb = new EmpleadoDAOFichero();
	private List<Empleado> empleados = new ArrayList<>();
	public GestionEmpleado(){
		
	}
	
	public GestionEmpleado(String miDAO) {
		this.empleados = new ArrayList<Empleado>();
		if(miDAO == "Base de datos") {
			this.db = new EmpleadoDaoBD();
		} else if(miDAO == "Fichero") {
			this.dbb = new EmpleadoDAOFichero();
		} else {
			System.out.println("Introduce una elección válida. Se elegirá Base de datos por defecto.");
			this.db = new EmpleadoDaoBD();
		}
	}



	public List<Empleado> getEmpleados(){
		try {
			empleados = db.getEmpleados();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return empleados;
	}
	/**
	 * Imprimirá todos los empleados guardados en el ArrayList
	 * de empleados
	 */
	public void imprimirEmpleados() {
		for(Empleado emps : empleados) {
			System.out.println(emps);
		}
	}
	/**
	 * @param dni Es el dni que le pasamos para obtener los datos del cliente que nos interesa
	 * @return Devolverá el empleado si esat dentro del ArrayList y en el caso que no esté,
	 * buscará en la base de datos y si tampoco está devolverá null
	 */
	public Empleado getEmpleado(String dni) {
		Empleado empleadoPorDNI = null;

		for(Empleado emps : empleados) {
			if(emps.getDni().contains(dni)) {
				empleadoPorDNI = emps;
			}
		}
		
		if (empleadoPorDNI == null) {
			empleadoPorDNI = db.buscar(dni);
		}
		return empleadoPorDNI;
	}
	/**
	 * @param empleado Es el empleado que queremos insertar
	 * @return Devuelve en empleado que se ha insertado
	 * @throws Exception 
	 */
	public boolean nuevoEmpleado(Empleado empleado) throws Exception {
		empleados.add(empleado);
		return db.registrar(empleado);
	}
	public boolean borrarEmpleado(String dni) throws Exception {
		Iterator<Empleado> it = empleados.iterator();
		while(it.hasNext()) {
			if(it.next().getDni().contains(dni)) {
				it.remove();
			}
		}
		return db.eliminar(dni);
	}
	/**
	 * @param dni Es el dni que hay que introducir para cambiar su sueldo
	 * @param sueldo Es el sueldo que quieres ponerle al empleado introducido por dni
	 * @return Devuelve el empleado que se ha actualizado en la base de datos
	 * @throws Exception 
	 */
	public boolean modificarEmpleado(String dni, double sueldo) throws Exception {
		for(Empleado emps : empleados) {
			if(emps.getDni().contains(dni)) {
				emps.setSueldo(sueldo);
			}
		}
		return db.modificar(dni, sueldo);
	}
}