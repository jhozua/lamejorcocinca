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

import co.conexia.lamejorcocina.domain.Cocinero;
import co.conexia.lamejorcocina.service.CocineroService;

/**
 * Controlador REST que permite administrar los cocineros.
 * 
 * @since 1.0.0
 * @author Jhonatan Zuluaga.
 * 
 */
@Path("/cocinero")
@Produces(APPLICATION_JSON)
public class CocineroRestController {

	@Inject
	private CocineroService cocineroService;

	@POST
	public Response registrarCocinero(final Cocinero cocinero) {
		this.cocineroService.create(cocinero);
		return Response.created(UriBuilder.fromResource(CocineroRestController.class)
				.path(String.valueOf(cocinero.getIdCocinero())).build()).build();
	}

	@GET
	public Response consultarCocineros() {
		return Response.ok(this.cocineroService.findAll()).status(Status.OK).type(MediaType.APPLICATION_JSON).build();
	}

}
