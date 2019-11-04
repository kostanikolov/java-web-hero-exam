package app.repository;

import app.domain.entities.Hero;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class HeroRepositoryImpl implements HeroRepository {

    private final EntityManager entityManager;

    @Inject
    public HeroRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Hero hero) {
        entityManager.getTransaction().begin();
        entityManager.persist(hero);
        entityManager.getTransaction().commit();
    }

    @Override
    public Hero findById(String id) {
        return entityManager.createQuery(
                "SELECT h FROM Hero h WHERE h.id = :id", Hero.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public List<Hero> findAll() {
        return this.entityManager
                .createQuery("SELECT h FROM Hero h", Hero.class)
                .getResultList();
    }

    @Override
    public void delete(String id) {
        this.entityManager.getTransaction().begin();

        this.entityManager.createQuery("DELETE FROM Hero h WHERE h.id =:id")
                .setParameter("id", id)
                .executeUpdate();

        this.entityManager.getTransaction().commit();
    }
}
