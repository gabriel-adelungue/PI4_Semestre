package br.senac.bangkok.projeto_hotelaria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
	public static Connection connect() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/bangkok",
				"root", "adlungue2105");
	}
	
	public static void main(String[] args) throws Exception, ClassNotFoundException {
		connect();
		System.out.println("conexão OK!");
	}
	
}
