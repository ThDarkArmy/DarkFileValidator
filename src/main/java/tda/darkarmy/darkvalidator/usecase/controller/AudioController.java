package tda.darkarmy.darkvalidator.usecase.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tda.darkarmy.darkvalidator.usecase.model.Audio;

import javax.validation.Valid;

import static org.springframework.http.ResponseEntity.status;


@RequestMapping("/audio")
@RestController
public class AudioController {

    @PostMapping("/upload")
    public ResponseEntity<?> uploadAudio(@Valid @ModelAttribute Audio audio){
        return status(200).body("Valid audio file: "+audio.getAudioFile().getContentType());
    }
}
