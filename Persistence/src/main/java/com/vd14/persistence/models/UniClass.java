package com.vd14.persistence.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "University")
public class UniClass {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private double overallScore;
    private String city;
    private String country;

    public UniClass() {}

    public UniClass(long id, String name, double overallScore, String city, String country) {
        this.id = id;
        this.name = name;
        this.overallScore = overallScore;
        this.city = city;
        this.country = country;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getOverallScore() {
        return overallScore;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOverallScore(double overallScore) {
        this.overallScore = overallScore;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, overallScore, city, country);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UniClass uniClass = (UniClass) o;
        return id == uniClass.id && Double.compare(overallScore, uniClass.overallScore) == 0 && Objects.equals(name, uniClass.name) && Objects.equals(city, uniClass.city) && Objects.equals(country, uniClass.country);
    }

    @Override
    public String toString() {
        return "UniClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", overallScore=" + overallScore +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
