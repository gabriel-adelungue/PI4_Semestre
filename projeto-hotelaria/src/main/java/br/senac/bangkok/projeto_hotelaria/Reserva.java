package br.senac.bangkok.projeto_hotelaria;

import java.time.LocalDate;

public class Reserva {

	private Integer id;
	private Funcionario funcionario;
	private Quartos quarto;
	private Hospede hospede;
	private Float valorQuarto;
	private LocalDate dataInicioReserva;
	private LocalDate dataFimReserva;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public Quartos getQuarto() {
		return quarto;
	}
	public void setQuarto(Quartos quarto) {
		this.quarto = quarto;
	}
	public Hospede getHospede() {
		return hospede;
	}
	public void setHospede(Hospede hospede) {
		this.hospede = hospede;
	}
	public Float getValorQuarto() {
		return valorQuarto;
	}
	public void setValorQuarto(Float valorQuarto) {
		this.valorQuarto = valorQuarto;
	}
	public LocalDate getDataInicioReserva() {
		return dataInicioReserva;
	}
	public void setDataInicioReserva(LocalDate dataInicioReserva) {
		this.dataInicioReserva = dataInicioReserva;
	}
	public LocalDate getDataFimReserva() {
		return dataFimReserva;
	}
	public void setDataFimReserva(LocalDate dataFimReserva) {
		this.dataFimReserva = dataFimReserva;
	}
}
