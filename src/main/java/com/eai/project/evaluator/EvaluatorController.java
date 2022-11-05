package com.eai.project.evaluator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/evaluator")
public class EvaluatorController {
    private final EvaluatorService evaluatorService;

    @Autowired
    public EvaluatorController(EvaluatorService evaluatorService) {
        this.evaluatorService = evaluatorService;
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Evaluator> saveEvaluator(Evaluator evaluator) {
        return new ResponseEntity<>(evaluatorService.saveEvaluator(evaluator), HttpStatus.OK);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Evaluator>> getAllEvaluators() {
        return new ResponseEntity<>(evaluatorService.getAllEvaluators(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<Evaluator>> getEvaluatorById(@PathVariable String id) {
        return new ResponseEntity<>(evaluatorService.getEvaluatorById(Long.valueOf(id)), HttpStatus.OK);
    }

}

