package model.recruiter;

import model.Skill;
import model.common.RecruiterDTO;
import model.recruiter.exception.RecruiterException;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Recruiter {

    private final String name;
    private final String mail;
    private final List<Skill> recruiterSkills;
    private final List<LocalDate> disponibilities;

    public Recruiter(String name, String mail, List<Skill> recruiterSkills, List<LocalDate> disponibilities ) throws RecruiterException {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recruiter recruiter = (Recruiter) o;
        return Objects.equals(name, recruiter.name) &&
                Objects.equals(mail, recruiter.mail) &&
                Objects.equals(recruiterSkills, recruiter.recruiterSkills) &&
                Objects.equals(disponibilities, recruiter.disponibilities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, mail, recruiterSkills, disponibilities);
    }

    public RecruiterDTO RecruiterToDTO() {
        return new RecruiterDTO(name, mail, recruiterSkills, disponibilities);
    }

    public boolean canTestCandidat(List<Skill> skills) throws RecruiterException {
        if (skills.size() > recruiterSkills.size()) {
            throw new RecruiterException("Candidat skills cannot be greater than recruiter skills");
        }
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
