package tda.darkarmy.darkvalidator.validator.annotation;


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
@Constraint(validatedBy = DarkFileTypeValidator.class)
public @interface DarkFileType {

    String[] fileType() default {"text", "video", "image", "pdf", "octet-stream", "audio", "application"};

    String message() default "{typeValidationMessage}";

    Class<?> [] groups() default {};

    Class<? extends Payload> [] payload() default {};
}
