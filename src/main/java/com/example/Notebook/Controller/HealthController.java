package com.example.Notebook.Controller;

import com.example.Notebook.DTO.HealthDto;
import com.example.Notebook.Service.HealthService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Health")
public class HealthController {

    private final HealthService healthService;


    HealthController(HealthService healthService)
    {
        this.healthService = healthService;
    }

    @GetMapping("/GetActivity/{id}")
    private HealthDto getActivityById(long id)
    {
        return healthService.getHealthActivityById(id);
    }

}
