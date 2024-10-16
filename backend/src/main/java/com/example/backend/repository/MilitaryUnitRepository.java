package com.example.backend.repository;

import com.example.backend.model.MilitaryUnit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MilitaryUnitRepository extends JpaRepository<MilitaryUnit, Long> {
}
