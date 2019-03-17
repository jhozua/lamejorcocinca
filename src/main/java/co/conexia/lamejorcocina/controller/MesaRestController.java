package co.conexia.lamejorcocina.controller;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;

import co.conexia.lamejorcocina.domain.Mesa;
import co.conexia.lamejorcocina.service.MesaService;

/**
 * Controlador REST que permite administrar las mesas.
 * 
 * @since 1.0.0
 * @author Jhonatan Zuluaga.
 * 
 */
@Path("/mesa")
@Produces(APPLICATION_JSON)
public class MesaRestController {

	@Inject
	private MesaService mesaService;

	/**
	 * @param offeradmincampaign
	 * @return
	 */
	@POST
	public Response registrarMesa(final Mesa mesa) {
		this.mesaService.create(mesa);
		return Response.created(
				UriBuilder.fromResource(MesaRestController.class).path(String.valueOf(mesa.getIdMesa())).build())
				.build();
	}

	@GET
	public Response consultarMesas() {
		return Response.ok(this.mesaService.findAll()).status(Status.OK).type(MediaType.APPLICATION_JSON).build();
	}

}
