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
public class Video {

    @NotNull
    @DarkFileType(fileType = {"video/x-matroska","video/webm", "video/mp4"}, message="File must be a valid video in mp4 or mkv or webm format")
    @DarkFileSize(min = "10MB", max = "20MB" , message = "Video size must be between 10MB and 20MB")
    private MultipartFile videoFile;
}
