package modelTest;

import model.Skill;
import model.candidat.Candidat;
import model.interview.Interview;
import model.interview.Slot;
import model.interview.Status;
import model.recruiter.Recruiter;
import model.room.Room;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class InterviewTests {

    LocalDate date1 = LocalDate.of(2020, 05, 30);
    LocalTime timeStart = LocalTime.of(17,30);
    LocalTime timeFinish = LocalTime.of(18,30);

    private Interview createInterview(){

        List<Skill> skillsCandidat = new ArrayList<>();
        List<Skill> recruiterSkills = new ArrayList<>();
        List<LocalDate> recruiterDisponibilities = new ArrayList<>();

        LocalDate date2 = LocalDate.of(2020, 05, 29);
        LocalDate date3 = LocalDate.of(2020, 05, 28);


        Skill skillsCandidatOne = new Skill("java");
        skillsCandidat.add(skillsCandidatOne);

        Skill recruiterSkillsOne = new Skill("java");
        Skill recruiterSkillsTwo = new Skill("crystal");
        recruiterSkills.add(recruiterSkillsOne);
        recruiterSkills.add(recruiterSkillsTwo);

        recruiterDisponibilities.add(date1);
        recruiterDisponibilities.add(date2);
        recruiterDisponibilities.add(date3);


        Candidat candidat = new Candidat(UUID.fromString("d2f394c6-1abd-4818-bf08-c34651d62e0e"),"Yanis",skillsCandidat);
        Recruiter recruiter = new Recruiter("Yanis","yanisakli@yahoo.fr",recruiterSkills,recruiterDisponibilities);
        Room room = new Room("B01",true,date1);
        Slot slot = new Slot(date1,timeStart,timeFinish);

        return new Interview(candidat,recruiter,room,slot);
    }


    @Test
    public void it_should_create_interview(){
        Interview interview = createInterview();
        Assert.assertNotNull(interview.getInterviewUuid());
        Assert.assertEquals(date1,interview.getInterviewRoom().getDate());
        Assert.assertEquals(timeStart,interview.getSlot().getInterviewStart());
        Assert.assertEquals(timeFinish,interview.getSlot().getInterviewFinish());
        Assert.assertEquals(interview.getStatus(), Status.PLANIFIED);
    }

    @Test
    public void it_should_confirm_interview(){
        Interview interview = createInterview();
        interview.confirmInterview();
        Assert.assertEquals(interview.getStatus(), Status.CONFIRMED);
    }

    @Test
    public void it_should_cancel_interview(){
        Interview interview = createInterview();
        interview.cancelInterview();
        Assert.assertEquals(interview.getStatus(), Status.CANCELED);
    }
}
