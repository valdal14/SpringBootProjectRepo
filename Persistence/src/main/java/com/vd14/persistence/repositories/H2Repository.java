package com.vd14.persistence.repositories;

import java.util.List;
import java.util.Optional;

public interface H2Repository<T> {
    void insert(T entity);
    void update(T entity);
    Optional<T> findById(long id);
    List<T> findAll();
}
