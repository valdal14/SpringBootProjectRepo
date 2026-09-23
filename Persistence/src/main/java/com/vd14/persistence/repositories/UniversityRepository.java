package com.vd14.persistence.repositories;

import com.vd14.persistence.models.University;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class UniversityRepository implements UniRepository {
    private final JdbcTemplate jdbcTemplate;
    private final static String UNI_COLUMNS = "UNI.ID, UNI.NAME, UNI.OVERALL_SCORE, UNI.CITY, UNI.COUNTRY";
    private final static String SELECT_ALL = "SELECT " + UNI_COLUMNS + " FROM University AS UNI";
    private final static String SELECT_BY_ID = "SELECT " + UNI_COLUMNS + " FROM University AS UNI WHERE UNI.ID = ?";
    private final static String INSERT_UNI = "INSERT INTO University (NAME, OVERALL_SCORE, CITY, COUNTRY) VALUES (?, ?, ?, ?)";
    private final static String UPDATE_UNI = "UPDATE University SET NAME = ?, OVERALL_SCORE = ?, CITY = ?, COUNTRY = ? WHERE ID = ?";

    public UniversityRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void insert(University entity) {
        this.jdbcTemplate.update(INSERT_UNI, entity.getName(), entity.getOverallScore(), entity.getCity(), entity.getCountry());
    }

    @Override
    public void update(University entity) {
        this.jdbcTemplate.update(UPDATE_UNI, entity.getName(), entity.getOverallScore(), entity.getCity(), entity.getCountry(), entity.getId());
    }

    @Override
    public University findById(long id) {
        return this.jdbcTemplate.queryForObject(SELECT_BY_ID, universityRowMapper, id);
    }

    @Override
    public List<University> findAll() {
        return this.jdbcTemplate.query(SELECT_ALL, universityRowMapper);
    }

    private final RowMapper<University> universityRowMapper = (rs, rowNum) -> {
        long id = rs.getLong("ID");
        String name = rs.getString("NAME");
        long overallScore = rs.getLong("OVERALL_SCORE");
        String city = rs.getString("CITY");
        String country = rs.getString("COUNTRY");
        return new University(id, name, overallScore, city, country);
    };
}
