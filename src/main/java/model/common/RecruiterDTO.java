package model.common;

import model.recruiter.Recruiter;

import java.time.LocalDate;
import java.util.List;

public class RecruiterDTO {
    private final String name;
    private final String mail;
    private final List<model.Skill> recruiterSkills;
    private final List<LocalDate> disponibilities;

    public RecruiterDTO(String name, String mail, List<model.Skill> recruiterSkills, List<LocalDate> disponibilities ) {
        if(name.isEmpty() | mail.isEmpty()){
            throw new model.recruiter.exception.RecruiterException("Name and mail must be defined");
        }
        if(recruiterSkills.isEmpty()){
            throw new model.recruiter.exception.RecruiterException("Recruiter must have at least one skill");
        }
        this.name = name;
        this.mail = mail;
        this.recruiterSkills = recruiterSkills;
        this.disponibilities = disponibilities;
    }

    public Recruiter DtoToRecruiter() {
        return new Recruiter(name, mail, recruiterSkills, disponibilities);
    }

    public String getName() {
        return name;
    }

    public String getMail() {
        return mail;
    }

    public List<model.Skill> getRecruiterSkills() {
        return recruiterSkills;
    }

    public List<LocalDate> getDisponibilities() {
        return disponibilities;
    }

}