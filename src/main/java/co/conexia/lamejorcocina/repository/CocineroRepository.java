package co.conexia.lamejorcocina.repository;

import static javax.ejb.TransactionAttributeType.REQUIRED;
import static javax.ejb.TransactionManagementType.BEAN;

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
import co.conexia.lamejorcocina.domain.Cocinero;

/**
 * Repositorio que se encarga de administrar la entidad
 * {@link co.conexia.lamejorcocina.domain.Cocinero}.
 * 
 * @since 1.0.0
 * @author Jhonatan Zuluaga.
 * 
 */
@Stateless
@TransactionManagement(BEAN)
public class CocineroRepository {

	@Inject
	@LaMejorCocinaEntityManager
	private EntityManager lamejorcocinaEntityManager;

	@Resource
	private UserTransaction userTransaction;

	@TransactionAttribute(REQUIRED)
	public void create(Cocinero entity) {
		try {
			userTransaction.begin();

			lamejorcocinaEntityManager.persist(entity);

			userTransaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Cocinero> findAll() {
		return (List<Cocinero>) lamejorcocinaEntityManager.createNamedQuery(Constantes.NAMED_QUERY_COCINERO_ALL)
				.getResultList();
	}
}
