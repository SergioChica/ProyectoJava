package controlador;

import modelo.Logica;
import modelo.dao.UsuarioDAO;
import modelo.vo.UsuarioVO;
import vista.VentanaConsultar;
import vista.VentanaLogin;
import vista.VentanaPrincipal;
import vista.VentanaRegistro;

public class Coordinador {

	private VentanaPrincipal miVentanaPrincipal;
	private VentanaLogin miVentanaLogin;
	private Logica miLogica;
	private VentanaRegistro miVentanaRegistro;
	private VentanaConsultar miVentanaConsultar;
	private UsuarioDAO miUsuarioDAO;

	public void setVentanaPrincipal(VentanaPrincipal miVentanaPrincipal) {
		// TODO Auto-generated method stub
		this.miVentanaPrincipal=miVentanaPrincipal;
	}

	public void setVentanaLogin(VentanaLogin miVentanaLogin) {
		// TODO Auto-generated method stub
		this.miVentanaLogin=miVentanaLogin;
	}

	public void setLogica(Logica miLogica) {
		// TODO Auto-generated method stub
		this.miLogica=miLogica;
	}

	public String validarIngreso(int index, String pass) {
		// TODO Auto-generated method stub
		return miLogica.validarIngreso(index,pass);
	}

	public void cerrarVentanaLogin() {
		// TODO Auto-generated method stub
		miVentanaLogin.dispose();
	}

	public void asignarUsurio(String usuario) {
		// TODO Auto-generated method stub
		miVentanaPrincipal.asignarUsuario(usuario);
	}

	public void mostrarLogin() {
		// TODO Auto-generated method stub
		miVentanaLogin.setVisible(true);
	}

	public void setVentanaRegistro(VentanaRegistro miVentanaRegistro) {
		// TODO Auto-generated method stub
		this.miVentanaRegistro=miVentanaRegistro;
	}

	public void setVentanaConsultar(VentanaConsultar miVentanaConsultar) {
		// TODO Auto-generated method stub
		this.miVentanaConsultar=miVentanaConsultar;
	}

	public void mostrarRegitro() {
		// TODO Auto-generated method stub
		miVentanaRegistro.setVisible(true);
	}

	public void mostrarConsultar() {
		// TODO Auto-generated method stub
		miVentanaConsultar.setVisible(true);
	}

	public void setUsuarioDAO(UsuarioDAO miUsuarioDAO) {
		// TODO Auto-generated method stub
		this.miUsuarioDAO=miUsuarioDAO;
	}

	public String registrarUsuario(UsuarioVO miUsuarioVO) {
		// TODO Auto-generated method stub
		return miUsuarioDAO.registrarUsuario(miUsuarioVO);
	}

	public boolean validarCampos(UsuarioVO miUsuarioVO) {
		// TODO Auto-generated method stub
		
		return miLogica.validarCampos(miUsuarioVO);
	}

	public Integer validarEdad(String edadIngresada) {
		// TODO Auto-generated method stub
		return miLogica.validarEdad(edadIngresada);
	}

	public UsuarioVO consultarUsuario(String doc) {
		// TODO Auto-generated method stub
		return miUsuarioDAO.consultarUsuario(doc);
	}

	public String actualizarUsuario(UsuarioVO miUsuarioVO) {
		// TODO Auto-generated method stub
		return miUsuarioDAO.actualizarUsuario(miUsuarioVO);
	}

	public String eliminarUsuario(String documento) {
		// TODO Auto-generated method stub
		return miUsuarioDAO.eliminarUsuario(documento);
	}

}