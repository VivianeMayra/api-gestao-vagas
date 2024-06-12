package br.com.vivianemayra.gestao_vagas.candidate.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import br.com.vivianemayra.gestao_vagas.candidate.CandidateRepository;
import br.com.vivianemayra.gestao_vagas.candidate.entity.ApplyJobEntity;
import br.com.vivianemayra.gestao_vagas.candidate.repository.ApplyJobRepository;
import br.com.vivianemayra.gestao_vagas.company.repositories.JobRepository;
import br.com.vivianemayra.gestao_vagas.exceptions.JobNotFoundException;
import br.com.vivianemayra.gestao_vagas.exceptions.UserNotFoundException;

@Service
public class ApplyJobCandidateUseCase {

  @Autowired
  private CandidateRepository candidateRepository;

  @Autowired
  private JobRepository jobRepository;

  @Autowired
  private ApplyJobRepository applyJobRepository;

  public ApplyJobEntity execute(UUID idCandidate, UUID idJob) {

    // Validando se meu candidato existe no meu banco
    this.candidateRepository.findById(idCandidate).orElseThrow(() -> {
      throw new UserNotFoundException();
    });

    // Validando se a vaga existe no meu banco
    this.jobRepository.findById(idJob).orElseThrow(() -> {
      throw new JobNotFoundException();
    });

    // Candidato se inscreve na vaga

    var applyJob = ApplyJobEntity.builder().candidateId(idCandidate).jobId(idJob).build();

    applyJob = applyJobRepository.save(applyJob);

    return applyJob;

  }

}
