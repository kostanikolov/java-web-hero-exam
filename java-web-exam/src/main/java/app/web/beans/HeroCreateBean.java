package app.web.beans;

import app.domain.entities.ClassType;
import app.domain.models.binding.HeroCreateBindingModel;
import app.domain.models.service.HeroServiceModel;
import app.service.HeroService;
import org.modelmapper.ModelMapper;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class HeroCreateBean extends BaseBean {

    private HeroCreateBindingModel bindingModel;
    private HeroService heroService;
    private ModelMapper modelMapper;

    public HeroCreateBean() {
    }

    @Inject
    public HeroCreateBean(HeroService heroService, ModelMapper modelMapper) {
        this.heroService = heroService;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    public void init() {
        this.bindingModel = new HeroCreateBindingModel();
    }

    public void create() {
        HeroServiceModel model = this.modelMapper.map(this.bindingModel, HeroServiceModel.class);
        ClassType classType = null;

        try {
            classType = ClassType.valueOf(this.bindingModel.getClassType().toUpperCase());
        } catch (Exception ex) {
            this.redirect("/create-hero");
        }

        model.setClassType(classType);
        this.heroService.save(model);
        this.redirect("/home");
    }

    public HeroCreateBindingModel getBindingModel() {
        return this.bindingModel;
    }

    public void setBindingModel(HeroCreateBindingModel bindingModel) {
        this.bindingModel = bindingModel;
    }
}
