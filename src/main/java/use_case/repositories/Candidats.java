package main.java.use_case.repositories;

import main.java.use_case.Skill;
import main.java.use_case.candidat.Candidat;

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
