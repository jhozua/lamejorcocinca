package co.conexia.lamejorcocina.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the detalle_factura database table.
 * 
 */
@Entity
@Table(name = "detalle_factura")
@NamedQuery(name = "DetalleFactura.findAll", query = "SELECT d FROM DetalleFactura d")
public class DetalleFactura implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DetalleFacturaPK id;

	private BigDecimal importe;

	private String plato;

	// bi-directional many-to-one association to Cocinero
	@ManyToOne
	@JoinColumn(name = "id_cocinero")
	private Cocinero cocinero;

	// bi-directional many-to-one association to Factura
	@ManyToOne
	@JoinColumn(name = "id_factura", nullable = false, insertable = false, updatable = false)
	private Factura factura;

	public DetalleFactura() {
	}

	public DetalleFacturaPK getId() {
		return this.id;
	}

	public void setId(DetalleFacturaPK id) {
		this.id = id;
	}

	public BigDecimal getImporte() {
		return this.importe;
	}

	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}

	public String getPlato() {
		return this.plato;
	}

	public void setPlato(String plato) {
		this.plato = plato;
	}

	public Cocinero getCocinero() {
		return this.cocinero;
	}

	public void setCocinero(Cocinero cocinero) {
		this.cocinero = cocinero;
	}

	public Factura getFactura() {
		return this.factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

}