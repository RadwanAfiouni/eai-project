package com.eai.project.evaluator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EvaluatorService {
    private final EvaluatorRepository evaluatorRepository;

    @Autowired
    public EvaluatorService(EvaluatorRepository evaluatorRepository) {
        this.evaluatorRepository = evaluatorRepository;
    }

    public Evaluator saveEvaluator(Evaluator evaluator) {
        return evaluatorRepository.save(evaluator);
    }

    public Optional<Evaluator> fetchEvaluatorById(Long id) {
        return evaluatorRepository.findById(id);
    }

    public List<Evaluator> fetchAllEvaluators() {
        return evaluatorRepository.findAll();
    }

}
