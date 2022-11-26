package com.eai.project.assessment.oralproposal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OralProposalRepository extends JpaRepository<OralProposal, Long> {
}
