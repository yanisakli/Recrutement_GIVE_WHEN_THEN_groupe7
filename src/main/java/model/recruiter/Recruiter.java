package model.recruiter;

import model.Skill;
import model.recruiter.exception.RecruiterException;
import java.time.LocalDate;
import java.util.List;

public class Recruiter {

    private final String name;
    private final String mail;
    private final List<Skill> recruiterSkills;
    private final List<LocalDate> disponibilities;

    public Recruiter(String name, String mail, List<Skill> recruiterSkills, List<LocalDate> disponibilities ) {
        if(name.isEmpty() | mail.isEmpty()){
            throw new RecruiterException("Name and mail must be defined");
        }
        if(recruiterSkills.isEmpty()){
            throw new RecruiterException("Recruiter must have at least one skill");
        }
        this.name = name;
        this.mail = mail;
        this.recruiterSkills = recruiterSkills;
        this.disponibilities = disponibilities;
    }

    public model.common.RecruiterDTO RecruiterToDTO(model.recruiter.Recruiter recruiter) {
        return new model.common.RecruiterDTO(recruiter.getName(), recruiter.getMail(), recruiter.getRecruiterSkills(), recruiter.getDisponibilities() );
    }
    //TODO : elle retourne toujours false :/
    public boolean canTestCandidat(List<Skill> skills){
        return recruiterSkills.containsAll(skills);
    }

    public boolean isAvailable(LocalDate date){
        return disponibilities.contains(date);
    }

    public String getName() {
        return name;
    }

    public String getMail() {
        return mail;
    }

    public List<Skill> getRecruiterSkills() {
        return recruiterSkills;
    }

    public List<LocalDate> getDisponibilities() {
        return disponibilities;
    }
}
