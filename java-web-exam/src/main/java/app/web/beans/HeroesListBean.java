package app.web.beans;

import app.domain.models.view.HeroViewModel;
import app.service.HeroService;
import org.modelmapper.ModelMapper;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Named
@RequestScoped
public class HeroesListBean extends BaseBean {

    private List<HeroViewModel> heroes;
    private HeroService heroService;
    private ModelMapper modelMapper;

    public HeroesListBean() {
    }

    @Inject
    public HeroesListBean(HeroService heroService, ModelMapper modelMapper) {
        this.heroService = heroService;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    public void init() {
        this.setHeroes(heroService.getAll().stream()
                .map(h -> this.modelMapper.map(h, HeroViewModel.class))
                .collect(Collectors.toList()));

        this.getHeroes().forEach(h -> h.setClassType(h.getClassType().toLowerCase()));
    }

    public List<HeroViewModel> getHeroes() {
        this.heroes.sort(Comparator.comparingInt(HeroViewModel::getLevel).reversed());
        return this.heroes;
    }

    public void setHeroes(List<HeroViewModel> heroes) {
        this.heroes = heroes;
    }
}
