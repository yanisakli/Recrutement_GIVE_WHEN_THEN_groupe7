package main.java.use_case.interview;

import java.util.UUID;

public class InterviewRequest{
    private final UUID candidatUuid;
    private final UUID salleUuid;
    private final String date;

    public InterviewRequest(UUID candidatUuid, UUID salleUuid, String date) {
        this.candidatUuid = candidatUuid;
        this.salleUuid = salleUuid;
        this.date = date;
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
}
