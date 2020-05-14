package main.java.model.interview;

import main.java.model.recruiter.Recruiteur;
import main.java.model.room.Room;
import main.java.model.candidat.Candidat;

import java.util.UUID;

public class Interview {
    private final UUID interviewUuid;
    private final Candidat interviewCandidat;
    private final Recruiteur interviewRecruiter;
    private final String interviewDate;
    private final Room interviewRoom;
    
    public Interview(Candidat candidat, Recruiteur recruiter, String date, Room room) {
        this.interviewUuid = UUID.randomUUID();
        this.interviewCandidat = candidat;
        this.interviewRecruiter = recruiter;
        this.interviewDate = date;
        this.interviewRoom = room;
    }
}
