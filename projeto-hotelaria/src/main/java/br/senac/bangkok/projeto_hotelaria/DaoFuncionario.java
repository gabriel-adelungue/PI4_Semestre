package br.senac.bangkok.projeto_hotelaria;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DaoFuncionario {
	public static void inserir(Funcionario funcionarios) throws Exception{
		String sql = "INSERT INTO FuncionarioEntity (id, nome, cpf, email, celular, endereco, cargo) VALUES(?, ?, ?, ?, ?, ?, ?)";
	
	//try-with-resources
	try (PreparedStatement ps = DB.connect().prepareStatement(sql)){
		ps.setInt(1, funcionarios.getId());
		ps.setString(2, funcionarios.getNome());
		ps.setString(3, funcionarios.getCpf());
		ps.setString(4, funcionarios.getEmail());
		ps.setString(5, funcionarios.getCelular());
		ps.setString(6, funcionarios.getEndereco());
		ps.setString(7, funcionarios.getCargo());
		
		ps.execute();
		
		} 
	}
	
	public static List<Funcionario> listar() throws Exception{
		String sql = "SELECT * FROM FuncionarioEntity";
		
		List<Funcionario> resultados = new ArrayList<Funcionario>();
		
		try(PreparedStatement ps = DB.connect().prepareStatement(sql)){
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Funcionario funcionarios = new Funcionario ();
						
				funcionarios.setId(rs.getInt("id"));				
				funcionarios.setNome(rs.getString("nome"));				
				funcionarios.setCpf(rs.getString("cpf"));
				funcionarios.setCargo(rs.getString("cargo"));
				funcionarios.setCelular(rs.getString("celular"));
				funcionarios.setEmail(rs.getString("email"));
				funcionarios.setEndereco(rs.getString("endereco"));

				resultados.add(funcionarios);
				 
			}
		}
		return resultados;
	}
	
	public static List<Funcionario> pesquisar(String nome) throws Exception {
		String sql = "SELECT * FROM funcionarioentity WHERE Nome like ?";
		
		List<Funcionario> resultados = new ArrayList<Funcionario>();
		
		try (PreparedStatement ps = DB.connect().prepareStatement(sql)){
			ps.setString(1, "%" + nome + "%");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Funcionario funcionarios = new Funcionario ();
				
				funcionarios.setId(rs.getInt("id"));				
				funcionarios.setNome(rs.getString("nome"));				
				funcionarios.setCpf(rs.getString("cpf"));
				funcionarios.setCargo(rs.getString("cargo"));
				funcionarios.setCelular(rs.getString("celular"));
				funcionarios.setEmail(rs.getString("email"));
				funcionarios.setEndereco(rs.getString("endereco"));

				resultados.add(funcionarios);
			}
		}
		
		return resultados;
	}
	
	public static void atualizar(Funcionario funcionarios) throws Exception{
		String sql = "UPDATE FuncionarioEntity SET nome = (?), cpf = (?), email = (?), celular = (?), endereco = (?), cargo = (?) WHERE id = (?)";
	
	//try-with-resources
	try (PreparedStatement ps = DB.connect().prepareStatement(sql)){
		ps.setString(1, funcionarios.getNome());
		ps.setString(2, funcionarios.getCpf());
		ps.setString(3, funcionarios.getEmail());
		ps.setString(4, funcionarios.getCelular());
		ps.setString(5, funcionarios.getEndereco());
		ps.setString(6, funcionarios.getCargo());
		ps.setInt(7, funcionarios.getId());
		
		ps.execute();
		
		} 

	}
	
	public static void deletar(int id) throws Exception{
		String sql =  "DELETE FROM FuncionarioEntity WHERE id = (?)";
		
		try(PreparedStatement ps = DB.connect().prepareStatement(sql)){
			ps.setInt(1, id);
			
			ps.execute();
		}
	}
	
}
