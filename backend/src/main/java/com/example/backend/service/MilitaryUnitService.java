package com.example.backend.service;

import com.example.backend.model.MilitaryUnit;
import com.example.backend.repository.MilitaryUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MilitaryUnitService {

    private final MilitaryUnitRepository militaryUnitRepository;

    @Autowired
    public MilitaryUnitService(MilitaryUnitRepository militaryUnitRepository) {
        this.militaryUnitRepository = militaryUnitRepository;
    }

    public List<MilitaryUnit> getAllUnits() {
        return militaryUnitRepository.findAll();
    }

    public Optional<MilitaryUnit> getUnitById(Long id) {
        return militaryUnitRepository.findById(id);
    }

    public MilitaryUnit createUnit(MilitaryUnit militaryUnit) {
        return militaryUnitRepository.save(militaryUnit);
    }

    public Optional<MilitaryUnit> updateUnit(Long id, MilitaryUnit unitDetails) {
        return militaryUnitRepository.findById(id)
            .map(unit -> {
                unit.setUnitName(unitDetails.getUnitName());
                unit.setUnitAffiliation(unitDetails.getUnitAffiliation());
                unit.setForceEquivalent(unitDetails.getForceEquivalent());
                return militaryUnitRepository.save(unit);
            });
    }

    public boolean deleteUnit(Long id) {
        return militaryUnitRepository.findById(id)
            .map(unit -> {
                militaryUnitRepository.delete(unit);
                return true;
            })
            .orElse(false);
    }
}
