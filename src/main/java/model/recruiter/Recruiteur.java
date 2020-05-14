package main.java.model.recruiter;

import main.java.model.Skill;

import java.util.List;

public class Recruiteur {
    private final String name;
    private final String mail;
    private final List<Skill> recruiterSkills;
    private final List<String> disponibilities;

    public Recruiteur(String name, String mail,List<Skill> recruiterSkills,List<String> disponibilities ) {
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
}
