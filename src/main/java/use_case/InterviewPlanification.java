package main.java.use_case;

import main.java.use_case.recruiter.Recruiteur;
import main.java.use_case.candidat.Candidat;
import main.java.use_case.interview.Interview;
import main.java.use_case.interview.InterviewRequest;
import main.java.use_case.repositories.Candidats;
import main.java.use_case.repositories.Recruiters;
import main.java.use_case.repositories.Rooms;
import main.java.use_case.room.Room;

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
