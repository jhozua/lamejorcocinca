package co.conexia.lamejorcocina.core;

import java.text.DateFormatSymbols;

/**
 * Clase utilitaria para el manejo de fechas en el API.
 * 
 * @since 1.0.0
 * @author Jhonatan Zuluaga.
 * 
 */
public class DateUtils {

	/**
	 * Clase encargada de convertir la representacion del mes númerico en texto.
	 * 
	 * @param month entero del mes.
	 * @return texto del mes.
	 */
	public static String getMonth(int month) {
		return new DateFormatSymbols().getMonths()[month - 1];
	}
}
