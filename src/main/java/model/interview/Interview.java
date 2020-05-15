package model.interview;

import model.candidat.Candidat;
import model.recruiter.Recruiter;
import model.room.Room;
import model.interview.Slot;
import model.interview.Status;
import model.common.InterviewDTO;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public class Interview {
    private final UUID interviewUuid;
    private Candidat interviewCandidat;
    private Recruiter interviewRecruiter;
    private Room interviewRoom;
    private Slot slot;
    private Status status;
    
    public Interview(Candidat candidat, Recruiter recruiter, Room room, Slot slot, Status status) {
        this.interviewUuid = UUID.randomUUID();
        this.interviewCandidat = candidat;
        this.interviewRecruiter = recruiter;
        this.interviewRoom = room;
        this.slot = slot;
        this.status = status;
    }

    public Interview DtoToInterview(InterviewDTO interviewDTO) {
        return new Interview(interviewDTO.getInterviewCandidat(),
                interviewDTO.getInterviewRecruiter(),
                interviewDTO.getInterviewRoom(),
                interviewDTO.getSlot(),
                interviewDTO.getStatus());
    }

    public UUID getInterviewUuid() {
        return interviewUuid;
    }

    public Candidat getInterviewCandidat() {
        return interviewCandidat;
    }

    public void setInterviewCandidat(Candidat interviewCandidat) {
        this.interviewCandidat = interviewCandidat;
    }

    public Recruiter getInterviewRecruiter() {
        return interviewRecruiter;
    }

    public void setInterviewRecruiter(Recruiter interviewRecruiter) {
        this.interviewRecruiter = interviewRecruiter;
    }

    public Room getInterviewRoom() {
        return interviewRoom;
    }

    public void setInterviewRoom(Room interviewRoom) {
        this.interviewRoom = interviewRoom;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void confirmInterview() {
        this.setStatus(Status.CONFIRMED);
    }

    public void cancelInterview() {
        this.setStatus(Status.CANCELED);
    }

    public void postPonedInterview(Slot slot,Room room) {
        this.setSlot(slot);
        this.setInterviewRoom(room);
        this.setStatus(Status.POSTPONED);
    }
}
