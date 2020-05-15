package java.model.common;

import java.model.candidat.Candidat;
import java.model.interview.Interview;
import java.model.interview.Slot;
import java.model.interview.Status;
import java.model.recruiter.Recruiter;
import java.util.UUID;

public class InterviewDTO {
    private final UUID interviewUuid;
    private CandidatDTO interviewCandidat;
    private RecruiterDTO interviewRecruiter;
    private UUID roomUuid;
    private SlotDTO slot;
    private Status status;

    public InterviewDTO(Candidat candidat, Recruiter recruiter, UUID roomUuid, Slot slot, Status status) {
        this.interviewUuid = UUID.randomUUID();
        this.interviewCandidat = candidat.candidatToDTO();
        this.interviewRecruiter = recruiter.RecruiterToDTO();
        this.roomUuid = roomUuid;
        this.slot = slot.SlotToDTO();
        this.status = status;
    }

    public Interview DtoToInterview() {
        return new Interview(interviewCandidat, slot);
    }

    public UUID getInterviewUuid() {
        return interviewUuid;
    }

    public Candidat getInterviewCandidat() {
        return interviewCandidat.DtoToCandidat();
    }

    public Recruiter getInterviewRecruiter() {
        return interviewRecruiter.DtoToRecruiter();
    }

    /*public Room getInterviewRoom() {
        return interviewRoom;
    }*/

    public Slot getSlot() {
        return slot.DtoToSlot();
    }

    public Status getStatus() {
        return status;
    }
}