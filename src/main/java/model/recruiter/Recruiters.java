package model.recruiter;

import java.time.LocalDate;
import java.util.List;

public interface Recruiters {
    List<Recruiter> getRecruitersByDate(LocalDate date);
}
