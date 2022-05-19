package tda.darkarmy.darkvalidator.usecase.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tda.darkarmy.darkvalidator.usecase.model.Video;

import javax.validation.Valid;

import static org.springframework.http.ResponseEntity.status;

@RequestMapping("/video")
@RestController
public class VideoController {

    @PostMapping("/upload")
    public ResponseEntity<?> uploadVideo(@Valid @ModelAttribute Video video){
        System.out.println("Video file size: "+video.getVideoFile().getSize()/(1024*1024));
        return status(200).body("Valid video file: "+video.getVideoFile().getContentType());
    }
}
