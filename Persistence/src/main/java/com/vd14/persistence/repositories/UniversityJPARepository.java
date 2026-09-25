package com.vd14.persistence.repositories;

import com.vd14.persistence.models.UniClass;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UniversityJPARepository implements UniJPARepository {
    // JPQL. 'u' is an alias for the UniClass object.
    private final static String SELECT_ALL = "SELECT u FROM UniClass u";

    @PersistenceContext
    private EntityManager em;

    @Override
    public void insert(UniClass entity) {
        em.persist(entity);
    }

    @Override
    public void update(UniClass entity) {
        em.merge(entity);
    }

    @Override
    public Optional<UniClass> findById(long id) {
        return Optional.ofNullable(em.find(UniClass.class, id));
    }

    @Override
    public List<UniClass> findAll() {
        return em.createQuery(SELECT_ALL, UniClass.class).getResultList();
    }
}
