package model.candidat;

import model.Skill;

import java.model.common.SlotDTO;
import java.util.List;
import java.util.UUID;

public class Candidat {
    private final UUID candidatUuid;
    private final String name;
    private final List<Skill> skills;

    public Candidat(UUID candidatUuid, String name, List<Skill> skills ) {
        this.candidatUuid = candidatUuid;
        this.name = name;
        this.skills = skills;
    }

    public model.common.CandidatDTO candidatToDTO(model.candidat.Candidat candidat){
        return new model.common.CandidatDTO(candidat.getCandidatUuid(),candidat.getName(),candidat.getSkills());
    }
    public UUID getCandidatUuid() {
        return candidatUuid;
    }

    public String getName() {
        return name;
    }

    public List<Skill> getSkills() {
        return this.skills;
    }
}