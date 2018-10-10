package br.com.estacionamento05.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.sun.javafx.geom.transform.GeneralTransform3D;

import br.com.estacionamento05.DTO.PatioDTO;
import br.com.estacionamento05.DTO.VeiculoDTO;
import br.com.estacionamento05.util.ConexaoMySQL;

public class PatioDAO {

	int tempo;
	
private static Connection connection;
	
	public PatioDAO(PatioDTO patioDTO) {
		this.connection = (Connection) new ConexaoMySQL().getConexaoMySQL();
		
	}
	
	
public void adiciona(PatioDTO patioDTO) {
		
	
		//Time tempoTotal = (Time) calculaTempo(100, placa); Observar a lógica para melhorar
		
		
		
		String sql = "INSERT INTO tbl_veiculo(dataSaida, horaSaida, totalPagar, tempo, status, placa) "
				+ "VALUES(?,?,?,?,?,?)";
		
		try {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			
			
			//stmt.setTimestamp(2, Timestamp.valueOf(veiculoDTO.getDataEntrada()));
			java.util.Date data = new java.util.Date();
			java.sql.Timestamp timestamp = new java.sql.Timestamp(data.getTime());
			stmt.setTimestamp(1, timestamp);
			java.sql.Time horaAtual = new java.sql.Time(data.getTime());
			stmt.setTime(2, horaAtual);
			stmt.setDouble(3, patioDTO.getTotalPagar());
			//stmt.setTime(4, tempoTotal); // Formular uma converção para inteiro
			stmt.setString(5, patioDTO.getStatus());
			stmt.setString(6, patioDTO.getPlaca());
			stmt.execute();  
            stmt.close();
            
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	public int tempoTotal(int id, String placa) { //Retorna a diferença em horas do tempo de entrada e saida
		
		String sql = "select TIMESTAMPDIFF(hour, dataEntrada, NOW()) as horas "
				+ "from tbl_veiculo WHERE id_veiculo = ? and placa = ?";
		
		try {
			
			PreparedStatement stm = (PreparedStatement) connection.prepareStatement(sql);
			stm.setInt(1, id); // Preciso setar quais parametros vão ser pegos
			stm.setString(2, placa);
			ResultSet rs = stm.executeQuery();
			
			if(rs.next()) {
				
				
				tempo = rs.getInt("horas");
			}
			
			stm.close();
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return tempo;
	}
	

}
