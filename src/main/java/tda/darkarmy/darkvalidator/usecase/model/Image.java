package tda.darkarmy.darkvalidator.usecase.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
import tda.darkarmy.darkvalidator.validator.annotation.DarkFileSize;
import tda.darkarmy.darkvalidator.validator.annotation.DarkFileType;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Image {
    @NotNull
    @DarkFileType(fileType = {"image/png", "image/jpeg"}, message="File must be a valid image in png or jpeg format")
    @DarkFileSize(min = "10KB", max = "100KB" , message = "Image size must be between 100 and 1000KB")
    private MultipartFile imageFile;
}
