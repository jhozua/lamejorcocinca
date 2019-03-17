package co.conexia.lamejorcocina.repository;

import static javax.ejb.TransactionAttributeType.REQUIRED;
import static javax.ejb.TransactionManagementType.BEAN;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionManagement;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

import co.conexia.lamejorcocina.core.Constantes;
import co.conexia.lamejorcocina.core.annotations.LaMejorCocinaEntityManager;
import co.conexia.lamejorcocina.domain.Factura;
import co.conexia.lamejorcocina.domain.FacturacionCamarero;
import co.conexia.lamejorcocina.domain.FacturacionCliente;

/**
 * Repositorio que se encarga de administrar la entidad
 * {@link co.conexia.lamejorcocina.domain.Factura}.
 * {@link co.conexia.lamejorcocina.domain.FacturacionCamarero}.
 * {@link co.conexia.lamejorcocina.domain.FacturacionCliente}.
 * 
 * @since 1.0.0
 * @author Jhonatan Zuluaga.
 * 
 */
@Stateless
@TransactionManagement(BEAN)
public class FacturaRepository {

	@Inject
	@LaMejorCocinaEntityManager
	private EntityManager lamejorcocinaEntityManager;

	@Resource
	private UserTransaction userTransaction;

	@TransactionAttribute(REQUIRED)
	public void create(Factura entity) {
		try {
			userTransaction.begin();

			lamejorcocinaEntityManager.persist(entity);

			userTransaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Factura> findAll() {
		return (List<Factura>) lamejorcocinaEntityManager.createNamedQuery(Constantes.NAMED_QUERY_FACTURA_ALL)
				.getResultList();
	}

	public List<FacturacionCamarero> findAllFacturacionCamarero() {
		return (List<FacturacionCamarero>) lamejorcocinaEntityManager.createQuery(
				"SELECT NEW co.conexia.lamejorcocina.repository.FacturacionCamarero(cm.nombre , cm.apellido1, SUM(df.importe), extract('month' from f.fechaFactura)) "
						+ "FROM Factura f JOIN f.camarero cm JOIN f.detalleFacturas df "
						+ "GROUP BY cm.nombre, cm.apellido1, extract('month' from f.fechaFactura) ORDER BY SUM(df.importe) DESC",
				FacturacionCamarero.class).getResultList();
	}

	public List<FacturacionCliente> findAllFacturacionCliente() {
		return (List<FacturacionCliente>) lamejorcocinaEntityManager
				.createQuery(
						"SELECT NEW co.conexia.lamejorcocina.repository.FacturacionCliente(c.nombre , c.apellido1, SUM(df.importe)) "
								+ "FROM Factura f JOIN f.cliente c JOIN f.detalleFacturas df "
								+ "GROUP BY c.nombre, c.apellido1 HAVING SUM(df.importe) >= :valorTotal ORDER BY SUM(df.importe) DESC",
						FacturacionCliente.class)
				.setParameter("valorTotal", new BigDecimal(Constantes.VALOR_TOTAL_GASTO_CLIENTE)).getResultList();
	}
}
