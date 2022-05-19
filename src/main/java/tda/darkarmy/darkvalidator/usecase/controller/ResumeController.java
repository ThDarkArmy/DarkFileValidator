package tda.darkarmy.darkvalidator.usecase.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tda.darkarmy.darkvalidator.usecase.model.Resume;

import javax.validation.Valid;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/resume")
public class ResumeController {


    @PostMapping("/upload")
    public ResponseEntity<?> uploadResume(@Valid @ModelAttribute Resume resume){
        System.out.println(resume.getResumeFile().getContentType());
        return status(200).body("Valid pdf file: "+resume.getResumeFile().getContentType());
    }
}
