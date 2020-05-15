package model.recruiter;

import model.common.RecruiterDTO;

import java.time.LocalDate;
import java.util.List;

public interface Recruiters {
    List<RecruiterDTO> getRecruitersByDate(LocalDate date);
}
