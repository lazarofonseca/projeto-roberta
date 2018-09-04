package br.com.estacionamento05.DTO;

import java.time.LocalDateTime;
import java.util.Date;

public class VeiculoDTO {
	
	private int id;
	
	private String placa;
	
	private LocalDateTime dataEntrada;

	private LocalDateTime horaEntrada;

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public LocalDateTime getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(LocalDateTime dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public LocalDateTime gethoraEntrada() {
		return horaEntrada;
	}

	public void sethotaEntrada(LocalDateTime horaEntrada) {
		this.horaEntrada = horaEntrada;
	}
	
	

}
