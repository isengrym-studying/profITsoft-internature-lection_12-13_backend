package ua.klieshchunov.lection_1213_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.klieshchunov.lection_1213_backend.service.MathExampleService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/math/examples", produces = MediaType.APPLICATION_JSON_VALUE)
public class MathExamplesController {
    private final MathExampleService mathExampleService;

    @Autowired
    public MathExamplesController(MathExampleService mathExampleService) {
        this.mathExampleService = mathExampleService;
    }

    @GetMapping
    public ResponseEntity<String[]> getMathExamples(@RequestParam(value = "count", defaultValue = "1") int examplesQuantity) {
        String[] examples = mathExampleService.generateExamplesArray(examplesQuantity);
        return new ResponseEntity<>(examples, HttpStatus.OK);
    }
}
