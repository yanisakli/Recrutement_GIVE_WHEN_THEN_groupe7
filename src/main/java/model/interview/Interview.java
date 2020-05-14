package main.java.model.interview;

import main.java.model.recruiter.Recruiter;
import main.java.model.room.Room;
import main.java.model.candidat.Candidat;

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
        setStatus(Status.PLANIFIE);
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
    
    public void confirmerInterview() {
        this.setStatus(Status.CONFIRME);
    }

    public void annulerInterview() {
        this.setStatus(Status.ANNULE);
    }
}
