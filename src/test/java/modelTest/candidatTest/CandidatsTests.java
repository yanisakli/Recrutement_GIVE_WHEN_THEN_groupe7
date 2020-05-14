package modelTest.candidatTest;

import model.candidat.Candidat;
import model.candidat.Candidats;
import utils.Utils;

import java.util.UUID;

public class CandidatsTests implements Candidats {
    @Override
    public Candidat getCandidatByUuid(UUID candidatUuid) {
        return Utils.createCandidatWithJavaAndCrystalSkills();
    }
}
