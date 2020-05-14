package main.java.use_case.interview;

import main.java.use_case.recruiter.Recruiteur;
import main.java.use_case.room.Room;
import main.java.use_case.candidat.Candidat;

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
