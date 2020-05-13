package main.java.use_case;

public class InterviewRequest{
    private final String candidatUuid;
    private final String salleUuid;
    private final String date;

    public InterviewRequest(String candidatUuid, String salleUuid, String date) {
        this.candidatUuid = candidatUuid;
        this.salleUuid = salleUuid;
        this.date = date;
    }

    public String getCandidatUuid() {
        return candidatUuid;
    }

    public String getDate() {
        return date;
    }
}
