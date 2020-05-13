package main.java.use_case;

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

    public List<Skill> getSkills() {
        return this.skills;
    }
}