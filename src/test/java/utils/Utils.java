package utils;

import model.Skill;
import model.candidat.Candidat;
import model.interview.Interview;
import model.interview.Slot;
import model.recruiter.Recruiter;
import model.room.Room;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Utils {

    private static final LocalDate date1 = LocalDate.of(2020, 05, 30);
    private static final LocalDate date2 =  LocalDate.of(2020, 05, 29);
    private static final LocalDate date3 = LocalDate.of(2020, 05, 28);
    private static final LocalTime interviewStart = LocalTime.of(17,30);
    private static final LocalTime interviewFinish = LocalTime.of(18,30);

    public static Recruiter createRecruiter(){
        List<Skill> recruiterSkills = new ArrayList<>();
        List<LocalDate> recruiterDisponibilities = new ArrayList<>();
        Skill recruiterSkillsOne = new Skill("java");
        Skill recruiterSkillsTwo = new Skill("crystal");
        recruiterSkills.add(recruiterSkillsOne);
        recruiterSkills.add(recruiterSkillsTwo);
        recruiterDisponibilities.add(date1);
        recruiterDisponibilities.add(date2);
        recruiterDisponibilities.add(date3);

        return new Recruiter("Yanis","yanisakli@yahoo.fr",recruiterSkills,recruiterDisponibilities);
    }

    public static Candidat createCandidat(){
        List<Skill> skillsCandidat = new ArrayList<>();
        Skill skillsCandidatOne = new Skill("java");
        skillsCandidat.add(skillsCandidatOne);

        return new Candidat(UUID.fromString("d2f394c6-1abd-4818-bf08-c34651d62e0e"),"Yanis",skillsCandidat);
    }
    public static Room createRoom(){
        return new Room("B01",true,date1);
    }

    public static Slot createSlot(){
        return new Slot(date1,interviewStart,interviewFinish);
    }

    public static Interview createInterview(){
        return new Interview(createCandidat(),createRecruiter(),createRoom(),createSlot());
    }
}