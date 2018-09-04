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

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.estacionamento05.DAO.VeiculoDAO;
import br.com.estacionamento05.DTO.VeiculoDTO;


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
		//Date data = (Date) new java.util.Date();
		//DateFormat formatar = DateFormat.getDateInstance();
		//String dataAtual = formatar.format(data);
		//Date dataHoraAtual = new Date(0);
		//String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
		//String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);
		
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
		if(cont < VAGAS) {
		
		
			
		VeiculoDAO dao = new VeiculoDAO(veiculo);
		dao.adiciona(veiculo);
		
		
		
		out.println("<html>");
		out.println("<body>");
		out.println("<header>)"
				
				+ "<div id=\"menu\">\n" + 
				"		<ul>\n" + 
				"			<li><a href=\"\">Home</a></li>\n" + 
				"			<li><a href=\"\">Sobre</a></li>\n" + 
				"			<li><a href=http://localhost:8080/Estacionamento05/endrada.html>Entrada Veiculo</a></li>\n" + 
				"			<li><a href=\"\">Siada Veículo</a></li>\n" +  
				"		</ul>\n" + 
				"	</div>"
				
				+ "</header>");
		
		
		out.println("<H3>Ticket gerado com successo!</H3>");
		out.print("<table width=300 cellpadding=10 align=center border:1px solid black border-collapse: collapse>");
		out.print("<tr>");
		out.print("<td>Placa</td>");
		out.print("<td>"+placa+"<td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td>Data</td>");
		out.print("<td>"+dataFormatada+"<td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td>Hora</td>");
		out.print("<td>"+horaFormatada+"<td>");
		out.print("</tr>");
		out.print("<table>");
		out.println("</body>");
		out.println("</html>");
		
		cont ++;
		}else {
		
		out.println("<html>");
			out.println("<body>");
			out.println("<h1>Não ha vagas</h1><br>");
			out.println("</body>");
			out.println("</html>");
		}
		
		
		
	}
	
	
}

