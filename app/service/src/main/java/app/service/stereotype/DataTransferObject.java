package app.service.stereotype;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Identifies a type as fulfilling the architectural role of a data transfer
 * object ("DTO"). Some expected features of DTOs:
 * 
 * <ul>
 * <li>DTOs are void of any behavior or business logic.</li>
 * <li>DTOs only carry data.</li>
 * <li>DTOs are usually serializable.</li>
 * <li>DTOs have a design that is driven by use case, not the domain.</li>
 * </ul>
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface DataTransferObject {
}
