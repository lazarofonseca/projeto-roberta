package br.com.estacionamento05.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.Time;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import br.com.estacionamento05.DAO.PatioDAO;
import br.com.estacionamento05.DTO.PatioDTO;


@WebServlet("/saida")
public class SaidaVeiculo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final double VALOR = 5.00;
       
   
    public SaidaVeiculo() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String placa = request.getParameter("placa"); // Pega o parametro placa
		String id_veiculo = request.getParameter("id_veiculo"); // Pega o parametro id_veiculo
		
		//Definir a o Locale
		
		DecimalFormatSymbols dfs = new DecimalFormatSymbols();
		dfs.setDecimalSeparator(',');
		DecimalFormat df = new DecimalFormat("00,00", dfs);
		
		
		// data/hora atual
		LocalDateTime agora = LocalDateTime.now();

		// formatar a data
		DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String dataFormatada = formatterData.format(agora);

		// formatar a hora
		DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm:ss");
		String horaFormatada = formatterHora.format(agora);
		
		PatioDTO saida = new PatioDTO();
		Integer id = Integer.parseInt(id_veiculo);
		saida.setIdSaida(id);
		saida.setPlaca(placa);
		
		PatioDAO saidaDAO = new PatioDAO(saida);
		int tempo = saidaDAO.tempoTotal(id, placa);
		System.out.println(tempo);
		String idd = Integer.toString(id);
		double valorPagar = VALOR;
		
		
		if(tempo > 4) {
			valorPagar = valorPagar + ((tempo - 4)*2);
		}else {
			valorPagar = VALOR;
		}
		
		String valor = df.format(valorPagar);
		
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
