package java.infrastructure.implementation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RecruitersImplementation implements Recruiters {
    @Override
    public List<model.common.RecruiterDTO> getRecruitersByDate(LocalDate date) {
        List<model.common.RecruiterDTO> recruiters = new ArrayList<>();
        recruiters.add(Utils.createRecruiterWithJavaAndCrystalSkills());
        recruiters.add(Utils.createRecruiterWithPythonSkills());
        return recruiters;
    }
}
