package model;

import model.common.SkillDTO;

import java.util.Objects;

public class Skill{
    private final String name;

    public Skill(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Skill skill = (Skill) o;
        return Objects.equals(name, skill.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public SkillDTO skillToDTO(){
        return new SkillDTO(name);
    }

}