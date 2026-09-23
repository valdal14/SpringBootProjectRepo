package com.vd14.persistence.repositories;

import com.vd14.persistence.models.University;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class UniversityRepository implements UniRepository {
    private final JdbcTemplate jdbcTemplate;
    private final static String SELECT_ALL = "SELECT UNI.ID, UNI.NAME, UNI.OVERALL_SCORE, UNI.CITY, UNI.COUNTRY FROM University AS UNI";

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
        return this.jdbcTemplate.query(SELECT_ALL, (rs, rowNum) -> {
            long id = rs.getLong("ID");
            String name = rs.getString("NAME");
            long overallScore = rs.getLong("OVERALL_SCORE");
            String city = rs.getString("CITY");
            String country = rs.getString("COUNTRY");
            return new University(id, name, overallScore, city, country);
        });
    }
}
