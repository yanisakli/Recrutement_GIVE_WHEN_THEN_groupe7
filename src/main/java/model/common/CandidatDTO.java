package model.common;

import model.candidat.Candidat;

import java.util.List;
import java.util.UUID;

public class CandidatDTO {
    private final UUID candidatUuid;
    private final String name;
    private final List<SkillDTO> skillsDTO;

    public CandidatDTO(UUID candidatUuid, String name, List<SkillDTO> skillsDTO ) {
        this.candidatUuid = candidatUuid;
        this.name = name;
        this.skillsDTO = skillsDTO;
    }

    public Candidat DtoToCandidat(){
        return new Candidat(candidatUuid, name, skillsDTO);
    }

    public UUID getCandidatUuid() {
        return candidatUuid;
    }

    public String getName() {
        return name;
    }

    public List<SkillDTO> getSkills() {
        return skillsDTO;
    }
}