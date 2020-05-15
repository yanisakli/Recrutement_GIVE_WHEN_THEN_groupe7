package model.common;

import java.util.UUID;
import model.candidat.Candidat;
import model.room.Room;
import model.recruiter.Recruiter;
import model.interview.Interview;
import model.interview.Slot;
import model.interview.Status;

public class InterviewDTO {
    private final UUID interviewUuid;
    private Candidat interviewCandidat;
    private Recruiter interviewRecruiter;
    private Room interviewRoom;
    private Slot slot;
    private Status status;

    public InterviewDTO(Candidat candidat, Recruiter recruiter, Room room, Slot slot, Status status) {
        this.interviewUuid = UUID.randomUUID();
        this.interviewCandidat = candidat;
        this.interviewRecruiter = recruiter;
        this.interviewRoom = room;
        this.slot = slot;
        this.status = status;
    }

    public InterviewDTO InterviewToDTO(Interview interview){
        return new InterviewDTO(interview.getInterviewCandidat(),
                interview.getInterviewRecruiter(),
                interview.getInterviewRoom(),
                interview.getSlot(),
                interview.getStatus());
    }

    public UUID getInterviewUuid() {
        return interviewUuid;
    }

    public Candidat getInterviewCandidat() {
        return interviewCandidat;
    }

    public Recruiter getInterviewRecruiter() {
        return interviewRecruiter;
    }

    public Room getInterviewRoom() {
        return interviewRoom;
    }

    public Slot getSlot() {
        return slot;
    }

    public Status getStatus() {
        return status;
    }
}