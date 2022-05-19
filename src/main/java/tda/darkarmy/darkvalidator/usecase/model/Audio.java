package tda.darkarmy.darkvalidator.usecase.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
import tda.darkarmy.darkvalidator.validator.annotation.DarkFileType;

import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Audio {
    @NotNull
    @DarkFileType(fileType = {"audio", "audio/mp3"}, message="File must be a valid audio in mp3 or other format")
    private MultipartFile audioFile;
}
