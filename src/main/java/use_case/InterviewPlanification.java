package main.java.use_case;
import java.util.List;
import java.util.UUID;

public class InterviewPlanification {

    // GIVEN : Un candidat Java qui est disponible demain
    // AND : Un référentiel de consultant recruteur avec des disponibilités et compétences
    // AND : Un référentiel des salles avec des disponibilités
    // WHEN : Je planifie un entretien pour le candidat pour demain
    // THEN : Un entretien est planifie pour le candidat avec un recruteur demain

    public Interview createInterview(InterviewRequest request){
        Candidat candidat = CandidatService.getCandidatByUuid(request.getCandidatUuid());
        List<Recruiteur> listRecruiter = InterviewService.getRecruitersByDate(request.getDate());

        
    }
}
