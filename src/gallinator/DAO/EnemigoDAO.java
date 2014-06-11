package gallinator.DAO;

import gallinator.modelo.Enemigo;
import gallinator.pojo.ConexionDB;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Clase DAO de los metodos que interactuan entre la bd y el objeto enemigo
 */
public class EnemigoDAO extends ConexionDB {
	private String UPDATE_STATEMENT = "update enemigo set Nombre=?, Imagen=?, Dmg=?, Sangre=?, Exp=?, Points=? where idEnemigo=?";
	private String INSERT_STATEMENT = "INSERT INTO enemigo (Nombre, Imagen, Dmg, Sangre, Exp, Points) VALUES (?,?,?,?,?,?)";

	/**
	 * Metodo por el cual se añade un enemigo a la base de datos
	 */
	public void añadirEnemigo(HttpServletRequest req, String ubicacion) {
		try {
			int i = 0;
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
					String key = uploaded.getFieldName();
					String valor = uploaded.getString("UTF-8");
					// System.out.println(i + ":" + key + ":" + valor);
					if (key.equals("idEnemy")) {
						if (valor.equals("null")) {
							// System.out.println("Continua");
							i++;
						} else {
							System.out.println("Actualiza");
							pstmt = conexion.prepareStatement(UPDATE_STATEMENT);
							pstmt.setString(7, valor);
							// System.out.println(i + ":" + key + ":" + valor);
							i++;
						}
					} else {

						pstmt.setString(i, valor);
						// System.out.println(i + ":" + key + ":" + valor);
						i++;
					}

				} else {
					String nombre = uploaded.getName();
					// String extension =
					// nombre.substring(nombre.lastIndexOf("."));
					if (nombre != "") {
						base.mkdirs();
						File fichero = new File(base, nombre);
						uploaded.write(fichero);
						pstmt.setString(i, c + nombre);
						// System.out.println(i + ":" + c + nombre);
						i++;
					} else {
						pstmt.setString(i, c + nombre);
						// System.out.println(i + ":" + c + nombre);
						i++;
					}
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

	/**
	 * Metodo Que devuelve un arrayList de objetos Enemigo con todos los
	 * enemigos obtenidos de la bd
	 */
	public ArrayList<Enemigo> leerEnemigo(String clausulaWhere) {

		ArrayList<Enemigo> lista = new ArrayList<Enemigo>();

		try {
			getConexion();
			String insert = "select * from enemigo " + clausulaWhere;
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

	/**
	 * Metodo para borrar un enemigo de la base de datos
	 */
	public void delEnemy(int id) {
		String insert = "delete from enemigo where idEnemigo=?";
		try {
			getConexion();
			pstmt = conexion.prepareStatement(insert);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			cerrar();
		}
	}

	/**
	 * Metodo para obtener un Objeto Enemigo con los datos de uno buscado por su
	 * id
	 */
	public Enemigo takeEnemy(int id) {
		Enemigo enemy = new Enemigo();
		try {
			getConexion();
			String insert = "select * from enemigo where idEnemigo=?";
			pstmt = conexion.prepareStatement(insert);
			pstmt.setInt(1, id);
			resultado = pstmt.executeQuery();
			if (resultado.next()) {
				enemy.setId(resultado.getInt("idEnemigo"));
				enemy.setNombre(resultado.getString("Nombre"));
				enemy.setImagen(resultado.getString("Imagen"));
				enemy.setDmg(resultado.getInt("Dmg"));
				enemy.setSangre(resultado.getInt("Sangre"));
				enemy.setExp(resultado.getInt("Exp"));
				enemy.setPoints(resultado.getInt("Points"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			cerrar();
		}
		return enemy;
	}
}
