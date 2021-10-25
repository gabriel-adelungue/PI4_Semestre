package br.senac.bangkok.projeto_hotelaria;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class DaoQuartos {
	
	public static void inserir(Quartos quartos) throws Exception{
		String sql = "INSERT INTO QuartoEntity (nome, valor, numeroQuarto) VALUES(?, ?, ?)";
	
	//try-with-resources
	try (PreparedStatement ps = DB.connect().prepareStatement(sql)){
		ps.setString(1, quartos.getNome());
		ps.setFloat(2, quartos.getValor());
		ps.setInt(3, quartos.getNumeroQuarto());
		
		
		ps.execute();
		
		} 

	}	
	
	public static List<Quartos> listar() throws Exception{
		String sql = "SELECT * FROM QuartoEntity";
		
		List<Quartos> resultados = new ArrayList<Quartos>();
		
		try(PreparedStatement ps = DB.connect().prepareStatement(sql)){
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Quartos quartos = new Quartos ();
						
				quartos.setId(rs.getInt("id"));				
				quartos.setNome(rs.getString("nome"));				
				quartos.setNumeroQuarto(rs.getInt("numeroQuarto"));
				quartos.setValor(rs.getFloat("valor"));
				
				resultados.add(quartos);
				 
			}
		}
		
		return resultados;
	}
	
	public static void atualizar(Quartos quartos) throws Exception{
		String sql = "UPDATE QuartoEntity SET nome = (?), valor = (?), numeroQuarto = (?) WHERE id = (?)";
	
	//try-with-resources
	try (PreparedStatement ps = DB.connect().prepareStatement(sql)){
		ps.setString(1, quartos.getNome());
		ps.setFloat(2, quartos.getValor());
		ps.setInt(3, quartos.getNumeroQuarto());
		ps.setInt(4, quartos.getId());
		
		ps.execute();
		
		} 

	}
	
	public static void deletar(Quartos quartos) throws Exception{
		String sql =  "DELETE FROM QuartoEntity WHERE id = (?)";
		
		try(PreparedStatement ps = DB.connect().prepareStatement(sql)){
			ps.setInt(1, quartos.getId());
			
			ps.execute();
		}
	}

}
