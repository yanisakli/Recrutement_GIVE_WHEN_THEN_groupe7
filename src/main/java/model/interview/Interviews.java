package model.interview;

import model.common.InterviewDTO;

import java.util.UUID;

public interface Interviews {
    InterviewDTO getInterviewByUUID(UUID interviewUuid);
}
