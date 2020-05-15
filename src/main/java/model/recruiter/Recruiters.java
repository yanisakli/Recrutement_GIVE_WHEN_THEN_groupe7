package model.recruiter;

import java.time.LocalDate;
import java.util.List;

public interface Recruiters {
    List<model.common.RecruiterDTO> getRecruitersByDate(LocalDate date);
}
