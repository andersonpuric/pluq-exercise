package com.pluq.pluqexercise.controller;

import com.pluq.pluqexercise.model.MeterValue;
import com.pluq.pluqexercise.service.MeterValueService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/meter-values")
@AllArgsConstructor
public class MeterValueController {

    private final MeterValueService meterValueService;

    @GetMapping("/list")
    public Iterable<MeterValue> list() {
        return meterValueService.list();
    }

    @GetMapping("/{id}")
    public MeterValue findById(@PathVariable Long id) {
        return meterValueService.findById(id);
    }

    @PostMapping("/save")
    public MeterValue save(@RequestBody MeterValue meterValue) {
        return meterValueService.save(meterValue);
    }

    @PostMapping("/save-all")
    public Iterable<MeterValue> saveAll() {
        return meterValueService.saveAll();
    }
}
