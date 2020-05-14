package main.java.use_case;

import main.java.model.interview.Interview;

public class InterviewConfirmation {
    private final Interview interview;

    public InterviewConfirmation(Interview interview) {
        this.interview = interview;
    }

    public void confirmInterview(){
        interview.confirmerInterview();
    }
}