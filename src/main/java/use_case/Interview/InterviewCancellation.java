package java.use_case.Interview;

import java.model.common.CandidatDTO;
import java.model.common.InterviewDTO;
import java.model.interview.Interview;

public class InterviewCancellation {
    private final Interview interview;

    public InterviewCancellation(InterviewDTO interviewDTO, CandidatDTO candidatDTO) {
        this.interview = interviewDTO.DtoToInterview();
    }

    // GIVEN : Un entretien planifié pour demain
    // AND : Le candidat appelant pour annuler cet entretien
    // WHEN : Le candidat demande à annuler cet entretien à cette date
    // THEN : L'entretien est mis à l'état Annulé

    public void cancelInterview(){
        interview.cancelInterview();
    }
}