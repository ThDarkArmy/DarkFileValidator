package tda.darkarmy.darkvalidator.validator.constraintvalidator;

import org.springframework.web.multipart.MultipartFile;
import tda.darkarmy.darkvalidator.validator.annotation.DarkFileSize;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DarkFileSizeValidator implements ConstraintValidator<DarkFileSize, MultipartFile> {
    private String min;
    private String max;

    @Override
    public void initialize(DarkFileSize constraintAnnotation) {
        this.min = constraintAnnotation.min();
        this.max = constraintAnnotation.max();
    }

    @Override
    public boolean isValid(MultipartFile file, ConstraintValidatorContext constraintValidatorContext) {
        long fileSizeMin;
        long fileSizeMax;

        if(min.contains("KB")){
            fileSizeMin = (long)(file.getSize()/1024);
        }else if(min.contains("MB")){
            fileSizeMin = (long)(file.getSize()/(1024*1024));
        }else if(min.contains("GB")){
            fileSizeMin = (long)(file.getSize()/(1024*1024*1024));
        }else if(min.contains("TB")){
            fileSizeMin = (long)(file.getSize()/(1024*1024*1024));
        }else{
            fileSizeMin = file.getSize();
        }

        if(max.contains("KB")){
            fileSizeMax = (long)(file.getSize()/1024);
        }else if(max.contains("MB")){
            fileSizeMax = (long)(file.getSize()/(1024*1024));
        }else if(max.contains("GB")){
            fileSizeMax = (long)(file.getSize()/(1024*1024*1024));
        }else if(max.contains("TB")){
            fileSizeMax = (long)(file.getSize()/(1024*1024*1024));
        }else{
            fileSizeMax = file.getSize();
        }

        return fileSizeMin >= Long.parseLong(min.substring(0, min.length() - 2)) && fileSizeMax <= Long.parseLong(max.substring(0, max.length() - 2));
    }
}
