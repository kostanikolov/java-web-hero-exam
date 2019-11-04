package app.repository;

import app.domain.entities.Hero;

import java.util.List;

public interface HeroRepository {

    void save(Hero hero);

    Hero findById(String id);

    List<Hero> findAll();

    void delete(String id);
}
