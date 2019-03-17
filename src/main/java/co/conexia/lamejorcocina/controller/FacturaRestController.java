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

import co.conexia.lamejorcocina.domain.Factura;
import co.conexia.lamejorcocina.service.FacturaService;

/**
 * Controlador REST que permite administrar las facturas.
 * 
 * @since 1.0.0
 * @author Jhonatan Zuluaga.
 * 
 */
@Path("/factura")
@Produces(APPLICATION_JSON)
public class FacturaRestController {

	@Inject
	private FacturaService facturaService;

	@POST
	public Response registrarFactura(final Factura factura) {
		this.facturaService.create(factura);
		return Response.created(UriBuilder.fromResource(FacturaRestController.class)
				.path(String.valueOf(factura.getIdFactura())).build()).build();
	}

	@GET
	public Response consultarFacturacionCamarero() {
		return Response.ok(this.facturaService.findAllFacturacionCamarero()).status(Status.OK)
				.type(MediaType.APPLICATION_JSON).build();
	}

	@GET
	@Path("/cliente")
	public Response consultarFacturacionCliente() {
		return Response.ok(this.facturaService.findAllFacturacionCliente()).status(Status.OK)
				.type(MediaType.APPLICATION_JSON).build();
	}
}
