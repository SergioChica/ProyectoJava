package modelo.dao;

import java.awt.Taskbar.State;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controlador.Coordinador;
import modelo.conexion.Conexion;
import modelo.vo.UsuarioVO;

public class UsuarioDAO {


	private Coordinador miCoordinador;

	public void setCoordinador(Coordinador miCoordinador) {
		// TODO Auto-generated method stub
		this.miCoordinador=miCoordinador;
	}

	public String registrarUsuario(UsuarioVO miUsuarioVO) {
		// TODO Auto-generated method stub
		String resultado="";
		
		Connection connection=null;
		Conexion conexion=new Conexion(); 
		PreparedStatement preStatement=null;
		
		connection=conexion.getConnetion();	
		String consulta="insert into usuario(documento,nombre,profesion,edad,direccion,telefono) values (?,?,?,?,?,?)";
		
		try {
			preStatement = connection.prepareStatement(consulta);
			preStatement.setString(1, miUsuarioVO.getDocumento());
			preStatement.setString(2, miUsuarioVO.getNombre());
			preStatement.setString(3, miUsuarioVO.getProfesion());
			preStatement.setInt(4, miUsuarioVO.getEdad());
			preStatement.setString(5, miUsuarioVO.getDireccion());
			preStatement.setString(6, miUsuarioVO.getTelefono());
			preStatement.execute();
			
			resultado="ok";
		} catch (SQLException e) {
			System.out.println("No se pudo registrar el dato:"+e.getMessage());
			resultado="error";
		}
		
		return resultado;
	}

	public UsuarioVO consultarUsuario(String doc) {
		// TODO Auto-generated method stub
		Connection connection=null;
		Conexion miConexion=new Conexion();
		PreparedStatement statement=null;
		ResultSet result=null;
		
		UsuarioVO miUsuario=null; 
		
		connection=miConexion.getConnetion();	
		String consulta="select * from usuario where documento= ? ";
		
		try {
			statement=connection.prepareStatement(consulta);
			statement.setString(1, doc);
			
			result=statement.executeQuery();
			
			while(result.next()==true) {
				miUsuario=new UsuarioVO();
				miUsuario.setDocumento(result.getString("documento"));
				miUsuario.setNombre(result.getString("nombre"));
				miUsuario.setProfesion(result.getString("profesion"));
				miUsuario.setEdad(result.getInt("edad"));
				miUsuario.setDireccion(result.getString("direccion"));
				miUsuario.setTelefono(result.getString("telefono"));
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Error en la consulta del usuario:"+e.getMessage());
		}
		
		
		return miUsuario;
	}

	public String actualizarUsuario(UsuarioVO miUsuarioVO) {
		// TODO Auto-generated method stub
		String resultado="";
		
		Connection connection=null;
		Conexion conexion=new Conexion(); 
		connection=conexion.getConnetion();	
		PreparedStatement preStatement=null;
		
		String consulta="update usuario set documento= ?,nombre= ?,profesion= ?,edad= ?,direccion= ?,telefono= ? where documento= ?";
		
		try {
			preStatement = connection.prepareStatement(consulta);
			preStatement.setString(1, miUsuarioVO.getDocumento());
			preStatement.setString(2, miUsuarioVO.getNombre());
			preStatement.setString(3, miUsuarioVO.getProfesion());
			preStatement.setInt(4, miUsuarioVO.getEdad());
			preStatement.setString(5, miUsuarioVO.getDireccion());
			preStatement.setString(6, miUsuarioVO.getTelefono());
			preStatement.setString(7, miUsuarioVO.getDocumento());
			preStatement.executeUpdate();
			
			resultado="ok";
		} catch (SQLException e) {
			System.out.println("No se pudo registrar el dato:"+e.getMessage());
			resultado="error";
		}
		
		return resultado;
	}

	public String eliminarUsuario(String documento) {
		// TODO Auto-generated method stub		
		Connection connection=null;
		Conexion conexion=new Conexion(); 
		connection=conexion.getConnetion();	
		PreparedStatement statement=null;
		
		String resultado="";
		try {
			String consulta="delete from usuario where documento= ?";
			
			statement=connection.prepareStatement(consulta);
			statement.setString(1, documento);
			
			statement.executeUpdate();
			
			resultado="ok";
			statement.close();
			conexion.desconectar();
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			resultado="error";
		}
		
		return resultado;
	}

	
}
