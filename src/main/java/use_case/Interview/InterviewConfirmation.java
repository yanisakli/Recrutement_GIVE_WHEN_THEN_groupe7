package use_case.Interview;

import model.interview.Interview;

public class InterviewConfirmation {
    private final Interview interview;

    public InterviewConfirmation(Interview interview) {
        this.interview = interview;
    }

    // GIVEN : Un entretien planifié pour demain pour Billy
    // AND : Le recruteur Bob adéquat à mener l'entetien
    // WHEN : Biily et Bob confirment que le créneau leur convient
    // THEN : L'entretien est mis à l'état Confirmé

    public void confirmInterview(){
        interview.confirmInterview();
    }
}