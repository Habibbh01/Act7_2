package Persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Empleados.Empleado;

public class EmpleadoDaoBD {

	
	Conexion db;
	public EmpleadoDaoBD() {
		db = new Conexion();
		db.conectarBD();
	}
	
	public boolean registrar(Empleado empleado) throws Exception {
		try {
		PreparedStatement st= db.getConexion().prepareStatement("insert into empleado(dni,nombre,apellidos,sueldo) values(?,?,?,?)");
		st.setString(1, empleado.getDni());
		st.setString(2, empleado.getNombre());
		st.setString(3, empleado.getApellidos());
		st.setDouble(4, empleado.getSueldo());
		st.executeUpdate();
		return true;
		}catch(Exception e) {
			throw e;
		}
	}
	public Empleado buscar (String dni) {
		Empleado emp = null;
		PreparedStatement ps;
		ResultSet rs;
		try {
			ps = db.getConexion().prepareStatement("SELECT * FROM empleado WHERE dni = ?");
			ps.setString(1, dni);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				String DNI = rs.getString("dni");
				String nombre = rs.getString("nombre");
				String apellidos = rs.getString("apellidos");
				double sueldo = rs.getDouble("sueldo");
				emp = new Empleado(DNI, nombre, apellidos, sueldo);
				return emp;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	
	public boolean modificar(String dni, double sueldo) throws Exception {
		try {
		PreparedStatement st= db.getConexion().prepareStatement("update empleado set sueldo=? where dni= ? ");
		st.setDouble(1, sueldo);
		st.setString(2, dni);
		st.executeUpdate();
		return true;
		}catch(Exception e) {
			throw e;
		}
	}

	
	public boolean eliminar(String dni) throws Exception {
		try {
			PreparedStatement st = db.getConexion().prepareStatement("DELETE FROM empleado WHERE dni = ?");
			st.setString(1, dni);
			st.executeUpdate();
			return true;
		} catch (Exception e) {
			throw e;
		}
	}

	
	public List<Empleado> getEmpleados() throws Exception{
		List<Empleado>lista= null;
		try {
		PreparedStatement st= db.getConexion().prepareStatement("SELECT * from empleado");
		lista = new ArrayList<Empleado>();
		ResultSet rs = st.executeQuery();
		while(rs.next()){
			Empleado emp = new Empleado();
			emp.setDni(rs.getString("dni"));
			emp.setNombre(rs.getString("nombre"));
			emp.setApellidos(rs.getString("apellidos"));
			emp.setSueldo(rs.getInt("sueldo"));
			lista.add(emp);
		}
		rs.close();
		st.close();
		}catch(Exception e) {
			throw e;
		}
		return lista;	
	
	}
	
	
}
