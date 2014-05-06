package gallinator.DAO;

import gallinator.modelo.Personaje;
import gallinator.modelo.User;
import gallinator.pojo.ConexionDB;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UsuarioDAO extends ConexionDB {

	public void RegisterUser(User usuario) {
		try {
			getConexion();
			String insert = "insert into usuario(User, Pass, Email) values(?,?,?)";
			pstmt = conexion.prepareStatement(insert);
			pstmt.setString(1, usuario.getUser());
			pstmt.setString(2, usuario.getPass());
			pstmt.setString(3, usuario.getEmail());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getErrorCode());
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			cerrar();
		}
	}

	public void RegisterPlayer(Personaje player) {
		try {
			getConexion();
			String insert = "insert into personaje(UsuarioFK, Alias, Clase) values(?,?,?)";
			pstmt = conexion.prepareStatement(insert);
			pstmt.setString(1, player.getUsuariofk());
			pstmt.setString(2, player.getAlias());
			pstmt.setString(3, player.getClase());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getErrorCode());
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			cerrar();
		}
	}

	public void EliminarProducto(String value) {
		getConexion();
		try {
			String where = value;
			pstmt = conexion.prepareStatement(where);
			pstmt.setString(1, where);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
