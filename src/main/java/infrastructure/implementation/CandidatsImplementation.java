package infrastructure.implementation;

import infrastructure.utils.Utils;
import model.candidat.Candidat;
import model.candidat.Candidats;
import java.util.UUID;

public class CandidatsImplementation implements model.candidat.Candidats {
    @Override
    public Candidat getCandidatByUuid(UUID candidatUuid) {
        return Utils.createCandidatWithJavaAndCrystalSkills();
    }
}
