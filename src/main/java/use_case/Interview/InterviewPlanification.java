package java.use_case.Interview;

import model.candidat.Candidats;
import model.common.CandidatDTO;
import model.common.RecruiterDTO;
import model.interview.Interview;
import model.interview.InterviewRequest;
import model.interview.Slot;
import model.recruiter.Recruiters;
import model.recruiter.exception.RecruiterException;
import model.room.Rooms;
import model.room.exception.RoomException;

import java.model.common.RoomDTO;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

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

    public void createInterview(InterviewRequest request) throws RecruiterException, RoomException {
        CandidatDTO candidatDTO = candidats.getCandidatByUuid(request.getCandidatUuid());

        List<RecruiterDTO> listRecruiterDTO = recruiters.getRecruitersByDate(request.getDate()); // Good
        List<RoomDTO> listRoomDTO = rooms.getAvailableRoom(request.getDate());

        // Mettre dans créneaux
        LocalDate date = request.getDate();
        LocalTime startInterview = request.getStartInterview();
        LocalTime finishInterview = request.getFinishInterview();

        Slot slot = new Slot(date, startInterview, finishInterview);

        Interview interview = new Interview(candidatDTO, slot.SlotToDTO());
        interview.plan(listRecruiterDTO, listRoomDTO);
        interview.confirm();
    }
    
}
