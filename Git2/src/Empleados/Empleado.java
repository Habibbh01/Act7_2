package Empleados;

public class Empleado {

	private String dni;
	private String nombre;
	private String apellidos;
	private double sueldo;
	
	public Empleado(String dni, String nombre, String apellidos, double sueldo) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.sueldo = sueldo;
	}
	
	public Empleado() {
	}

	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public double getSueldo() {
		return sueldo;
	}
	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
	@Override
	public String toString() {
		
		return "DNI " + this.dni + " NOMBRE " + this.nombre + " APELLIDOS " + this.apellidos + " SUELDO " + this.sueldo;
	}
}
