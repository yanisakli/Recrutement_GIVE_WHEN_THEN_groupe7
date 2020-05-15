package infrastructure.utils;

import infrastructure.implementation.CandidatsImplementation;
import infrastructure.implementation.RecruitersImplementation;
import infrastructure.implementation.RoomsImplementation;
import model.Skill;
import model.common.*;
import model.interview.Interview;
import model.interview.InterviewRequest;
import model.room.Equipment;
import use_case.Interview.InterviewPlanification;

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
        List<SkillDTO> skillsCandidat = new ArrayList<>();
        SkillDTO skillsCandidatOne = new SkillDTO("java");
        SkillDTO skillsCandidatTwo = new SkillDTO("crystal");
        skillsCandidat.add(skillsCandidatOne);
        skillsCandidat.add(skillsCandidatTwo);

        return new CandidatDTO(UUID.fromString("d2f394c6-1abd-4818-bf08-c34651d62e0e"),"Yanis",skillsCandidat);
    }
    public static CandidatDTO createCandidatWithPythonSkills(){
        List<SkillDTO> skillsCandidat = new ArrayList<>();
        SkillDTO skillsCandidatOne = new SkillDTO("python");
        skillsCandidat.add(skillsCandidatOne);

        return new CandidatDTO(UUID.fromString("d2f394c6-1abd-4818-bf08-c34651d62e0e"),"Yanis",skillsCandidat);
    }

    public static RoomDTO createRoomB01(){
        List<SlotDTO> slotDTOList = new ArrayList<>();
        List<Equipment> equipmentList = new ArrayList<>();
        equipmentList.add(Equipment.PHONE);
        equipmentList.add(Equipment.TABLE);
        slotDTOList.add(createSlotOne());
        slotDTOList.add(createSlotTwo());
        return new RoomDTO("B01",slotDTOList, UUID.fromString("d2f394c6-1abd-4818-bf08-c34651d62e0e"), 3, equipmentList);
    }

    public static RoomDTO createRoomB82(){
        List<SlotDTO> slotDTOList = new ArrayList<>();
        List<Equipment> equipmentList = new ArrayList<>();
        equipmentList.add(Equipment.COMPUTER);
        slotDTOList.add(createSlotTwo());
        return new RoomDTO("B82",slotDTOList, UUID.fromString("d2f394c6-1abd-4818-bf08-c34651d62e0e"), 3, equipmentList);
    }

    public static RoomDTO createRoomB22(){
        List<SlotDTO> slotDTOList = new ArrayList<>();
        List<Equipment> equipmentList = new ArrayList<>();
        equipmentList.add(Equipment.PHONE);
        slotDTOList.add(createSlotOne());
        return new RoomDTO("B22",slotDTOList, UUID.fromString("d2f394c6-1abd-4818-bf08-c34651d62e0e"), 3, equipmentList);
    }

    public static SlotDTO createSlotOne(){
        return new SlotDTO(date1,interviewStart,interviewFinish);
    }
    public static SlotDTO createSlotTwo(){
        return new SlotDTO(date2,interviewStart,interviewFinish);
    }

    public static Interview createInterview(){
        Interview interview = new Interview(createCandidatWithJavaAndCrystalSkills(), createSlotOne());
        interview.plan(new RecruitersImplementation().getRecruitersByDate(date1), new RoomsImplementation().getAvailableRoom(date1));
        interview.planified();
        return interview;
    }

    public static InterviewPlanification createInterviewPlanification() {
        return new InterviewPlanification(new CandidatsImplementation(), new RecruitersImplementation(),new RoomsImplementation());
    }

    public static InterviewRequest createInterviewRequest() {
        return new InterviewRequest(
                UUID.fromString("d2f394c6-1abd-4818-bf08-c34651d62e0e"),
                UUID.fromString("d2f394c6-1abd-4818-bf08-c34651d62e0e"),
                Utils.date1,
                Utils.interviewStart,
                Utils.interviewFinish
        );
    }

}
