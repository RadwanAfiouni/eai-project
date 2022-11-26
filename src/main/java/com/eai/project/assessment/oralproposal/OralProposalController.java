package com.eai.project.assessment.oralproposal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/assessments/oralproposal")
public class OralProposalController {
    private final OralProposalService oralProposalService;

    @Autowired
    public OralProposalController(OralProposalService oralProposalService) {
        this.oralProposalService = oralProposalService;
    }

    @PostMapping("/save")
    public OralProposal saveOralProposal(@RequestBody OralProposalModel oralProposalModel) {
        return oralProposalService.saveOralProposal(oralProposalService.modelToEntity(oralProposalModel));
    }

    @GetMapping("/all")
    public List<OralProposal> getAllOralProposals() {
        return oralProposalService.getAllOralProposals();
    }

    @GetMapping("/{id}")
    public Optional<OralProposal> getOralProposalById(@PathVariable Long id) {
        return oralProposalService.getOralProposalById(id);
    }

}
