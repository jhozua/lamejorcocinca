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
 * The persistent class for the cocinero database table.
 * 
 */
@Entity
@NamedQuery(name = Constantes.NAMED_QUERY_COCINERO_ALL, query = "SELECT c FROM Cocinero c")
public class Cocinero extends BasePersonEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cocinero")
	private long idCocinero;

	public long getIdCocinero() {
		return idCocinero;
	}

	public void setIdCocinero(long idCocinero) {
		this.idCocinero = idCocinero;
	}

}