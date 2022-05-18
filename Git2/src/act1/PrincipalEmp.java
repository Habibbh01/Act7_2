package act1;

import java.sql.ResultSet;


public class PrincipalEmp {

	public static void main(String[] args) {
		EmpleadoBD emp = new EmpleadoBD();
		emp.conectarBD();
		String consulta = "SELECT * from empleado";
		String valores=("INSERT INTO empleado values ('11111A','antonio','perez',1000),('22222E','carlos','sainz',2000),('33333O','pepe','perez',1000),('44444P','antonio','segura',3000)");
		emp.insertar(valores);
		//emp.actualizar('11111A', 2000);
		//emp.borrar(33333);
		emp.getEmpleados();
		ResultSet resultado = emp.consultarEmpleados(consulta);

		emp.imprimirResultadoEmp(resultado);
	}

}
