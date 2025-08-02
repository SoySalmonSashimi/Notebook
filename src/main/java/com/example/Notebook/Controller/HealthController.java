package com.example.Notebook.Controller;

import com.example.Notebook.Dto.HealthDto;
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

    @GetMapping("/GetActivity/{userId}")
    private HealthDto getActivityById(@PathVariable long userId)
    {
        return healthService.getHealthActivityById(userId);
    }

    @GetMapping("/getAllActivities/{userId}")
    private List<HealthDto> getAllActivitiesById(@PathVariable long userId)
    {
        return healthService.getAllHealthActivitiesById(userId);
    }

    @PostMapping("/AddActivity/{userId}")
    private void addActivityById(@PathVariable long userId,@RequestBody HealthDto healthDto)
    {
        healthService.addNewActivity(userId,healthDto);
    }

    @DeleteMapping("/DeleteActivity/{userId}/{activityId}")
    private void deleteActivity(long userId,long activityId)
    {
        healthService.deleteActivityById(userId,activityId);
    }



}
