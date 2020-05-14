package model.interview;

import java.util.UUID;

public class InterviewRequest{
    private final UUID candidatUuid;
    private final UUID salleUuid;
    private final String date;
    private final String startInterview;
    private final String finishInterview;

    public InterviewRequest(UUID candidatUuid, UUID salleUuid, String date, String startInterview, String finishInterview ) {
        this.candidatUuid = candidatUuid;
        this.salleUuid = salleUuid;
        this.date = date;
        this.startInterview = startInterview;
        this.finishInterview = finishInterview;
    }

    public UUID getCandidatUuid() {
        return candidatUuid;
    }

    public UUID getSalleUuid() {
        return salleUuid;
    }

    public String getDate() {
        return date;
    }

    public String getStartInterview() {
        return startInterview;
    }

    public String getFinishInterview() {
        return finishInterview;
    }
}
