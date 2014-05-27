package gallinator.DAO;

import gallinator.modelo.Enemigo;
import gallinator.pojo.ConexionDB;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class EnemigoDAO extends ConexionDB {
	private String INSERT_STATEMENT = "update enemigo set Nombre=?, Imagen=?, Dmg=?, Sangre=?, Exp=?, Points=? where idEnemigo=?";
	private String UPDATE_STATEMENT = "INSERT INTO enemigo (Nombre, Imagen, Dmg, Sangre, Exp, Points) VALUES (?,?,?,?,?,?)";

	public void modEnemigo(HttpServletRequest req, String ubicacion) {
		try {
			int i = 1;
			getConexion();
			pstmt = conexion.prepareStatement(UPDATE_STATEMENT);
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			List<FileItem> items = upload.parseRequest(req);
			File base = new File(ubicacion + "/images/enemigos/");
			String c = "/images/enemigos/";
			for (Object item : items) {

				FileItem uploaded = (FileItem) item;
				if (uploaded.isFormField()) {
					// String key = uploaded.getFieldName();
					String valor = uploaded.getString("UTF-8");
					pstmt.setString(i, valor);
					i++;

				} else {
					String nombre = uploaded.getName();
					// String extension =
					// nombre.substring(nombre.lastIndexOf("."));
					base.mkdirs();
					File fichero = new File(base, nombre);
					uploaded.write(fichero);
					pstmt.setString(i, c + nombre);
					i++;
				}
			}
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getErrorCode());
			e.printStackTrace();
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			cerrar();
		}
	}

	public void añadirEnemigo(HttpServletRequest req, String ubicacion) {
		try {
			int i = 1;
			getConexion();
			pstmt = conexion.prepareStatement(INSERT_STATEMENT);
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			List<FileItem> items = upload.parseRequest(req);
			File base = new File(ubicacion + "/images/enemigos/");
			String c = "/images/enemigos/";
			for (Object item : items) {

				FileItem uploaded = (FileItem) item;
				if (uploaded.isFormField()) {
					// String key = uploaded.getFieldName();
					String valor = uploaded.getString("UTF-8");
					pstmt.setString(i, valor);
					i++;

				} else {
					String nombre = uploaded.getName();
					// String extension =
					// nombre.substring(nombre.lastIndexOf("."));
					base.mkdirs();
					File fichero = new File(base, nombre);
					uploaded.write(fichero);
					pstmt.setString(i, c + nombre);
					i++;
				}
			}
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getErrorCode());
			e.printStackTrace();
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			cerrar();
		}

	}

	public Collection<Enemigo> leerEnemigo(String clausulaWhere) {

		Collection<Enemigo> lista = new ArrayList<Enemigo>();

		try {
			getConexion();
			String insert = "select * from enemigo" + clausulaWhere;
			pstmt = conexion.prepareStatement(insert);
			resultado = pstmt.executeQuery();
			while (resultado.next()) {
				Enemigo enemy = new Enemigo();
				enemy.setId(resultado.getInt("idEnemigo"));
				enemy.setNombre(resultado.getString("Nombre"));
				enemy.setImagen(resultado.getString("Imagen"));
				enemy.setDmg(resultado.getInt("Dmg"));
				enemy.setSangre(resultado.getInt("Sangre"));
				enemy.setExp(resultado.getInt("Exp"));
				enemy.setPoints(resultado.getInt("Points"));
				lista.add(enemy);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			cerrar();
		}
		return lista;
	}

}
