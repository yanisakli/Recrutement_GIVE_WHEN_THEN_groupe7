package infrastructure.utils;

import model.Skill;
import model.interview.Interview;
import model.interview.Slot;
import model.interview.Status;
import model.common.CandidatDTO;
import model.common.RecruiterDTO;

import java.model.common.RoomDTO;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Utils {

    public static final LocalDate date1 = LocalDate.of(2020, 06, 01);
    public static final LocalDate date2 =  LocalDate.of(2020, 05, 29);
    public static final LocalDate date3 = LocalDate.of(2020, 05, 28);
    public static final LocalTime interviewStart = LocalTime.of(17,30);
    public static final LocalTime interviewFinish = LocalTime.of(18,30);

    public static RecruiterDTO createRecruiterWithJavaAndCrystalSkills(){
        List<Skill> recruiterSkills = new ArrayList<>();
        List<LocalDate> recruiterDisponibilities = new ArrayList<>();
        Skill recruiterSkillsOne = new Skill("java");
        Skill recruiterSkillsTwo = new Skill("crystal");
        recruiterSkills.add(recruiterSkillsOne);
        recruiterSkills.add(recruiterSkillsTwo);
        recruiterDisponibilities.add(date1);
        recruiterDisponibilities.add(date2);

        return new RecruiterDTO("Yanis","yanisakli@yahoo.fr",recruiterSkills,recruiterDisponibilities);
    }
    public static RecruiterDTO createRecruiterWithPythonSkills(){
        List<Skill> recruiterSkills = new ArrayList<>();
        List<LocalDate> recruiterDisponibilities = new ArrayList<>();
        Skill recruiterSkillsOne = new Skill("python");
        recruiterSkills.add(recruiterSkillsOne);
        recruiterDisponibilities.add(date1);
        recruiterDisponibilities.add(date2);

        return new RecruiterDTO("Yanis","yanisakli@yahoo.fr",recruiterSkills,recruiterDisponibilities);
    }
    public static RecruiterDTO createRecruiterWithEmptyName(){
        List<Skill> recruiterSkills = new ArrayList<>();
        List<LocalDate> recruiterDisponibilities = new ArrayList<>();
        Skill recruiterSkillsOne = new Skill("python");
        recruiterSkills.add(recruiterSkillsOne);
        recruiterDisponibilities.add(date1);
        recruiterDisponibilities.add(date2);

        return new RecruiterDTO("","yanisakli@yahoo.fr",recruiterSkills,recruiterDisponibilities);
    }
    public static RecruiterDTO createRecruiterWithEmptyMail(){
        List<Skill> recruiterSkills = new ArrayList<>();
        List<LocalDate> recruiterDisponibilities = new ArrayList<>();
        Skill recruiterSkillsOne = new Skill("python");
        recruiterSkills.add(recruiterSkillsOne);
        recruiterDisponibilities.add(date1);
        recruiterDisponibilities.add(date2);

        return new RecruiterDTO("Yanis","",recruiterSkills,recruiterDisponibilities);
    }
    public static RecruiterDTO createRecruiterWithoutSkills(){
        List<Skill> recruiterSkills = new ArrayList<>();
        List<LocalDate> recruiterDisponibilities = new ArrayList<>();
        recruiterDisponibilities.add(date1);
        recruiterDisponibilities.add(date2);

        return new RecruiterDTO("Yanis","yanisakli@yahoo.fr",recruiterSkills,recruiterDisponibilities);
    }

    public static CandidatDTO createCandidatWithJavaAndCrystalSkills(){
        List<Skill> skillsCandidat = new ArrayList<>();
        Skill skillsCandidatOne = new Skill("java");
        Skill skillsCandidatTwo = new Skill("crystal");
        skillsCandidat.add(skillsCandidatOne);
        skillsCandidat.add(skillsCandidatTwo);

        return new CandidatDTO(UUID.fromString("d2f394c6-1abd-4818-bf08-c34651d62e0e"),"Yanis",skillsCandidat);
    }
    public static CandidatDTO createCandidatWithPythonSkills(){
        List<Skill> skillsCandidat = new ArrayList<>();
        Skill skillsCandidatOne = new Skill("python");
        skillsCandidat.add(skillsCandidatOne);

        return new CandidatDTO(UUID.fromString("d2f394c6-1abd-4818-bf08-c34651d62e0e"),"Yanis",skillsCandidat);
    }

    public static RoomDTO createRoomB01(){
        return new RoomDTO("B01",true);
    }
    public static RoomDTO createRoomB21(){
        return new RoomDTO("B21",true);
    }
    public static RoomDTO createRoomB22(){
        return new RoomDTO("B22",true);
    }

    public static Slot createSlot(){
        return new Slot(date1,interviewStart,interviewFinish);
    }

    public static Interview createInterview(){
        return new Interview(createCandidatWithJavaAndCrystalSkills(),createRecruiterWithJavaAndCrystalSkills(),createRoomB01(),createSlot(), Status.PLANIFIED);
    }

}
