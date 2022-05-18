package act3y4;

import Empleados.Empleado;
import Empleados.GestionEmpleado;

public class Principal {
	public static void main(String[] args) throws Exception {
		Empleado e1 = new Empleado("123456789A","Antonio", "Rodríguez Antúnez", 1200);
		Empleado e2 = new Empleado("234567890B","Pedro", "Sánchez Guitiérrez", 1500);
		Empleado e3 = new Empleado("345678901C","Dolores", "Rubio Delgado", 1100);
		Empleado e4 = new Empleado("333333887P","Paco", "Vich Trac", 2100);
		
		GestionEmpleado gestion = new GestionEmpleado("Base de datos");
		GestionEmpleado gestion2 = new GestionEmpleado("Fichero");
		/*EmpDAOFich.getEmpleados();*/

	}
}
