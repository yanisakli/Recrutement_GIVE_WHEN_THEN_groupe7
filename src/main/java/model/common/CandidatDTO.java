package model.common;

import java.util.List;
import java.util.UUID;

public class CandidatDTO implements Candidats {
    private final UUID candidatUuid;
    private final String name;
    private final List<model.Skill> skills;

    public CandidatDTO(UUID candidatUuid, String name, List<model.Skill> skills ) {
        this.candidatUuid = candidatUuid;
        this.name = name;
        this.skills = skills;
    }

    public UUID getCandidatUuid() {
        return candidatUuid;
    }

    public String getName() {
        return name;
    }

    public List<model.Skill> getSkills() {
        return skills;
    }
}