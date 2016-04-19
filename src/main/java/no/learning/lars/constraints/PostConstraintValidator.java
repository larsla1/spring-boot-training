package no.learning.lars.constraints;

import no.learning.lars.validator.PostConstraintValidatorImpl;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Constraint validation annotation of a Post object
 */
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=PostConstraintValidatorImpl.class)
public @interface PostConstraintValidator {
    String message() default "no.learning.lars";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
