package co.conexia.lamejorcocina.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import co.conexia.lamejorcocina.domain.Mesa;
import co.conexia.lamejorcocina.repository.MesaRepository;

/**
 * Servicio que provee que implementa la lógica de negocio para la
 * administración de {@link co.conexia.lamejorcocina.domain.Mesa}.
 * 
 * @since 1.0.0
 * @author Jhonatan Zuluaga.
 * 
 */
@Stateless
public class MesaService {

	@Inject
	private MesaRepository mesaRepository;

	public void create(Mesa entity) {
		this.mesaRepository.create(entity);
	}

	public List<Mesa> findAll() {
		return this.mesaRepository.findAll();
	}

}
