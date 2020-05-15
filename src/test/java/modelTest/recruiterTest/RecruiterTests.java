package modelTest.recruiterTest;

import infrastructure.utils.Utils;
import model.common.CandidatDTO;
import model.common.RecruiterDTO;
import model.recruiter.exception.RecruiterException;
import org.junit.Assert;
import org.junit.Test;


public class RecruiterTests {

    @Test
    public void it_should_create_recruiter(){
        RecruiterDTO recruiter = Utils.createRecruiterWithJavaAndCrystalSkills();
        Assert.assertNotNull("Recruiter created",recruiter);
    }

    @Test
    public void it_should_throw_exception_when_recruiter_havent_name(){
        Assert.assertThrows(RecruiterException.class,()-> Utils.createRecruiterWithEmptyName());
    }

    @Test
    public void it_should_throw_exception_when_recruiter_havent_mail(){
        Assert.assertThrows(RecruiterException.class,()-> Utils.createRecruiterWithEmptyMail());
    }

    @Test
    public void it_should_throw_exception_when_recruiter_havent_skills(){
        Assert.assertThrows(RecruiterException.class,()-> Utils.createRecruiterWithoutSkills());
    }

    @Test
    public void recruiter_should_be_available(){
        RecruiterDTO recruiter = Utils.createRecruiterWithJavaAndCrystalSkills();
        Assert.assertEquals(true,recruiter.DtoToRecruiter().isAvailable(Utils.date1));
    }
    @Test
    public void recruiter_should_not_be_available(){
        RecruiterDTO recruiter = Utils.createRecruiterWithJavaAndCrystalSkills();
        Assert.assertEquals(false,recruiter.DtoToRecruiter().isAvailable(Utils.date3));
    }

    //TODO : la methode canTestCandidat retourne toujours false :/
    @Test
    public void recruiter_could_be_test_candidat(){
        RecruiterDTO recruiter = Utils.createRecruiterWithJavaAndCrystalSkills();
        CandidatDTO candidat = Utils.createCandidatWithJavaAndCrystalSkills();

        Assert.assertEquals(true,recruiter.DtoToRecruiter().canTestCandidat(candidat.DtoToCandidat().getSkills()));
    }
    @Test
    public void recruiter_could_not_be_test_candidat(){
        RecruiterDTO recruiter = Utils.createRecruiterWithJavaAndCrystalSkills();
        CandidatDTO candidat = Utils.createCandidatWithPythonSkills();

        Assert.assertEquals(false,recruiter.DtoToRecruiter().canTestCandidat(candidat.DtoToCandidat().getSkills()));
    }
}
