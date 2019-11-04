package app.domain.entities;

import javax.persistence.*;

@Entity
@Table(name = "heroes")
public class Hero extends BaseEntity {

    private String name;
    private ClassType classType;
    private Integer level;

    public Hero() {
    }

    @Column(name = "name", nullable = false, unique = true)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "class_type", nullable = false)
    @Enumerated(EnumType.STRING)
    public ClassType getClassType() {
        return this.classType;
    }

    public void setClassType(ClassType classType) {
        this.classType = classType;
    }


    @Column(name = "level", nullable = false)
    public Integer getLevel() {
        return this.level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
