package use_case.InterviewTest;

import model.common.CandidatDTO;
import model.common.RecruiterDTO;
import model.common.RoomDTO;

import model.candidat.Candidat;
import model.candidat.Candidats;
import model.interview.Interview;
import model.interview.InterviewRequest;
import model.interview.Slot;
import model.interview.Status;
import model.recruiter.Recruiter;
import model.recruiter.Recruiters;
import model.recruiter.exception.RecruiterException;
import model.room.Room;
import model.room.Rooms;
import model.room.exception.RoomException;

import java.model.common.RoomDTO;
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

    public Interview createInterview(InterviewRequest request) throws RecruiterException, RoomException {
        CandidatDTO candidatDTO = candidats.getCandidatByUuid(request.getCandidatUuid());
        Candidat candidat = candidatDTO.DtoToCandidat();

        List<RecruiterDTO> listRecruiter = recruiters.getRecruitersByDate(request.getDate());
        Optional<Recruiter> recruiterStream = listRecruiter.stream()
                .map(recruiterDTO -> recruiterDTO.DtoToRecruiter())
                .filter(recruiter -> recruiter.canTestCandidat(candidat.getSkills() ))
                .findFirst();

        if(!recruiterStream.isPresent()){
            throw new RecruiterException("No recruiter is available");
        }

        List<RoomDTO> listRoom = rooms.getAvailableRoom(request.getDate());
        Optional<RoomDTO> roomSteam = listRoom.stream()
                .findFirst();

        if(!roomSteam.isPresent()){
            throw new RoomException("No room is available");
        }

        // Mettre dans créneaux
        LocalDate date = request.getDate();
        LocalTime startInterview = request.getStartInterview();
        LocalTime finishInterview = request.getFinishInterview();

        Slot slot = new Slot(date, startInterview, finishInterview);

        return new Interview(candidat, recruiterStream.get(), roomSteam.get().DtoToRoom(),slot, Status.PLANIFIED);
   }
    
}
