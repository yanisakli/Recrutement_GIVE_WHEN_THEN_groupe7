package modelTest.interviewTest;

import infrastructure.utils.Utils;
import model.interview.Interview;
import model.interview.Slot;
import model.interview.Status;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;

public class InterviewTests {

    @Test
    public void it_should_create_interview(){
       Interview interview = Utils.createInterview();
       Assert.assertNotNull(interview.getInterviewUuid());
       Assert.assertNotNull(interview.getRoomUuid());
       Assert.assertEquals(LocalDate.of(2020, 06, 01),interview.getSlot().getDate());
       Assert.assertEquals(LocalTime.of(17,30),interview.getSlot().getInterviewStart());
       Assert.assertEquals(LocalTime.of(18,30),interview.getSlot().getInterviewFinish());
       Assert.assertEquals(interview.getStatus(), Status.PLANIFIED);
    }

    @Test
    public void it_should_not_be_the_same_interview(){
        Interview interviewOne = infrastructure.utils.Utils.createInterview();
        Interview interviewTwo = infrastructure.utils.Utils.createInterview();
        Assert.assertNotEquals(interviewOne.getInterviewUuid(), interviewTwo.getInterviewUuid());
    }

    @Test
    public void it_should_confirm_interview(){
        Interview interview = infrastructure.utils.Utils.createInterview();
        interview.confirmInterview();
        Assert.assertEquals(interview.getStatus(), Status.CONFIRMED);
    }

    @Test
    public void it_should_cancel_interview(){
        Interview interview = infrastructure.utils.Utils.createInterview();
        interview.cancelInterview();
        Assert.assertEquals(interview.getStatus(), Status.CANCELED);
    }

    @Test
    public void it_should_post_poned_interview(){
        Interview interview = infrastructure.utils.Utils.createInterview();

        LocalDate date = LocalDate.of(2020, 05, 29);

        LocalTime interviewStart = LocalTime.of(15,00);
        LocalTime interviewFinish = LocalTime.of(16,00);
        Slot slot = new Slot(date,interviewStart,interviewFinish);

        // RoomDTO roomDTO = Utils.createRoomB82();
        interview.postPonedInterview(slot);

        Assert.assertEquals(date,interview.getSlot().getDate());
        Assert.assertNotNull(interview.getRoomUuid());
        Assert.assertEquals(interviewStart,interview.getSlot().getInterviewStart());
        Assert.assertEquals(interviewFinish,interview.getSlot().getInterviewFinish());
        Assert.assertEquals(interview.getStatus(), Status.POSTPONED);
    }
}
