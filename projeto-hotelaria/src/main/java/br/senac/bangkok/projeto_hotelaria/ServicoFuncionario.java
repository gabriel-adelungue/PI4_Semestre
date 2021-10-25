package br.senac.caco.funcionario;

import java.util.ArrayList;
import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("funcionarios")
public class ServicoFuncionario {
	
	private static List<Funcionario> lista = new ArrayList<Funcionario>();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void inserir (Funcionario funcionarios) {
		try {
			DaoFuncionario.inserir(funcionarios);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Funcionario> listar(){
		try {
			return DaoFuncionario.listar();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("pesquisar")
	public List<Funcionario> pesquisar(@QueryParam("nome") String nome){
		List<Funcionario> resultados = new ArrayList<Funcionario>();
		
		for(int i = 0; i < lista.size(); i++) {
			Funcionario funcionarios = lista.get(i);
			if (funcionarios.getNome().equals(nome)) {
				resultados.add(funcionarios);				
			}
		}
		
		return resultados;
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void atualizar(Funcionario funcionarios) {
		try {
			DaoFuncionario.atualizar(funcionarios);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for (int i = 0; i < lista.size(); i++) {
			Funcionario funcionarioBusca = lista.get(i);
			if(funcionarioBusca.getId() == funcionarios.getId()) {
				funcionarioBusca.setNome(funcionarios.getNome());
				funcionarioBusca.setCpf(funcionarios.getCpf());
				funcionarioBusca.setCargo(funcionarios.getCargo());
				funcionarioBusca.setCelular(funcionarios.getCelular());
				funcionarioBusca.setEndereco(funcionarios.getEndereco());
				funcionarioBusca.setEmail(funcionarios.getEmail());
				break;
			}
		}
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public void deletar(Funcionario funcionarios) {
		try {
			DaoFuncionario.deletar(funcionarios);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
	}
}
	

