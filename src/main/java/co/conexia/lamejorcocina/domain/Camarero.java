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
 * The persistent class for the camarero database table.
 * 
 */
@Entity
@NamedQuery(name = Constantes.NAMED_QUERY_CAMARERO_ALL, query = "SELECT c FROM Camarero c")
public class Camarero extends BasePersonEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_camarero")
	private long idCamarero;

	public long getIdCamarero() {
		return idCamarero;
	}

	public void setIdCamarero(long idCamarero) {
		this.idCamarero = idCamarero;
	}

}