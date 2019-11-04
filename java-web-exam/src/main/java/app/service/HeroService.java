package app.service;

import app.domain.models.service.HeroServiceModel;

import java.util.List;

public interface HeroService {

    void save(HeroServiceModel hero);

    HeroServiceModel getById(String id);

    List<HeroServiceModel> getAll();

    void delete(String id);
}
