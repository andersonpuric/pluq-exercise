package com.pluq.pluqexercise.controller;


import com.pluq.pluqexercise.model.EnergyPrice;
import com.pluq.pluqexercise.service.EnergyPriceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/energy-prices")
@AllArgsConstructor
public class EnergyPriceController {

    private final EnergyPriceService energyPriceService;

    @GetMapping("/list")
    public Iterable<EnergyPrice> list() {
        return energyPriceService.list();
    }

    @GetMapping("/{id}")
    public EnergyPrice getById(@PathVariable Long id) {
        return energyPriceService.getById(id);
    }

    @PostMapping("/save")
    public EnergyPrice save(@RequestBody EnergyPrice energyPrice) {
        return energyPriceService.save(energyPrice);
    }

    @PostMapping("/save-all")
    public Iterable<EnergyPrice> saveAllData() {
        return energyPriceService.saveAll();
    }
}
