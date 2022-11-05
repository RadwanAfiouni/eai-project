package com.eai.project.evaluation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/evaluation")
public class EvaluationController {
    private final EvaluationService evaluationService;

    @Autowired
    public EvaluationController(EvaluationService evaluationService) {
        this.evaluationService = evaluationService;
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Evaluation> saveEvaluation(Evaluation evaluation) {
        return new ResponseEntity<>(evaluationService.saveEvaluation(evaluation), HttpStatus.OK);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<Iterable<Evaluation>> getAllEvaluations() {
        return new ResponseEntity<>(evaluationService.getAllEvaluations(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<Evaluation>> getEvaluationById(@PathVariable String id) {
        return new ResponseEntity<>(evaluationService.getEvaluationById(Long.valueOf(id)), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> deleteEvaluationById(@PathVariable String id) {
        return new ResponseEntity<>(evaluationService.deleteEvaluation(Long.valueOf(id)), HttpStatus.OK);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<Evaluation> updateEvaluation(@RequestBody Evaluation evaluation) {
        return new ResponseEntity<>(evaluationService.updateEvaluation(evaluation), HttpStatus.OK);
    }
}
