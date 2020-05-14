package model.interview;

import model.candidat.Candidat;
import model.recruiter.Recruiter;
import model.room.Room;

import java.util.UUID;

public class Interview {
    private final UUID interviewUuid;
    private Candidat interviewCandidat;
    private Recruiter interviewRecruiter;
    private String interviewDate;
    private Room interviewRoom;
    private Slot slot;
    private Status status;
    
    public Interview(Candidat candidat, Recruiter recruiter, String date, Room room, Slot slot) {
        this.interviewUuid = UUID.randomUUID();
        this.interviewCandidat = candidat;
        this.interviewRecruiter = recruiter;
        this.interviewDate = date;
        this.interviewRoom = room;
        this.slot = slot;
        setStatus(Status.POSTPONED);
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

    public String getInterviewDate() {
        return interviewDate;
    }

    public void setInterviewDate(String interviewDate) {
        this.interviewDate = interviewDate;
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
}
