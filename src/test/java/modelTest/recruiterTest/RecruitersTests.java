package modelTest.recruiterTest;

import model.recruiter.Recruiter;
import model.recruiter.Recruiters;
import utils.Utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RecruitersTests implements Recruiters {
    @Override
    public List<Recruiter> getRecruitersByDate(LocalDate date) {
        List<Recruiter> recruiters = new ArrayList<>();
        recruiters.add(Utils.createRecruiterWithJavaAndCrystalSkills());
        recruiters.add(Utils.createRecruiterWithPythonSkills());
        return recruiters;
    }
}
