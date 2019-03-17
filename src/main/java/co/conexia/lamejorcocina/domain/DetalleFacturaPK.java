package co.conexia.lamejorcocina.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * The primary key class for the detalle_factura database table.
 * 
 */
@Embeddable
public class DetalleFacturaPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "id_factura", insertable = false, updatable = false)
	private long idFactura;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_detalle_factura")
	private long idDetalleFactura;

	public DetalleFacturaPK() {
	}

	public long getIdFactura() {
		return this.idFactura;
	}

	public void setIdFactura(long idFactura) {
		this.idFactura = idFactura;
	}

	public long getIdDetalleFactura() {
		return this.idDetalleFactura;
	}

	public void setIdDetalleFactura(long idDetalleFactura) {
		this.idDetalleFactura = idDetalleFactura;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DetalleFacturaPK)) {
			return false;
		}
		DetalleFacturaPK castOther = (DetalleFacturaPK) other;
		return (this.idFactura == castOther.idFactura) && (this.idDetalleFactura == castOther.idDetalleFactura);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idFactura ^ (this.idFactura >>> 32)));
		hash = hash * prime + ((int) (this.idDetalleFactura ^ (this.idDetalleFactura >>> 32)));

		return hash;
	}
}