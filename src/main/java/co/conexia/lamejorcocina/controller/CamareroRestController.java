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

import co.conexia.lamejorcocina.domain.Camarero;
import co.conexia.lamejorcocina.service.CamareroService;

/**
 * Controlador REST que permite administrar las facturas.
 * 
 * @since 1.0.0
 * @author Jhonatan Zuluaga.
 * 
 */
@Path("/camarero")
@Produces(APPLICATION_JSON)
public class CamareroRestController {

	@Inject
	private CamareroService camareroService;

	@POST
	public Response registrarCamarero(final Camarero camarero) {
		this.camareroService.create(camarero);
		return Response.created(UriBuilder.fromResource(CamareroRestController.class)
				.path(String.valueOf(camarero.getIdCamarero())).build()).build();
	}

	@GET
	public Response consultarCamareros() {
		return Response.ok(this.camareroService.findAll()).status(Status.OK).type(MediaType.APPLICATION_JSON).build();
	}

}
