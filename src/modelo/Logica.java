package modelo;

import controlador.Coordinador;
import modelo.vo.UsuarioVO;

public class Logica {
	
	final int SELECCION=0;
	final int ADMINISTRADOR=1;
	final int USUARIO=2; 
	
	final String PASS_ADMIN="admin";
	final String PASS_USER="1234";

	private Coordinador miCoordinador;

	public void setCoordinador(Coordinador miCoordinador) {
		// TODO Auto-generated method stub
		this.miCoordinador=miCoordinador;
	}
	
	public String validarIngreso(int index, String pass) {
		
		String retorno="";
		
		if (index==SELECCION) {
			retorno="error";
		}else {
			retorno=validarPass(index,pass);
		}
		
		return retorno;
	}

	private String validarPass(int index, String pass) {
		// TODO Auto-generated method stub
		String retorno="";
		switch (index) {
		case ADMINISTRADOR:
			if (pass.equals(PASS_ADMIN)) {
				retorno="Administrador";
			}else {
				retorno="Invalido";
			}
			break;
		case USUARIO:
			if (pass.equals(PASS_USER)) {
				retorno="Usuario";
			}else {
				retorno="invalido";
			}
			break;	
		}		
		return retorno;
	}

	public boolean validarCampos(UsuarioVO miUsuarioVO) {
		// TODO Auto-generated method stub
		boolean validarNombre=false;
		
		String nombre=miUsuarioVO.getNombre();

		if (nombre!=null && !nombre.equals("")) {
			validarNombre=true;
		}
		
		if (validarNombre==true) {
			return true;
		}else {
			return false;
		}
	}

	public Integer validarEdad(String edadIngresada) {
		// TODO Auto-generated method stub
		Integer edad=null;
		try {
			edad=Integer.parseInt(edadIngresada);
		} catch (Exception e) {
			edad=null;
		}
		
		return edad;
	}

}
