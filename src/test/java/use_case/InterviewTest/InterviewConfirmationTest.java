package use_case.InterviewTest;

import infrastructure.utils.Utils;
import model.interview.Interview;
import model.interview.Status;
import org.junit.Assert;
import org.junit.Test;
import use_case.Interview.InterviewPlanification;

import java.time.LocalDate;
import java.time.LocalTime;

public class InterviewConfirmationTest {
    @Test
    public void interview_confirmation() {
        InterviewPlanification interviewPlanification = Utils.createInterviewPlanification();
        Interview interview = interviewPlanification.createInterview(Utils.createInterviewRequest());

        interview.confirmInterview();
        Assert.assertNotNull(interview);
        Assert.assertEquals(LocalDate.of(2020, 6, 1),interview.getSlot().getDate());
        Assert.assertEquals(interview.getStatus(), Status.CONFIRMED);
        Assert.assertEquals(LocalTime.of(17,30),interview.getSlot().getInterviewStart());
        Assert.assertEquals(LocalTime.of(18,30),interview.getSlot().getInterviewFinish());
    }
}