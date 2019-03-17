package co.conexia.lamejorcocina.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class FacturacionCliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nombre;

	private BigDecimal gastos;

	public FacturacionCliente(String nombre, String apellido, BigDecimal gastos) {
		super();
		this.nombre = nombre + " " + apellido;
		this.gastos = gastos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getGastos() {
		return gastos;
	}

	public void setGastos(BigDecimal gastos) {
		this.gastos = gastos;
	}

}
