package com.eai.project.evaluation;

import com.eai.project.evaluator.Evaluator;
import com.eai.project.group.Group;
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
    public ResponseEntity<Evaluation> saveEvaluation(@RequestBody EvaluationModel evaluationModel) {
        Evaluation evaluation = Evaluation.builder()
                .evaluator(Evaluator.builder().id(evaluationModel.getEvaluatorId()).build())
                .group(Group.builder().id(evaluationModel.getGroupId()).build())
                .criteria1(evaluationModel.getCriteria1())
                .criteria2(evaluationModel.getCriteria2())
                .build();
        return new ResponseEntity<>(evaluationService.saveEvaluation(evaluation), HttpStatus.OK);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<Iterable<Evaluation>> getAllEvaluations() {
        return new ResponseEntity<>(evaluationService.fetchAllEvaluations(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<Evaluation>> getEvaluationById(@PathVariable String id) {
        return new ResponseEntity<>(evaluationService.fetchEvaluationById(Long.valueOf(id)), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> deleteEvaluationById(@PathVariable String id) {
        return new ResponseEntity<>(evaluationService.deleteEvaluation(Long.valueOf(id)), HttpStatus.OK);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<Evaluation> updateEvaluation(@RequestBody EvaluationModel evaluationModel) {
        Evaluation evaluation = Evaluation.builder()
                .evaluator(Evaluator.builder().id(evaluationModel.getEvaluatorId()).build())
                .group(Group.builder().id(evaluationModel.getGroupId()).build())
                .criteria1(evaluationModel.getCriteria1())
                .criteria2(evaluationModel.getCriteria2())
                .build();
        return new ResponseEntity<>(evaluationService.updateEvaluation(evaluation), HttpStatus.OK);
    }
}
