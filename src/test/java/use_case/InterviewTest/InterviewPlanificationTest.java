package use_case.InterviewTest;

import infrastructure.implementation.CandidatsImplementation;
import infrastructure.implementation.RecruitersImplementation;
import infrastructure.implementation.RoomsImplementation;
import infrastructure.utils.Utils;
import model.interview.Interview;
import model.interview.InterviewRequest;
import model.interview.Status;
import org.junit.Assert;
import org.junit.Test;
import use_case.Interview.InterviewPlanification;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public class InterviewPlanificationTest {

    @Test
    public void interview_created() {
       InterviewRequest interviewRequest = new InterviewRequest(
                UUID.fromString("d2f394c6-1abd-4818-bf08-c34651d62e0e"),
                UUID.fromString("d2f394c6-1abd-4818-bf08-c34651d62e0e"),
                Utils.date1,
                Utils.interviewStart,
                Utils.interviewFinish
        );

        InterviewPlanification interviewPlanification = new InterviewPlanification(new CandidatsImplementation(), new RecruitersImplementation(),new RoomsImplementation());
        Interview interview = interviewPlanification.createInterview(interviewRequest);
        Assert.assertNotNull(interview);
        Assert.assertEquals(LocalDate.of(2020, 6, 1),interview.getSlot().getDate());
        Assert.assertEquals(interview.getStatus(), Status.PLANIFIED);
        Assert.assertEquals(LocalTime.of(17,30),interview.getSlot().getInterviewStart());
        Assert.assertEquals(LocalTime.of(18,30),interview.getSlot().getInterviewFinish());
    }

}