package br.senac.bangkok.projeto_hotelaria;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DaoHospede {

	public static void inserir(Hospede hospede) throws Exception {
		String sql = "INSERT INTO hospedeentity (Nome, Cpf, Email, Celular) VALUES(?, ?, ?, ?)";
		
		//try-with-resources
		try (PreparedStatement ps = DB.connect().prepareStatement(sql)) {
			ps.setString(1, hospede.getNome());
			ps.setString(2, hospede.getCpf());
			ps.setString(3, hospede.getEmail());
			ps.setString(4, hospede.getCelular());
			
			ps.execute();
		}
		
	}
	
	public static void atualizar(Hospede hospede) throws Exception {
		String sql = "UPDATE hospedeentity SET Nome = ?, Cpf = ?, Email = ?, Celular = ? WHERE Id = ?";
		try (PreparedStatement ps = DB.connect().prepareStatement(sql)) {
			
			ps.setString(1, hospede.getNome());
			ps.setString(2, hospede.getCpf());
			ps.setString(3, hospede.getEmail());
			ps.setString(4, hospede.getCelular());
			ps.setInt(5, hospede.getId());
			
			ps.execute();
		}
	}
	
	public static void excluir(int id) throws Exception {
		String sql = "DELETE FROM hospedeentity WHERE id = ?";
		
		try (PreparedStatement ps = DB.connect().prepareStatement(sql)) {
			ps.setInt(1, id);
			ps.execute();
		}
	}
	
	public static List<Hospede> listar() throws Exception {
		String sql = "SELECT * FROM hospedeentity";
		
		List<Hospede> resultados = new ArrayList<Hospede>();
		
		try(PreparedStatement ps = DB.connect().prepareStatement(sql)){
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Hospede hospede = new Hospede();
				
				hospede.setId(rs.getInt("Id"));				
				hospede.setNome(rs.getString("Nome"));				
				hospede.setCpf(rs.getString("Cpf"));				
				hospede.setEmail(rs.getString("Email"));				
				hospede.setCelular(rs.getString("Celular"));
				
				resultados.add(hospede);
			}
		}
		return resultados;
	}
	
	public static List<Hospede> pesquisar(String nome) throws Exception {
		String sql = "SELECT * FROM hospedeentity WHERE Nome like ?";
		
		List<Hospede> resultados = new ArrayList<Hospede>();
		
		try (PreparedStatement ps = DB.connect().prepareStatement(sql)){
			ps.setString(1, "%" + nome + "%");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Hospede hospede = new Hospede();
				
				hospede.setId(rs.getInt("Id"));
				hospede.setNome(rs.getString("Nome"));				
				hospede.setCpf(rs.getString("Cpf"));				
				hospede.setEmail(rs.getString("Email"));				
				hospede.setCelular(rs.getString("Celular"));
				
				resultados.add(hospede);
			}
		}
		
		return resultados;
	}
}
