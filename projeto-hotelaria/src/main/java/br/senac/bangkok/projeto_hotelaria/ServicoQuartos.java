package br.senac.bangkok.projeto_hotelaria;

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

@Path("quartos")
public class ServicoQuartos {
	
private static List<Quartos> lista = new ArrayList<Quartos>();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void inserir (Quartos quartos) {
		try {
			DaoQuartos.inserir(quartos);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Quartos> listar(){
		try {
			return DaoQuartos.listar();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("pesquisar")
	public List<Quartos> pesquisar(@QueryParam("nome") String nome){
		List<Quartos> resultados = new ArrayList<Quartos>();
		
		for(int i = 0; i < lista.size(); i++) {
			Quartos quartos = lista.get(i);
			if (quartos.getNome().equals(nome)) {
				resultados.add(quartos);				
			}
		}
		
		return resultados;
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void atualizar(Quartos quartos) {
		try {
			DaoQuartos.atualizar(quartos);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for (int i = 0; i < lista.size(); i++) {
			Quartos cliBusca = lista.get(i);
			if(cliBusca.getId() == quartos.getId()) {
				cliBusca.setNome(quartos.getNome());
				cliBusca.setNumeroQuarto(quartos.getNumeroQuarto());
				break;
			}
		}
	}
	
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public void deletar(Quartos quartos) {
		try {
			DaoQuartos.deletar(quartos);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
			
		
	}
	
	
}
