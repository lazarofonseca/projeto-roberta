package br.com.estacionamento05.servlet;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalculaTrocoInseriBanco
 */
@WebServlet("/CalculaTrocoInseriBanco")
public class CalculaTrocoInseriBanco extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public CalculaTrocoInseriBanco() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String valorPago = request.getParameter("valorPago"); // Recebe a string valor pago
		String valorApagar = request.getParameter("valorPagar"); // Recebe a String valor a pagar
		
		double vPago = Double.parseDouble(valorPago); // Converte para calculo
		double vPagar = Double.parseDouble(valorApagar); 
		
		double retorno = vPago - vPagar;  // Calcula o troco
		
		DecimalFormatSymbols dfs = new DecimalFormatSymbols(); // Formatar para exibir no formato ideal
		dfs.setDecimalSeparator(',');
		DecimalFormat df = new DecimalFormat("00,00", dfs);
		
		String troco = df.format(retorno);
		
		// TRABALHAR NESTA LINHA PARA ARRUMAR OS PARAMETROS PARA SEREM ENVIADOS 
		
		request.setAttribute("id_veiculo", idd);
		request.setAttribute("placa", placa);
		request.setAttribute("tempo", tempo);
		request.setAttribute("valor", valorPagar);
		request.setAttribute("dataSaida", dataFormatada);
		request.setAttribute("horaSaida", horaFormatada);
		
		RequestDispatcher dispachar = request.getRequestDispatcher("/jsp/recibo-saida.jsp");
		dispachar.forward(request, response);
		
	}

}
