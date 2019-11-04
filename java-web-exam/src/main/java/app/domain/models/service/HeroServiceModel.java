package app.domain.models.service;

import app.domain.entities.ClassType;

public class HeroServiceModel {

    private String id;
    private String name;
    private ClassType classType;
    private Integer level;

    public HeroServiceModel() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ClassType getClassType() {
        return this.classType;
    }

    public void setClassType(ClassType classType) {
        this.classType = classType;
    }

    public Integer getLevel() {
        return this.level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
