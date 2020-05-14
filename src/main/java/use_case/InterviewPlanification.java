package main.java.use_case;

import main.java.model.recruiter.Recruiteur;
import main.java.model.candidat.Candidat;
import main.java.model.interview.Interview;
import main.java.model.interview.InterviewRequest;
import main.java.infrastructure.Candidats;
import main.java.infrastructure.Recruiters;
import main.java.infrastructure.Rooms;
import main.java.model.room.Room;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class InterviewPlanification {
    private Candidat candidat;
    private Recruiteur recruiteur;
    private Room room;

    public InterviewPlanification(Candidat candidat,Recruiteur recruiteur, Room room){
        this.candidat = candidat;
        this.recruiteur = recruiteur;
        this.room = room;
    }

    // GIVEN : Un candidat Java qui est disponible demain
    // AND : Un référentiel de consultant recruteur avec des disponibilités et compétences
    // AND : Un référentiel des salles avec des disponibilités
    // WHEN : Je planifie un entretien pour le candidat pour demain
    // THEN : Un entretien est planifie pour le candidat avec un recruteur demain

    public Interview createInterview(InterviewRequest request){
        Candidat candidat = Candidats.getCandidatByUuid(request.getCandidatUuid());

        List<Recruiteur> listRecruiter = Recruiters.getRecruitersByDate(request.getDate());
        Optional<Recruiteur> recruiterStream = listRecruiter.stream()
            .filter(cr -> cr.haveSkills(candidat.getSkills()))
            .findFirst();

        if(recruiterStream.isPresent()){
            // no available Recruiter
        }
        List<Room> listRoom = Rooms.getAvailableRoom(request.getDate());
        Optional<Room> rootSteam = listRoom.stream()
                .findFirst();
        if(rootSteam.isPresent()){
            // no available Room
        }

        LocalDateTime date = LocalDateTime.parse(request.getDate());

        return new Interview(candidat, recruiterStream.get(),date.toString(), rootSteam.get());
   }
    
}
