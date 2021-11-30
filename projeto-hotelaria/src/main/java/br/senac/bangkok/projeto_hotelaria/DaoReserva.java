package br.senac.bangkok.projeto_hotelaria;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DaoReserva {

	public static void fazerReserva(Reserva reserva) throws Exception{
		String sql = "INSERT INTO reservaentity (IdFuncionario, IdQuarto, IdHospede, ValorQuarto, DataInicioReserva, DataFimReserva) "
				+ "VALUES (?, ?,?, ?, ?, ?)";
		
		try (PreparedStatement ps = DB.connect().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
			ps.setInt(1, reserva.getFuncionario().getId());
			ps.setInt(2, reserva.getQuarto().getId());
			ps.setInt(3, reserva.getHospede().getId());
			ps.setFloat(4, reserva.getValorQuarto());
			ps.setDate(5, Date.valueOf(reserva.getDataInicioReserva()));
			ps.setDate(6, Date.valueOf(reserva.getDataFimReserva()));
			
			ps.execute();
			
		}
	}
	
	public static List<Reserva> gerarRelatrio (LocalDate dataInicioReserva, LocalDate dataFimReserva) throws Exception{
		String sql = "select h.nome, q.nome, r.DataInicioReserva, r.DataFimReserva, f.nome from reservaentity r "
				+ "INNER JOIN hospedeentity h ON r.IdHospede = h.id "
				+ "INNER JOIN quartoentity q ON r.IdQuarto = q.id "
				+ "INNER JOIN funcionarioentity f ON r.IdFuncionario = f.id "
				+ "WHERE r.DataInicioReserva >= ? AND r.DataFimReserva <= ?";
		
		List<Reserva> results = new ArrayList<Reserva>();
		
		try(PreparedStatement ps = DB.connect().prepareStatement(sql)) {
			ps.setDate(1, Date.valueOf(dataInicioReserva));
			ps.setDate(2, Date.valueOf(dataFimReserva));
			
			ResultSet rs = ps.executeQuery();
			
			Reserva reserva;
			while(rs.next()) {
				
				reserva = new Reserva();
				
				Hospede hospede = new Hospede();
				hospede.setNome(rs.getString("nome"));
				
				Quartos quarto = new Quartos();
				quarto.setNome(rs.getString("nome"));
				
				reserva.setHospede(hospede);
				reserva.setQuarto(quarto);
				reserva.setDataInicioReserva(rs.getDate("DataInicioReserva").toLocalDate());
				reserva.setDataFimReserva(rs.getDate("DataFimReserva").toLocalDate());
				
				Funcionario funcionario = new Funcionario();
				funcionario.setNome(rs.getString("nome"));
				
				reserva.setFuncionario(funcionario);
				results.add(reserva);
				
				
			}
		}
		return results;
	}
}
