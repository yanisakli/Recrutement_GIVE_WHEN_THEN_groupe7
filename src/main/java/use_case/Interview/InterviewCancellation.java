package use_case.Interview;

import model.interview.Interview;

public class InterviewCancellation {
    private final Interview interview;

    public InterviewCancellation(Interview interview) {
        this.interview = interview;
    }

    public void cancelInterview(){
        interview.cancelInterview();
    }
}