package Empleados;

public class Principal {

	public static void main(String[] args) throws Exception {
		Empleado e1 = new Empleado("123456789","Antonio", "Rodríguez Antúnez", 1200);
		Empleado e2 = new Empleado("234567890","Pedro", "Sánchez Guitiérrez", 1500);
		Empleado e3 = new Empleado("345678901","Dolores", "Rubio Delgado", 1100);
		
		GestionEmpleado ge = new GestionEmpleado();	
		
		ge.nuevoEmpleado(e1);		
		ge.nuevoEmpleado(e2);		
		ge.nuevoEmpleado(e3);
		ge.getEmpleado("123456789A");
		ge.modificarEmpleado("234567890B", 200);
		ge.borrarEmpleado("345678901C");
		ge.getEmpleados();
		ge.imprimirEmpleados();
		
	}
	
}
