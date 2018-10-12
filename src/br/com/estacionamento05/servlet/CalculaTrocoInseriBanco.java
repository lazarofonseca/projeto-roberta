package br.com.estacionamento05.servlet;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalculaTrocoInseriBanco
 */
@WebServlet("/calculatroco")
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
		String id_veiculo = request.getParameter("id_veiculo");
		String placa = request.getParameter("placa");
		String tempo = request.getParameter("tempo");
		
		// data/hora atual
		LocalDateTime agora = LocalDateTime.now();

		// formatar a data
		DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String dataFormatada = formatterData.format(agora);

		// formatar a hora
		DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm:ss");
		String horaFormatada = formatterHora.format(agora);
		
		
		
		double vPago = Double.parseDouble(valorPago); // Converte para calculo
		double vPagar = Double.parseDouble(valorApagar); 
		
		double retorno = vPago - vPagar;  // Calcula o troco
		
		DecimalFormatSymbols dfs = new DecimalFormatSymbols(); // Formatar para exibir no formato ideal
		dfs.setDecimalSeparator('.');
		DecimalFormat df = new DecimalFormat("00.00", dfs);
		
		//System.out.println(retorno);
		
		String troco = df.format(retorno);
		
		// TRABALHAR NESTA LINHA PARA ARRUMAR OS PARAMETROS PARA SEREM ENVIADOS 
		
		request.setAttribute("id_veiculo", id_veiculo);
		request.setAttribute("placa", placa);
		request.setAttribute("tempo", tempo);
		request.setAttribute("valorPago", valorPago);
		request.setAttribute("valorApagar", valorApagar);
		request.setAttribute("dataSaida", dataFormatada);
		request.setAttribute("horaSaida", horaFormatada);
		request.setAttribute("troco", troco);
		
		
		RequestDispatcher dispachar = request.getRequestDispatcher("/jsp/recibo-pago.jsp");
		dispachar.forward(request, response);
		
	}

}
