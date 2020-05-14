package use_case.Interview;


import model.interview.Interview;

public class InterviewConfirmation {
    private final Interview interview;

    public InterviewConfirmation(Interview interview) {
        this.interview = interview;
    }

    public void confirmInterview(){
        interview.confirmInterview();
    }
}