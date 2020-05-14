package model.recruiter;

import model.Skill;

import java.time.LocalDate;
import java.util.List;

public class Recruiter {
    private final String name;
    private final String mail;
    private final List<Skill> recruiterSkills;
    private final List<LocalDate> disponibilities;

    public Recruiter(String name, String mail, List<Skill> recruiterSkills, List<LocalDate> disponibilities ) {
        this.name = name;
        this.mail = mail;
        this.recruiterSkills = recruiterSkills;
        this.disponibilities = disponibilities;
    }
    public boolean haveSkills(List<Skill> skills){
        if(!recruiterSkills.containsAll(skills)) return false;
        for (Skill skill: skills ) {
            if(!recruiterSkills.get(recruiterSkills.indexOf(skill)).compareQualification(skill))return false;
        }
        return true;
    }
    // Créer un objet recruteur qui aura "peutTester(candidat)"
}
