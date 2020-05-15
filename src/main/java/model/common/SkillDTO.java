package java.model.common;

public class SkillDTO {

    private final String name;

    public SkillDTO(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public SkillDTO skillToDTO(model.Skill skill){
        return new SkillDTO(skill.getName());
    }
}