package com.example.Notebook.Controller;

import com.example.Notebook.DTO.HealthDto;
import com.example.Notebook.Service.HealthService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Health")
public class HealthController {

    private final HealthService healthService;


    HealthController(HealthService healthService)
    {
        this.healthService = healthService;
    }

    @GetMapping("/GetActivity/{id}")
    private HealthDto getActivityById(@PathVariable long id)
    {
        return healthService.getHealthActivityById(id);
    }

    @GetMapping("/getAllActivity/{id}")
    private List<HealthDto> getAllActivityById(@PathVariable long userId)
    {
        return healthService.getAllHealthActivityById(userId);
    }

    @PostMapping("/AddActivity/{id}")
    private void addActivityById(@PathVariable long userId,@RequestBody HealthDto healthDto)
    {
           healthService.addNewActivity(userId,healthDto);
    }



}
