package tda.darkarmy.darkvalidator.usecase.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
import tda.darkarmy.darkvalidator.validator.annotation.DarkFileType;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Resume {
    @NotNull
    @DarkFileType(fileType = {"pdf", "application/vnd.openxmlformats-officedocument.wordprocessingml.document"}, message="File must be a valid pdf or word file")
    private MultipartFile resumeFile;

}
