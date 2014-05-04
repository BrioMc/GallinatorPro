package gallinator.pojo;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validacion extends ConexionDB {

	public boolean email(String email) {
		email.replace(" ", "");
		if (email.length() == 0 | email == null) {
			return false;
		}
		Pattern p = Pattern.compile("[-\\w\\.]+@[\\.\\w]+\\.\\w+");
		Matcher m = p.matcher(email);
		m.matches();
		if (email == "" | email == null | m.matches() == false) {
			System.out.println("Introduzca un email válido");
			return false;
		}

		return true;
	}

	public boolean campoVacio(String prueba) {
		prueba.replace(" ", "");
		if (prueba.length() == 0 | prueba == null) {
			return false;
		}
		return true;
	}

	public boolean esNumero(String numero) {
		numero.replace(" ", "");
		if (numero.length() == 0 | numero == null) {
			return false;
		}
		try {
			@SuppressWarnings("unused")
			int N = Integer.parseInt(numero);
			return true;

		} catch (NumberFormatException ex) {
			return false;
		}
	}

	public boolean validarDNI(String dni) {
		dni.replace(" ", "");
		if (dni.length() == 0 | dni == null) {
			return false;
		}
		try {
			Pattern pattern = Pattern
					.compile("(\\d{1,8})([TRWAGMYFPDXBNJZSQVHLCKEtrwagmyfpdxbnjzsqvhlcke])");
			Matcher matcher = pattern.matcher(dni);
			if (matcher.matches()) {
				String letra = matcher.group(2);
				String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
				int index = Integer.parseInt(matcher.group(1));
				index = index % 23;
				String reference = letras.substring(index, index + 1);

				if (reference.equalsIgnoreCase(letra)) {
					System.out.println("funciona");
				} else {
					System.out.println("Introduzca un DNI válido");
					return false;
				}
			} else {
				System.out.println("Introduzca el DNI");
				return false;
			}

		} catch (NumberFormatException e) {
			System.out.println("Introduzca el DNI");
			// TODO Auto-generated catch block
			return false;
		}
		return true;
	}

	public boolean comprobarCP(String cp) {
		cp.replace(" ", "");
		if (cp.length() == 0 | cp == null) {
			return false;
		}
		try {
			int N = Integer.parseInt(cp);
			if (N > 51000 | N < 0) {
				return false;
			} else {
				return true;
			}
		} catch (NumberFormatException ex) {
			return false;
		}

	}

	public boolean existeUsuario(String usuario) {
		boolean existe = false;
		try {
			getConexion();
			pstmt = conexion
					.prepareStatement("select Usuario from usuarios where usuario=?");
			pstmt.setString(1, usuario);
			resultado = pstmt.executeQuery();
			if (resultado.next()) {
				existe = true;
			} else {
				existe = false;
			}
		} catch (SQLException ex) {

		} finally {
			cerrar();
		}
		return existe;
	}

}
