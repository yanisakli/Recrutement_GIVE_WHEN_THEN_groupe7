package infrastructure.implementation;

import infrastructure.utils.Utils;
import model.candidat.Candidats;
import model.common.CandidatDTO;

import java.util.UUID;

public class CandidatsImplementation implements Candidats {
    @Override
    public CandidatDTO getCandidatByUuid(UUID candidatUuid) {
        return Utils.createCandidatWithJavaAndCrystalSkills();
    }
}
