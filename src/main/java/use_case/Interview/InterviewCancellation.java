package java.use_case.Interview;

import model.interview.Interview;

public class InterviewCancellation {
    private final Interview interview;

    public InterviewCancellation(Interview interview) {
        this.interview = interview;
    }

    // GIVEN : Un entretien planifié pour demain
    // AND : Le candidat appelant pour annuler cet entretien
    // WHEN : Le candidat demande à annuler cet entretien à cette date
    // THEN : L'entretien est mise à l'état Annulé

    public void cancelInterview(){
        interview.cancelInterview();
    }
}