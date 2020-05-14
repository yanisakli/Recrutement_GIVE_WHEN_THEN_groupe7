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

    //TODO
    public boolean canTestCandidat(List<Skill> skills){
        return recruiterSkills.containsAll(skills);
    }

    public boolean isAvailable(LocalDate date){
        return disponibilities.contains(date);
    }
}
