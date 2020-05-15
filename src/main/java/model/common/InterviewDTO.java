package model.common;

import java.util.UUID;
import model.candidat.Candidat;
import model.room.Room;
import model.recruiter.Recruiter;
import model.interview.Interview;
import model.interview.Slot;
import model.interview.Status;
import model.common.CandidatDTO;
import model.common.RecruiterDTO;
import java.model.common.RoomDTO;
import java.model.common.SlotDTO;

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