package co.conexia.lamejorcocina.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import co.conexia.lamejorcocina.domain.Cocinero;
import co.conexia.lamejorcocina.repository.CocineroRepository;

/**
 * Servicio que provee que implementa la lógica de negocio para la
 * administración de los {@link co.conexia.lamejorcocina.domain.Cocinero}.
 * 
 * @since 1.0.0
 * @author Jhonatan Zuluaga.
 * 
 */
@Stateless
public class CocineroService {

	@Inject
	private CocineroRepository cocineroRepository;

	public void create(Cocinero entity) {
		this.cocineroRepository.create(entity);
	}

	public List<Cocinero> findAll() {
		return this.cocineroRepository.findAll();
	}

}
