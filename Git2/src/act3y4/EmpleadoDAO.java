package act3y4;

import java.util.List;

import Empleados.Empleado;

public interface EmpleadoDAO {
	List<Empleado> getEmpleados ();
	boolean registrar(Empleado empleado);
	Empleado buscar(String dni);
	boolean eliminar(String dni);
	boolean modificar(String dni, double sueldo);
}
