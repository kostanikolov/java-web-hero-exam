package app.domain.models.binding;

public class HeroCreateBindingModel {

    private String heroName;
    private String classType;
    private Integer level;

    public HeroCreateBindingModel() {
    }

    public String getHeroName() {
        return this.heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public String getClassType() {
        return this.classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public Integer getLevel() {
        return this.level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
