package use_case.Interview;


import model.common.CandidatDTO;
import model.common.InterviewDTO;
import model.interview.Interview;

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