package main.java.use_case;

import java.util.List;

public class Recruiteur {
    private final String name;
    private final String mail;
    private final List<Skill> recruiterSkills;

    public Recruiteur(String name, String mail,List<Skill> recruiterSkills ) {
        this.name = name;
        this.mail = mail;
        this.recruiterSkills = recruiterSkills;
    }
    public boolean haveSkills(List<Skill> skills){
        if(!recruiterSkills.containsAll(skills)) return false;
        for (Skill skill: skills ) {
            if(!recruiterSkills.get(recruiterSkills.indexOf(skill)).compareQualification(skill))return false;
        }
        return true;
    }
}
