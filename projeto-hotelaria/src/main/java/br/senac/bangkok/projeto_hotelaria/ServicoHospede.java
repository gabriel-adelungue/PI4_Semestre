package br.senac.bangkok.projeto_hotelaria;


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

@Path("hospede")
public class ServicoHospede {
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void inserir(Hospede hospede) {
		try {
			DaoHospede.inserir(hospede);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Hospede> listar(){	
		try {
			return DaoHospede.listar();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void atualizar(Hospede hospede) {
		try {
			DaoHospede.atualizar(hospede);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public void excluir(@QueryParam("id")int id) {
		try {
			DaoHospede.excluir(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("pesquisar")
	public List<Hospede> pesquisar(@QueryParam("nome") String nome){
		try {
			return DaoHospede.pesquisar(nome);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
