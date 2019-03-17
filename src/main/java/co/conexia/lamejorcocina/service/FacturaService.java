package co.conexia.lamejorcocina.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import co.conexia.lamejorcocina.domain.DetalleFactura;
import co.conexia.lamejorcocina.domain.DetalleFacturaPK;
import co.conexia.lamejorcocina.domain.Factura;
import co.conexia.lamejorcocina.domain.FacturacionCamarero;
import co.conexia.lamejorcocina.domain.FacturacionCliente;
import co.conexia.lamejorcocina.repository.DetalleFacturaRepository;
import co.conexia.lamejorcocina.repository.FacturaRepository;

/**
 * Servicio que provee que implementa la lógica de negocio para la
 * administración de las {@link co.conexia.lamejorcocina.domain.Factura}.
 * {@link co.conexia.lamejorcocina.domain.FacturacionCamarero}.
 * {@link co.conexia.lamejorcocina.domain.FacturacionCliente}.
 * 
 * @since 1.0.0
 * @author Jhonatan Zuluaga.
 * 
 */
@Stateless
public class FacturaService {

	@Inject
	private FacturaRepository facturaRepository;

	@Inject
	private DetalleFacturaRepository detalleFacturaRepository;

	public void create(Factura entity) {

		List<DetalleFactura> detallesFactura = new ArrayList<DetalleFactura>();
		detallesFactura = entity.getDetalleFacturas();
		entity.setDetalleFacturas(null);

		this.facturaRepository.create(entity);

		DetalleFacturaPK idDetalleFacturaPK = new DetalleFacturaPK();
		idDetalleFacturaPK.setIdFactura(entity.getIdFactura());

		for (DetalleFactura detalleFactura : detallesFactura) {
			detalleFactura.setId(idDetalleFacturaPK);
			this.detalleFacturaRepository.create(detalleFactura);
		}

	}

	public List<FacturacionCamarero> findAllFacturacionCamarero() {
		return this.facturaRepository.findAllFacturacionCamarero();
	}

	public List<FacturacionCliente> findAllFacturacionCliente() {
		return this.facturaRepository.findAllFacturacionCliente();
	}

}
