package co.conexia.lamejorcocina.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import co.conexia.lamejorcocina.core.Constantes;

/**
 * The persistent class for the mesa database table.
 * 
 */
@Entity
@NamedQuery(name = Constantes.NAMED_QUERY_MESA_ALL, query = "SELECT m FROM Mesa m")
public class Mesa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_mesa")
	private long idMesa;

	@Column(name = "num_max_comensales")
	private Integer numMaxComensales;

	private Integer ubicacion;

	public Mesa() {
	}

	public long getIdMesa() {
		return this.idMesa;
	}

	public void setIdMesa(long idMesa) {
		this.idMesa = idMesa;
	}

	public Integer getNumMaxComensales() {
		return this.numMaxComensales;
	}

	public void setNumMaxComensales(Integer numMaxComensales) {
		this.numMaxComensales = numMaxComensales;
	}

	public Integer getUbicacion() {
		return this.ubicacion;
	}

	public void setUbicacion(Integer ubicacion) {
		this.ubicacion = ubicacion;
	}

}