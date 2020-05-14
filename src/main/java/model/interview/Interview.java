package main.java.model.interview;

import main.java.model.recruiter.Recruiter;
import main.java.model.room.Room;
import main.java.model.candidat.Candidat;

import java.util.UUID;

public class Interview {
    private final UUID interviewUuid;
    private final Candidat interviewCandidat;
    private final Recruiter interviewRecruiter;
    private final String interviewDate;
    private final Room interviewRoom;
    
    public Interview(Candidat candidat, Recruiter recruiter, String date, Room room) {
        this.interviewUuid = UUID.randomUUID();
        this.interviewCandidat = candidat;
        this.interviewRecruiter = recruiter;
        this.interviewDate = date;
        this.interviewRoom = room;
    }
}
