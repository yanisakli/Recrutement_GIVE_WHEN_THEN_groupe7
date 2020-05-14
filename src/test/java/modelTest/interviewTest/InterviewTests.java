package modelTest.interviewTest;

import model.interview.Interview;
import model.interview.Slot;
import model.interview.Status;
import model.room.Room;
import org.junit.Assert;
import org.junit.Test;
import utils.Utils;

import java.time.LocalDate;
import java.time.LocalTime;

public class InterviewTests {

    @Test
    public void it_should_create_interview(){
       Interview interview = Utils.createInterview();
       Assert.assertNotNull(interview.getInterviewUuid());
       Assert.assertEquals(LocalDate.of(2020, 06, 01),interview.getInterviewRoom().getDate());
       Assert.assertEquals("B01",interview.getInterviewRoom().getName());
       Assert.assertEquals(LocalTime.of(17,30),interview.getSlot().getInterviewStart());
       Assert.assertEquals(LocalTime.of(18,30),interview.getSlot().getInterviewFinish());
       Assert.assertEquals(interview.getStatus(), Status.PLANIFIED);
    }

    @Test
    public void it_should_not_be_the_same_interview(){
        Interview interviewOne = Utils.createInterview();
        Interview interviewTwo = Utils.createInterview();
        Assert.assertNotEquals(interviewOne.getInterviewUuid(), interviewTwo.getInterviewUuid());
    }

    @Test
    public void it_should_confirm_interview(){
        Interview interview = Utils.createInterview();
        interview.confirmInterview();
        Assert.assertEquals(interview.getStatus(), Status.CONFIRMED);
    }

    @Test
    public void it_should_cancel_interview(){
        Interview interview = Utils.createInterview();
        interview.cancelInterview();
        Assert.assertEquals(interview.getStatus(), Status.CANCELED);
    }

    @Test
    public void it_should_post_poned_interview(){
        Interview interview = Utils.createInterview();

        LocalDate date = LocalDate.of(2020, 05, 29);

        LocalTime interviewStart = LocalTime.of(15,00);
        LocalTime interviewFinish = LocalTime.of(16,00);
        Slot slot = new Slot(date,interviewStart,interviewFinish);

        Room room = new Room("B22",true,date);
        interview.postPonedInterview(slot,room);

        Assert.assertEquals(date,interview.getInterviewRoom().getDate());
        Assert.assertEquals("B22",interview.getInterviewRoom().getName());
        Assert.assertEquals(interviewStart,interview.getSlot().getInterviewStart());
        Assert.assertEquals(interviewFinish,interview.getSlot().getInterviewFinish());
        Assert.assertEquals(interview.getStatus(), Status.POSTPONED);
    }
}
