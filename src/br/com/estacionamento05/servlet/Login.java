package br.com.estacionamento05.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import br.com.estacionamento05.DAO.UsuarioDAO;
import br.com.estacionamento05.DTO.UsuarioDTO;


@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Login() {
        super();
        
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		
		UsuarioDTO user = new UsuarioDTO();
		
		user.setUsuario(usuario);
		user.setSenha(senha);
		
		
		
		
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		try {
			if(usuarioDAO.checkLogin(user.getUsuario(), user.getSenha())){
				RequestDispatcher view = request.getRequestDispatcher("/home.html");
				view.forward(request, response);
			}else {
				JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos");
				RequestDispatcher view = request.getRequestDispatcher("/index.html");
				view.forward(request, response);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
