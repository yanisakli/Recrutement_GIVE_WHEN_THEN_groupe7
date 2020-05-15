package model.candidat;

import model.Skill;
import model.common.CandidatDTO;
import model.common.SkillDTO;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class Candidat {
    private final UUID candidatUuid;
    private final String name;
    private final List<Skill> skills;

    public Candidat(UUID candidatUuid, String name, List<SkillDTO> skills ) {
        this.candidatUuid = candidatUuid;
        this.name = name;
        this.skills = skills.stream().map(skillDTO -> skillDTO.DTOToSkill()).collect(Collectors.toList());
    }

    public CandidatDTO candidatToDTO(){
        return new CandidatDTO(candidatUuid, name, skills.stream().map(skill -> skill.skillToDTO()).collect(Collectors.toList()));
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