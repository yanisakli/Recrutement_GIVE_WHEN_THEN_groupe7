package main.java.use_case.repositories;

import main.java.use_case.Skill;
import main.java.use_case.recruiter.Recruiteur;
import java.util.ArrayList;
import java.util.List;

public class Recruiters {
    public static List<Recruiteur> getRecruitersByDate(String date){
        //Le paramètre date n'est pas actif pour cette méthode
        List<Recruiteur> listRecruiter = new ArrayList<>();
        List<Skill> skills = new ArrayList<>();
        List<String> disponibilities = new ArrayList<>();

        skills.add(new Skill("java"));
        skills.add(new Skill("crystal"));

        disponibilities.add("22/05/2020");
        disponibilities.add("15/05/2020");
        disponibilities.add("30/05/2020");

        Recruiteur recruiteurOne = new Recruiteur("B01","yanisakli@yahoo.fr",skills,disponibilities);
        Recruiteur recruiteurTwo = new Recruiteur("A01","yanisakli@yahoo.fr",skills,disponibilities);
        Recruiteur recruiteurThree = new Recruiteur("B22","yanisakli@yahoo.fr",skills,disponibilities);

        listRecruiter.add(recruiteurOne);
        listRecruiter.add(recruiteurTwo);
        listRecruiter.add(recruiteurThree);

        return listRecruiter;

    }
}
