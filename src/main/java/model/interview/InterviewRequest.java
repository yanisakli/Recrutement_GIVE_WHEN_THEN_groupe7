package model.interview;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;
import java.util.UUID;

public class InterviewRequest{
    private final UUID candidatUuid;
    private final UUID roomUuid;
    private final LocalDate date;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InterviewRequest that = (InterviewRequest) o;
        return Objects.equals(candidatUuid, that.candidatUuid) &&
                Objects.equals(roomUuid, that.roomUuid) &&
                Objects.equals(date, that.date) &&
                Objects.equals(startInterview, that.startInterview) &&
                Objects.equals(finishInterview, that.finishInterview);
    }

    @Override
    public int hashCode() {
        return Objects.hash(candidatUuid, roomUuid, date, startInterview, finishInterview);
    }

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
