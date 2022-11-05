package com.eai.project.evaluation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EvaluationService {
    private final EvaluationRepository evaluationRepository;

    @Autowired
    public EvaluationService(EvaluationRepository evaluationRepository) {
        this.evaluationRepository = evaluationRepository;
    }

    public Evaluation saveEvaluation(Evaluation evaluation) {
        evaluation.setLastUpdated(new Date());
        return evaluationRepository.save(evaluation);
    }

    public Optional<Evaluation> getEvaluationById(Long id) {
        return evaluationRepository.findById(id);
    }

    public List<Evaluation> getAllEvaluations() {
        return evaluationRepository.findAll();
    }

    public boolean deleteEvaluation(Long id) {
        evaluationRepository.deleteById(id);
        return true;
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
            throw new IllegalStateException("Evaluation with id " + evaluation.getId() + " does not exist");
        }
    }
}
