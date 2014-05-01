package ikex.pojo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConexionDB {

	private static final String DataSource = "java:/comp/env/jdbc/ikexDB";
	protected DataSource datasource = null;
	protected DataSource basicdatasource = null;
	protected Connection conexion;
	protected PreparedStatement pstmt;
	protected ResultSet resultado;
	int error;

	public ConexionDB() {
	}

	public Connection getConexion() {
		try {
			Context initContext = new InitialContext();
			datasource = (DataSource) initContext.lookup(DataSource);
			conexion = datasource.getConnection();
		} catch (SQLException e) {
			conexion = null;
			error = e.getErrorCode();
		} catch (NamingException e) {

		}

		return conexion;
	}

	public void cerrar() {
		try {
			if (conexion != null) {
				conexion.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (resultado != null) {
				resultado.close();
			}
		} catch (SQLException e) {
			error = e.getErrorCode();
		}
	}

}
