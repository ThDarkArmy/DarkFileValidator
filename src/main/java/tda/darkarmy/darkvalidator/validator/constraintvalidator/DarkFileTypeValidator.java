package tda.darkarmy.darkvalidator.validator.constraintvalidator;

import org.springframework.web.multipart.MultipartFile;
import tda.darkarmy.darkvalidator.validator.annotation.DarkFileType;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class DarkFileTypeValidator implements ConstraintValidator<DarkFileType, MultipartFile> {
    private String[] fileType;
    @Override
    public void initialize(DarkFileType constraintAnnotation) {
        this.fileType = constraintAnnotation.fileType();
    }

    @Override
    public boolean isValid(MultipartFile file, ConstraintValidatorContext constraintValidatorContext) {
        String typeFirst = Objects.requireNonNull(file.getContentType()).split("/")[0];
        String typeSecond = Objects.requireNonNull(file.getContentType()).split("/")[1];

        List<String> fileTypeList = Arrays.asList(fileType);
        return fileTypeList.contains(typeFirst) || fileTypeList.contains(typeSecond) || fileTypeList.contains(file.getContentType());

    }
}
