package modelTest;

import model.Skill;
import model.candidat.Candidat;
import model.recruiter.Recruiter;
import org.junit.Assert;
import org.junit.Test;
import utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class RecruiterTests {

    @Test
    public void it_should_create_recruiter(){
        Recruiter recruiter = Utils.createRecruiter();
        Assert.assertNotNull("Recruiter created",recruiter);
    }

    @Test
    public void recruiter_should_be_available(){
        Recruiter recruiter = Utils.createRecruiter();
        Assert.assertEquals(true,recruiter.isAvailable(Utils.date1));
    }
    @Test
    public void recruiter_should_not_be_available(){
        Recruiter recruiter = Utils.createRecruiter();
        Assert.assertEquals(false,recruiter.isAvailable(Utils.date3));
    }


    @Test
    public void recruiter_could_be_test_candidat(){
        Recruiter recruiter = Utils.createRecruiter();
        Candidat candidat = Utils.createCandidatWithJavaAndCrystalSkills();

        Assert.assertEquals(true,recruiter.canTestCandidat(candidat.getSkills()));
    }
    @Test
    public void recruiter_could_not_be_test_candidat(){
        Recruiter recruiter = Utils.createRecruiter();
        Candidat candidat = Utils.createCandidatWithPythonSkills();

        Assert.assertEquals(false,recruiter.canTestCandidat(candidat.getSkills()));
    }
}
