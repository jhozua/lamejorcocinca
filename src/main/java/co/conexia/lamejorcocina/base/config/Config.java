package co.conexia.lamejorcocina.base.config;

import javax.ejb.Singleton;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.conexia.lamejorcocina.core.annotations.LaMejorCocinaEntityManager;

/**
 * Se configuran aspectos generales de la aplicación.
 * 
 * @since 1.0.0
 * @author Jhonatan Zuluaga.
 * 
 */
@Singleton
public class Config {

	@Produces
	@LaMejorCocinaEntityManager
	@PersistenceContext(unitName = "lamejorcocinaDS")
	private static EntityManager lamejorcocinaEntityManager;

}
