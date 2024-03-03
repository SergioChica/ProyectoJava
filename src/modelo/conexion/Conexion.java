package modelo.conexion;

import java.sql.*;

public class Conexion {

	private String nombreBd="universidad_bd";
	private String usuario="root";
	private String password="";
	private String url="jdbc:mysql://localhost:3306/"+nombreBd+"?useUnicode=true&use"
			+ "JDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&"
			+ "serverTimezone=UTC	";
	
	Connection conn=null;
	
	
	public Conexion() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn=DriverManager.getConnection(url,usuario,password);
			
			if (conn!=null) {
				System.out.println("Conexion Exitosa a la BD: "+nombreBd);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Ocurre una ClassNotFoundException"+e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Ocurre una SQLException"+e.getMessage());
		}
		
	}
	
	public Connection getConnetion() {
		return conn;
	}
	
	public void desconectar() {
		conn=null;
	}
}
