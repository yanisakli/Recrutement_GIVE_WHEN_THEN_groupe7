package main.java.use_case;

import java.util.List;

public interface InterviewService {
    List<Recruiteur> getRecruitersByDate(String date);
}
