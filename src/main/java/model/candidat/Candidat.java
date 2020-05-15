package model.candidat;

import model.Skill;
import model.common.CandidatDTO;
import model.common.SkillDTO;

import java.util.List;
import java.util.Objects;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candidat candidat = (Candidat) o;
        return Objects.equals(candidatUuid, candidat.candidatUuid) &&
                Objects.equals(name, candidat.name) &&
                Objects.equals(skills, candidat.skills);
    }

    @Override
    public int hashCode() {
        return Objects.hash(candidatUuid, name, skills);
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