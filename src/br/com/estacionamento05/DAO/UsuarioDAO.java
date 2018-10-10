package br.com.estacionamento05.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.tomcat.dbcp.dbcp.ConnectionFactory;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.sun.glass.ui.Window.Level;
import com.sun.istack.internal.logging.Logger;

import br.com.estacionamento05.util.ConexaoMySQL;

public class UsuarioDAO {

    private Connection connection;

	public boolean checkLogin(String login, String senha) throws SQLException {

    	this.connection = (Connection) new ConexaoMySQL().getConexaoMySQL();
        
    	
    	PreparedStatement stmt = null;
        ResultSet rs = null;

        boolean check = false;

        try {

            stmt = (PreparedStatement) connection.prepareStatement("SELECT * FROM tbl_usuario WHERE usuario = ? and senha = ?");
            stmt.setString(1, login);
            stmt.setString(2, senha);

            rs = stmt.executeQuery();

            if (rs.next()) {

                
                check = true;
            }

        } catch (SQLException ex) {
            ex.getMessage();
        } finally {
         stmt.close();
        }

        return check;

    }

}
