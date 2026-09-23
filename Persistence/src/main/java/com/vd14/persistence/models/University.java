package com.vd14.persistence.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class University {
    private long id;
    private String name;
    private double overallScore;
    private String country;
    private String city;
}
