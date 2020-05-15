package model;


import java.model.common.SkillDTO;

public class Skill{
    private final String name;

    public Skill(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    public Skill DTOToSkill(SkillDTO skillDTO){
        return new Skill(skillDTO.getName());
    }

}