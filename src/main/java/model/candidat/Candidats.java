package model.candidat;

import model.common.CandidatDTO;

import java.util.UUID;

public interface Candidats {

    CandidatDTO getCandidatByUuid(UUID candidatUuid);
}
