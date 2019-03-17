package co.conexia.lamejorcocina.core;

/**
 * Clase que se encarega de contener las constantes utilizadas en el API.
 * 
 * @since 1.0.0
 * @author Jhonatan Zuluaga.
 * 
 */
public class Constantes {

	/** Constantes para las consultas JPQL de Factura */

	public static final String NAMED_QUERY_FACTURA_ALL = "Factura.findAll";

	/** Constantes para las consultas JPQL de Camarero */

	public static final String NAMED_QUERY_CAMARERO_ALL = "Camarero.findAll";

	/** Constantes para las consultas JPQL de Cocinero */

	public static final String NAMED_QUERY_COCINERO_ALL = "Cocinero.findAll";

	/** Constantes para las consultas JPQL de Cliente */

	public static final String NAMED_QUERY_CLIENTE_ALL = "Cliente.findAll";

	/** Constantes para las consultas JPQL de Mesa */

	public static final String NAMED_QUERY_MESA_ALL = "Mesa.findAll";

	/** Constantes de párametros */

	public static final int VALOR_TOTAL_GASTO_CLIENTE = 100000;
}
