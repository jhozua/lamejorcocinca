package co.conexia.lamejorcocina.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import co.conexia.lamejorcocina.domain.Camarero;
import co.conexia.lamejorcocina.repository.CamareroRepository;

/**
 * Servicio que provee que implementa la lógica de negocio para la
 * administración de los {@link co.conexia.lamejorcocina.domain.Camarero}.
 * 
 * @since 1.0.0
 * @author Jhonatan Zuluaga.
 * 
 */
@Stateless
public class CamareroService {

	@Inject
	private CamareroRepository camareroRepository;

	public void create(Camarero entity) {
		this.camareroRepository.create(entity);
	}

	public List<Camarero> findAll() {
		return this.camareroRepository.findAll();
	}

}
