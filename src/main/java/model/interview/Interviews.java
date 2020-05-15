package model.interview;

import java.util.UUID;

public interface Interviews {
    model.common.InterviewDTO getInterviewByUUID(UUID interviewUuid);
}
