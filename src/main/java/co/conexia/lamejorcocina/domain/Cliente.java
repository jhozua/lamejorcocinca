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
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@NamedQuery(name = Constantes.NAMED_QUERY_CLIENTE_ALL, query = "SELECT c FROM Cliente c")
public class Cliente extends BasePersonEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	private long idCliente;

	public long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}

}