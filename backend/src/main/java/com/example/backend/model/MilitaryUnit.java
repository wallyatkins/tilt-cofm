package com.example.backend.model;

import javax.persistence.*;

@Entity
@Table(name = "military_units")
public class MilitaryUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String unitName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UnitAffiliation unitAffiliation;

    @Column(nullable = false)
    private Float forceEquivalent;

    // Enum for unit affiliation
    public enum UnitAffiliation {
        FRIENDLY, NEUTRAL, HOSTILE, UNKNOWN
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public UnitAffiliation getUnitAffiliation() {
        return unitAffiliation;
    }

    public void setUnitAffiliation(UnitAffiliation unitAffiliation) {
        this.unitAffiliation = unitAffiliation;
    }

    public Float getForceEquivalent() {
        return forceEquivalent;
    }

    public void setForceEquivalent(Float forceEquivalent) {
        this.forceEquivalent = forceEquivalent;
    }
}
