package com.pluq.pluqexercise.controller;

import com.pluq.pluqexercise.model.Location;
import com.pluq.pluqexercise.model.Report;
import com.pluq.pluqexercise.service.LocationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/locations")
@AllArgsConstructor
public class LocationController {

    private final LocationService locationService;

    @GetMapping("/list")
    public Iterable<Location> list() {
        return locationService.list();
    }

    @GetMapping("/{id}")
    public Location findById(@PathVariable Long id) {
        return locationService.findById(id);
    }

    @GetMapping("/report")
    public Report getReport() {
        return locationService.getReport();
    }

    @PostMapping("/save")
    public Location save(@RequestBody Location location) {
        return locationService.save(location);
    }

    @PostMapping("/save-all")
    public Iterable<Location> saveAll() {
        return locationService.saveAll();
    }
}
