package main.java.use_case.Interview;

import main.java.model.interview.Interview;

public class InterviewCancellation {
    private final Interview interview;

    public InterviewCancellation(Interview interview) {
        this.interview = interview;
    }

    public void cancelInterview(){
        interview.cancelInterview();
    }
}