package model.common;
import model.Skill;

public class SkillDTO {

    private final String name;

    public SkillDTO(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public Skill DTOToSkill(){
        return new Skill(name);
    }
}