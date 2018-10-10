package br.com.estacionamento05.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Teste
 */
@WebServlet("/teste")
public class Teste extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Teste() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		System.out.println("O servlet foi chamado!");
		
		String placa = request.getParameter("placa");
		String datantrada = request.getParameter("dataEntrada");
		String horaEntrada = request.getParameter("horaEntrada");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		
		out.println("<h2>" + placa + "</h2>");
		out.println("<h2>" + datantrada + "</h2>");
		out.println("<h2>" + horaEntrada + "</h2>");
		
		out.println("</body>");
		out.println("</html>");
		
	}

}
