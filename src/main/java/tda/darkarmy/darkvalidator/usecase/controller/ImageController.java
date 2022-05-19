package tda.darkarmy.darkvalidator.usecase.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tda.darkarmy.darkvalidator.usecase.model.Image;

import javax.validation.Valid;

import static org.springframework.http.ResponseEntity.status;

@RequestMapping("/image")
@RestController
public class ImageController {

    @PostMapping("/upload")
    public ResponseEntity<?> uploadImage(@Valid @ModelAttribute Image image){
        System.out.println("File Size: "+ image.getImageFile().getSize());
        return status(200).body("Valid image file: "+image.getImageFile().getContentType());
    }
}
