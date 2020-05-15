package infrastructure.implementation;

import infrastructure.utils.Utils;
import model.common.CandidatDTO;
import java.util.UUID;

public class CandidatsImplementation implements model.candidat.Candidats {
    @Override
    public CandidatDTO getCandidatByUuid(UUID candidatUuid) {
        return Utils.createCandidatWithJavaAndCrystalSkills();
    }
}
