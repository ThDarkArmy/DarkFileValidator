package tda.darkarmy.darkvalidator.usecase.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BeanValidationException {
    private String field;
    private String message;

}