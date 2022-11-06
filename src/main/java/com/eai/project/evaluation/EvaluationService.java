package com.eai.project.evaluation;

import com.eai.project.evaluator.Evaluator;
import com.eai.project.evaluator.EvaluatorService;
import com.eai.project.group.Group;
import com.eai.project.group.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EvaluationService {
    private final EvaluationRepository evaluationRepository;
    private final EvaluatorService evaluatorService;
    private final GroupService groupService;

    @Autowired
    public EvaluationService(EvaluationRepository evaluationRepository, EvaluatorService evaluatorService, GroupService groupService) {
        this.evaluationRepository = evaluationRepository;
        this.evaluatorService = evaluatorService;
        this.groupService = groupService;
    }

    public Evaluation saveEvaluation(Evaluation evaluation) {
        Optional<Evaluator> evaluator = evaluatorService.fetchEvaluatorById(evaluation.getEvaluator().getId());
        Optional<Group> group = groupService.fetchGroupById(evaluation.getGroup().getId());

        if (evaluator.isEmpty()) {
            throw new IllegalArgumentException("Evaluator with id " + evaluation.getEvaluator().getId() + " does not exist");
        }

        if (group.isEmpty()) {
            throw new IllegalArgumentException("Group with id " + evaluation.getGroup().getId() + " does not exist");
        }

        evaluation.setLastUpdated(new Date());
        evaluation.setEvaluator(evaluator.get());
        evaluation.setGroup(group.get());

        return evaluationRepository.save(evaluation);
    }

    public Optional<Evaluation> fetchEvaluationById(Long id) {
        return evaluationRepository.findById(id);
    }

    public List<Evaluation> fetchAllEvaluations() {
        return evaluationRepository.findAll();
    }

    public boolean deleteEvaluation(Long id) {
        if (evaluationRepository.existsById(id)) {
            evaluationRepository.deleteById(id);
            return true;
        } else {
            throw new IllegalArgumentException("Evaluation with id " + id + " does not exist");
        }
    }

    public Evaluation updateEvaluation(Evaluation evaluation) {
        Optional<Evaluation> evaluationOptional = evaluationRepository.findById(evaluation.getId());
        if (evaluationOptional.isPresent()) {
            Evaluation evaluationToUpdate = evaluationOptional.get();
            evaluationToUpdate.setEvaluator(evaluation.getEvaluator());
            evaluationToUpdate.setGroup(evaluation.getGroup());
            evaluationToUpdate.setLastUpdated(new Date());
            evaluationToUpdate.setCriteria1(evaluation.getCriteria1());
            evaluationToUpdate.setCriteria2(evaluation.getCriteria2());

            return evaluationRepository.save(evaluation);
        } else {
            throw new IllegalArgumentException("Evaluation with id " + evaluation.getId() + " does not exist");
        }
    }
}
