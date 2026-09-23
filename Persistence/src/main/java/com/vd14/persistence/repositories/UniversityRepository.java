package com.vd14.persistence.repositories;

import com.vd14.persistence.models.University;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class UniversityRepository implements UniRepository {
    private final JdbcTemplate jdbcTemplate;

    public UniversityRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void insert(University entity) {

    }

    @Override
    public void update(University entity) {

    }

    @Override
    public University findById(long id) {
        return null;
    }

    @Override
    public List<University> findAll() {
        return List.of();
    }
}
