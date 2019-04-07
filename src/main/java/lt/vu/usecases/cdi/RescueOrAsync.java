package lt.vu.usecases.cdi;

import javax.inject.Qualifier;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Anotacija (Qualifier), skirta: 1. Asinchroniniams komponentams 2. JPA klaidoms apdoroti (pvz.: OptimisticLockException)
 */
@Qualifier
@Retention(RUNTIME)
@Target({METHOD, FIELD, PARAMETER, TYPE})
public @interface RescueOrAsync {
}
