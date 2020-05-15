package model.candidat;

import java.util.UUID;

public interface Candidats {

    model.common.CandidatDTO getCandidatByUuid(UUID candidatUuid);
}
