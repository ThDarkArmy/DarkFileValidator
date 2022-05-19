package tda.darkarmy.darkvalidator.validator.annotation;

import tda.darkarmy.darkvalidator.validator.constraintvalidator.DarkFileSizeValidator;
import tda.darkarmy.darkvalidator.validator.constraintvalidator.DarkFileTypeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Documented
@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = DarkFileSizeValidator.class)
public @interface DarkFileSize {
    String min() default "1KB";
    String max() default "1TB";

    String message() default "File size must be in range 100KB to 1000000000KB";

    Class<?> [] groups() default {};

    Class<? extends Payload> [] payload() default {};
}
