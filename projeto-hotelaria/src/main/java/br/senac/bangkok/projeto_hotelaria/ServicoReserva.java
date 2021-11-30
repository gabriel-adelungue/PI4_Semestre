package br.senac.bangkok.projeto_hotelaria;

import java.time.LocalDate;
import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("reserva")
public class ServicoReserva {
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void fazerReserva (Reserva reserva) {
		try {
			DaoReserva.fazerReserva(reserva);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Reserva> gerarRelatorio(@QueryParam("dataInicioReserva") String dataInicioReserva, 
			@QueryParam("dataFimReserva") String dataFimReserva) {
		
		try {
			return DaoReserva.gerarRelatrio(LocalDate.parse(dataInicioReserva), LocalDate.parse(dataFimReserva));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
}
