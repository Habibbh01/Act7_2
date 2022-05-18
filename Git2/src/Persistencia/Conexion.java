package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;


public class Conexion{


	protected Connection conexion;
	public void conectarBD() {
		String host = "localhost";
		int puerto = 3306;
		String db = "empleado";
		String url = "jdbc:mysql://" + host + ":" + puerto + "/" + db;
		String login = "root";
		String password = "";

		try {
			// Conectamos con la base de datos
			conexion = DriverManager.getConnection(url, login, password);
			System.out.println((conexion != null) ? "CONEXION OK" : "CONEXION FALLIDA");
			
		} catch (java.sql.SQLException sqle) {
			System.out.println("Error: " + sqle);
		}
	}
	public Connection getConexion() {
		return conexion;
	}
	
}
