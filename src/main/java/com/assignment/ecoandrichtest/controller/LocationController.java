package com.assignment.ecoandrichtest.controller;

import com.assignment.ecoandrichtest.domain.entity.Location;
import com.assignment.ecoandrichtest.repository.LocationRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Location API", description = "위치 관련 API.")
@RestController
@RequestMapping("/location/v1")
@RequiredArgsConstructor
public class LocationController {

    private final LocationRepository locationRepository;

    @Operation(summary = "위치 조회", description = "위치 조회 API.")
    @GetMapping("/{id}")
    public ResponseEntity<Location> getLocationById(@PathVariable Long id) {
        Location location = locationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Location not found with id: " + id));
        return ResponseEntity.ok(location);
    }

    @Operation(summary = "위치 정보 모두 조회", description = "위치 정보.")
    @GetMapping("/")
    public ResponseEntity<List<Location>> getAllLocations() {
        List<Location> locations = locationRepository.findAll();
        return ResponseEntity.ok(locations);
    }
}


