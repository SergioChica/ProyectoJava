package controlador;

import modelo.Logica;
import vista.VentanaLogin;
import vista.VentanaPrincipal;
import vista.VentanaRegistro;
import vista.VentanaConsultar;
import modelo.dao.UsuarioDAO;

public class Aplicacion {

	public Aplicacion() {
		// TODO Auto-generated constructor stub

	}
	
	public void iniciarSistema() {
		
		//Instanciamos clases unicas.
		VentanaPrincipal miVentanaPrincipal = new VentanaPrincipal();
		VentanaLogin miVentanaLogin = new VentanaLogin(miVentanaPrincipal, true);
		VentanaRegistro miVentanaRegistro = new VentanaRegistro(miVentanaPrincipal, true);
		VentanaConsultar miVentanaConsultar = new VentanaConsultar(miVentanaPrincipal, true);
		Coordinador miCoordinador = new Coordinador();
		Logica miLogica = new Logica();
		UsuarioDAO miUsuarioDAO = new UsuarioDAO();
		
		//Relacionamos  las clases con el coordinador
		miVentanaPrincipal.setCoordinador(miCoordinador);
		miVentanaLogin.setCoordinador(miCoordinador);
		miVentanaRegistro.setCoordinador(miCoordinador);
		miVentanaConsultar.setCoordinador(miCoordinador);
		miLogica.setCoordinador(miCoordinador);
		miUsuarioDAO.setCoordinador(miCoordinador);
		
		//Relacionamos Coordinador con las clases.
		miCoordinador.setVentanaPrincipal(miVentanaPrincipal);
		miCoordinador.setVentanaLogin(miVentanaLogin);
		miCoordinador.setVentanaRegistro(miVentanaRegistro);
		miCoordinador.setVentanaConsultar(miVentanaConsultar);
		miCoordinador.setLogica(miLogica);
		miCoordinador.setUsuarioDAO(miUsuarioDAO);
		
		miVentanaPrincipal.setVisible(true);
		miVentanaLogin.setVisible(true);
	}

}
