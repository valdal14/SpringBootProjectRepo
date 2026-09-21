package com.vd14.restclients.repository;

import com.vd14.restclients.models.AstroModelRecord;

@FunctionalInterface
public interface AstroRepository {
    AstroModelRecord getRecord();
}
