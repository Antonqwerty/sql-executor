package com.antonqwerty.sql.executor.controller;

import com.antonqwerty.sql.executor.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/city")
@RequiredArgsConstructor
public class CityController {

    private final CityService cityService;

    @PostMapping
    public void create(@RequestBody String row) {
        cityService.create(row);
    }

    @GetMapping
    public String get(@RequestParam Long id) {
        return cityService.get(id);
    }

    @DeleteMapping
    public void delete(@RequestParam Long id) {
        cityService.delete(id);
    }
}
