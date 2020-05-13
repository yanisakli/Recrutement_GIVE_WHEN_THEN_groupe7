package main.java.use_case;

public class Skill{
    private final String name;

    public Skill(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    public boolean compareQualification(Skill skill){
        if(this.getName() != skill.getName())return false;
        return false;
    }
}