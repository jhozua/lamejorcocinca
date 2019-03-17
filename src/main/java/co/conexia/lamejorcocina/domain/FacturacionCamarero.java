package co.conexia.lamejorcocina.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import co.conexia.lamejorcocina.core.DateUtils;

public class FacturacionCamarero implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nombre;

	private BigDecimal totalFacturado;

	private String mesFacturado;

	public FacturacionCamarero(String nombre, String apellido, BigDecimal totalFacturado, Integer mesFacturado) {
		super();
		this.nombre = nombre + " " + apellido;
		this.totalFacturado = totalFacturado;
		this.mesFacturado = mesFacturado != null ? DateUtils.getMonth(mesFacturado) : "";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMesFacturado() {
		return mesFacturado;
	}

	public void setMesFacturado(String mesFacturado) {
		this.mesFacturado = mesFacturado;
	}

	public BigDecimal getTotalFacturado() {
		return totalFacturado;
	}

	public void setTotalFacturado(BigDecimal totalFacturado) {
		this.totalFacturado = totalFacturado;
	}

}
