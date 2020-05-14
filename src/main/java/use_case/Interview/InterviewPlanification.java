package main.java.use_case.Interview;

import main.java.model.interview.Slot;
import main.java.model.recruiter.Recruiter;
import main.java.model.candidat.Candidat;
import main.java.model.interview.Interview;
import main.java.model.interview.InterviewRequest;
import main.java.model.candidat.Candidats;
import main.java.model.recruiter.Recruiters;
import main.java.model.room.Rooms;
import main.java.model.room.Room;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public class InterviewPlanification {
    private final Candidats candidats;
    private final Recruiters recruiters;
    private final Rooms rooms;

    public InterviewPlanification(Candidats candidats,Recruiters recruiters, Rooms rooms){
        this.candidats = candidats;
        this.recruiters = recruiters;
        this.rooms = rooms;
    }

    // GIVEN : Un candidat Java qui est disponible demain
    // AND : Un référentiel de consultant recruteur avec des disponibilités et compétences
    // AND : Un référentiel des salles avec des disponibilités
    // WHEN : Je planifie un entretien pour le candidat pour demain
    // THEN : Un entretien est planifie pour le candidat avec un recruteur demain

    public Interview createInterview(InterviewRequest request){
        Candidat candidat = candidats.getCandidatByUuid(request.getCandidatUuid());

        List<Recruiter> listRecruiter = recruiters.getRecruitersByDate(request.getDate());
        Optional<Recruiter> recruiterStream = listRecruiter.stream()
            .filter(recruiter -> recruiter.haveSkills(candidat.getSkills()))
            .findFirst();

        if(!recruiterStream.isPresent()){
            // no available Recruiter
            // Lever une runtimeException
        }
        List<Room> listRoom = rooms.getAvailableRoom(request.getDate());
        Optional<Room> roomSteam = listRoom.stream()
                .findFirst();
        if(!roomSteam.isPresent()){
            // no available Room
            // Lever une runtimeException
        }

        // Mettre dans créneaux
        LocalDate date = LocalDate.parse(request.getDate());
        LocalTime startInterview = LocalTime.parse(request.getStartInterview());
        LocalTime finishInterview = LocalTime.parse(request.getFinishInterview());

        Slot slot = new Slot(date, startInterview, finishInterview);

        return new Interview(candidat, recruiterStream.get(),date.toString(), roomSteam.get(),slot);
   }
    
}
