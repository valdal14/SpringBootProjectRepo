package com.vd14.persistence.repositories;

import java.util.List;

public interface H2Repository<T> {
    void insert(T entity);
    void update(T entity);
    T findById(long id);
    List<T> findAll();
}
