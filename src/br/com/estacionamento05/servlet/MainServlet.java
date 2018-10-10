package br.com.estacionamento05.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.estacionamento05.DAO.VeiculoDAO;
import br.com.estacionamento05.DTO.VeiculoDTO;
import jdk.nashorn.internal.ir.RuntimeNode.Request;


@WebServlet("/ticket")
public class MainServlet extends HttpServlet{
	
	
	private final int VAGAS = 3;
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1699946570549922424L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		int cont = 0;
		String placa = req.getParameter("placa");
		
		// data/hora atual
		LocalDateTime agora = LocalDateTime.now();

		// formatar a data
		DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String dataFormatada = formatterData.format(agora);

		// formatar a hora
		DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm:ss");
		String horaFormatada = formatterHora.format(agora);
		
		
		VeiculoDTO veiculo = new VeiculoDTO();
		
		veiculo.setPlaca(placa);
		
		VeiculoDAO dao = new VeiculoDAO(veiculo);
		dao.adiciona(veiculo);
		String id = Integer.toString(dao.retornaId());
		
		req.setAttribute("id_veiculo", id);
		req.setAttribute("dataEntrada", dataFormatada);
		req.setAttribute("horaEntrada", horaFormatada);
		
		RequestDispatcher dispachar = req.getRequestDispatcher("/jsp/recibo-entrada.jsp");
		dispachar.forward(req, resp);
		
		
	}
	
	
}

