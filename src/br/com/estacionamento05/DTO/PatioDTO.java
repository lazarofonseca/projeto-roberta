package br.com.estacionamento05.DTO;

import java.sql.Date;
import java.sql.Time;

public class PatioDTO {
	
	private int idSaida;
	
	private Date dataSaida;
	
	private Time horaSaida;
	
	private double totalPagar;
	
	private int tempo;
	
	private String status;
	
	private String placa;

	
	
	
	
	public int getIdSaida() {
		return idSaida;
	}

	public void setIdSaida(int idSaida) {
		this.idSaida = idSaida;
	}

	public Date getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}

	public Time getHoraSaida() {
		return horaSaida;
	}

	public void setHoraSaida(Time horaSaida) {
		this.horaSaida = horaSaida;
	}

	public double getTotalPagar() {
		return totalPagar;
	}

	public void setTotalPagar(double totalPagar) {
		this.totalPagar = totalPagar;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public int getTempo() {
		return tempo;
	}

	public void setTempo(int tempo) {
		this.tempo = tempo;
	}
	
	

}
