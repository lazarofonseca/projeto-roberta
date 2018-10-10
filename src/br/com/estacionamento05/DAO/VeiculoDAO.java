package br.com.estacionamento05.DAO;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import br.com.estacionamento05.DTO.VeiculoDTO;
import br.com.estacionamento05.util.ConexaoMySQL;

public class VeiculoDAO {

private Connection connection;
	
	public VeiculoDAO(VeiculoDTO VeiculoDTO) {
		this.connection = (Connection) new ConexaoMySQL().getConexaoMySQL();
		
	}
	
	private String getplaca() {
		return null;
	}
	
	private String dataEntrada() {
		return null;
	}
	
	public void adiciona(VeiculoDTO veiculoDTO) {
		
		
		String sql = "INSERT INTO tbl_veiculo(placa,dataEntrada, horaEntrada) VALUES(?,?,?)";
		
		try {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			/*
			
			stmt.setString(1, veiculoDTO.getPlaca());
			stmt.setTimestamp(2, Timestamp.valueOf(veiculoDTO.getDataEntrada()));
			java.util.Date data = new java.util.Date();
			java.sql.Timestamp timestamp = new java.sql.Timestamp(data.getTime());
			stmt.setTimestamp(2, timestamp);
			java.sql.Time horaAtual = new java.sql.Time(data.getTime());
			stmt.setTime(3, horaAtual);
			stmt.execute();  
            */
			
			stmt.setString(1, veiculoDTO.getPlaca());
			//stmt.setTimestamp(2, Timestamp.valueOf(veiculoDTO.getDataEntrada()));
			java.util.Date data = new java.util.Date();
			java.sql.Timestamp timestamp = new java.sql.Timestamp(data.getTime());
			stmt.setTimestamp(2, timestamp); // Data Atual
			java.sql.Time horaAtual = new java.sql.Time(data.getTime());
			stmt.setTime(3, horaAtual); // Hora atual de entrada
			stmt.execute(); 
			
			
			
			stmt.close();
            
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
	
	public List<VeiculoDTO> listaVeiculo(){
		
		String sql = "SELECT id_veiculo FROM tbl_veiculo ORDER BY id DESC LIMIT 1";
		
		try {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet result = stmt.executeQuery();

			while (result.next()) {
				
				VeiculoDTO veiculo = new VeiculoDTO();
				veiculo.setId(result.getInt("id_veiculo"));
				//veiculo.setPlaca(result.getString("placa"));
				//veiculoDTO.setDataHora(result.getTimestamp("dataEntrada").toLocalDateTime());
				
				//Date resultado = new Date(result.getTimestamp(3).getTime());
				
				
				listaVeiculo().add(veiculo);
				
			}

			stmt.close();
			result.close();

		} catch (Exception e) {
			throw new RuntimeException();
		}
		
		return listaVeiculo();
	}
	
public int retornaId(){ //Retorna o id_veiculo do ultimo registro
		
		String sql = "SELECT id_veiculo FROM tbl_veiculo ORDER BY id_veiculo DESC LIMIT 1";
		int idRetornado =0;
		
		try {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet result = stmt.executeQuery();

			if(result.next()) {
				
				
				idRetornado = result.getInt("id_veiculo");
			}

			stmt.close();
			result.close();

		} catch (Exception e) {
			throw new RuntimeException();
		}
		
		return idRetornado;
	}
}
