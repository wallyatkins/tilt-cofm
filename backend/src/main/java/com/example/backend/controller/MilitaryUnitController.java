package com.example.backend.controller;

import com.example.backend.model.MilitaryUnit;
import com.example.backend.service.MilitaryUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/units")
public class MilitaryUnitController {

    private final MilitaryUnitService militaryUnitService;

    @Autowired
    public MilitaryUnitController(MilitaryUnitService militaryUnitService) {
        this.militaryUnitService = militaryUnitService;
    }

    @GetMapping
    public List<MilitaryUnit> getAllUnits() {
        return militaryUnitService.getAllUnits();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MilitaryUnit> getUnitById(@PathVariable Long id) {
        return militaryUnitService.getUnitById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public MilitaryUnit createUnit(@RequestBody MilitaryUnit militaryUnit) {
        return militaryUnitService.createUnit(militaryUnit);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MilitaryUnit> updateUnit(@PathVariable Long id, @RequestBody MilitaryUnit militaryUnit) {
        return militaryUnitService.updateUnit(id, militaryUnit)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUnit(@PathVariable Long id) {
        return militaryUnitService.deleteUnit(id)
            ? ResponseEntity.ok().build()
            : ResponseEntity.notFound().build();
    }
}
