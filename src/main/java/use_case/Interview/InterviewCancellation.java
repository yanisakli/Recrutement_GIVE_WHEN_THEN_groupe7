package main.java.use_case.Interview;

import main.java.model.interview.Interview;

public class InterviewAnnulation {
    private final Interview interview;

    public InterviewAnnulation(Interview interview) {
        this.interview = interview;
    }

    public void cancelInterview(){
        interview.annulerInterview();
    }
}