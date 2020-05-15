package use_case.InterviewTest;

import infrastructure.utils.Utils;
import model.interview.Interview;
import model.interview.InterviewRequest;
import use_case.InterviewTestInterviewTest;
import model.interview.Status;
import infrastructure.implementation.CandidatsImplementation;
import infrastructure.implementation.RecruitersImplementation;
import infrastructure.implementation.RoomsImplementation;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public class InterviewPlanificationTest {
    //TODO
    @Test
    public void interview_created(){
        InterviewRequest interviewRequest = new InterviewRequest(
                UUID.fromString("d2f394c6-1abd-4818-bf08-c34651d62e0e"),
                UUID.fromString("d2f394c6-1abd-4818-bf08-c34651d62e0e"),
                Utils.date1,
                Utils.interviewStart,
                Utils.interviewFinish
        );

        InterviewPlanification planificationEntretien = new InterviewPlanification(new CandidatsImplementation(), new RecruitersImplementation(),new RoomsImplementation());
        Interview interview = planificationEntretien.createInterview(interviewRequest);

        Assert.assertNotNull(interview.getInterviewUuid());
        Assert.assertEquals(LocalDate.of(2020, 05, 30),interview.getSlot().getDate());
        Assert.assertEquals("B01",interview.getInterviewRoom().getName());
        Assert.assertEquals(LocalTime.of(17,30),interview.getSlot().getInterviewStart());
        Assert.assertEquals(LocalTime.of(18,30),interview.getSlot().getInterviewFinish());
        Assert.assertEquals(interview.getStatus(), Status.PLANIFIED);
    }

}