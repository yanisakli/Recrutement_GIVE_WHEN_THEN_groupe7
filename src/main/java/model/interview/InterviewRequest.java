package model.interview;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public class InterviewRequest{
    private final UUID candidatUuid;
    private final UUID roomUuid;
    private final LocalDate date;
    private final LocalTime startInterview;
    private final LocalTime finishInterview;

    public InterviewRequest(UUID candidatUuid, UUID roomUuid, LocalDate date, LocalTime startInterview, LocalTime finishInterview ) {
        this.candidatUuid = candidatUuid;
        this.roomUuid = roomUuid;
        this.date = date;
        this.startInterview = startInterview;
        this.finishInterview = finishInterview;
    }

    public UUID getCandidatUuid() {
        return candidatUuid;
    }

    public UUID getRoomUuid() {
        return roomUuid;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getStartInterview() {
        return startInterview;
    }

    public LocalTime getFinishInterview() {
        return finishInterview;
    }
}
