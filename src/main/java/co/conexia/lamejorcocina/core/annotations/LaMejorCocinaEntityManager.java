package co.conexia.lamejorcocina.core.annotations;

import java.lang.annotation.Documented;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.ElementType.PARAMETER;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

/**
 * Qualifier/Identificador para la conexión a la base de datos "lamejorcocina".
 * 
 * @since 1.0.0
 * @author Jhonatan Zuluaga.
 * 
 */
@Qualifier
@Documented
@Retention(RUNTIME)
@Target({ FIELD, METHOD, TYPE, PARAMETER })
public @interface LaMejorCocinaEntityManager {

}
