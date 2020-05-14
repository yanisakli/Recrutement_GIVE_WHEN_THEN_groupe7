package main.java.infrastructure;

import main.java.model.Skill;
import main.java.model.candidat.Candidat;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Candidats {

    public static Candidat getCandidatByUuid(UUID candidatUuid){
        List<Skill> skills = new ArrayList<>();
        skills.add(new Skill("java"));
        return new Candidat(candidatUuid, "Yanis",skills);
    }
}
