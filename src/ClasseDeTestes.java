import java.util.Scanner;

import br.com.estacionamento05.DAO.PatioDAO;
import br.com.estacionamento05.DAO.VeiculoDAO;
import br.com.estacionamento05.DTO.PatioDTO;
import br.com.estacionamento05.DTO.VeiculoDTO;

public class ClasseDeTestes {

	public static void main(String[] args) {
		
		
		PatioDTO patioDTO = new PatioDTO();
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite o id a ser calculado as horas: ");
		int id_v = sc.nextInt();
		System.out.println("Digite a placa: ");
		String placa = sc.next();
		
		patioDTO.setIdSaida(id_v);
		patioDTO.setPlaca(placa);
		PatioDAO patioDAO = new PatioDAO(patioDTO);
		
		
		VeiculoDTO veiculoDTO = new VeiculoDTO();
		VeiculoDAO veiculo = new VeiculoDAO(veiculoDTO);		
	
		
		System.out.println(patioDAO.tempoTotal(id_v, placa) + " horas");
		System.out.println("");
		System.out.println(patioDTO.getIdSaida());
		System.out.println("");
		
		
		System.out.println("Ultimo registro " + veiculo.retornaId());
		
		
		

	}

}
