package com.example.Notebook.Controller;

import com.example.Notebook.Dto.HealthDto;
import com.example.Notebook.Entity.Health;
import com.example.Notebook.Service.HealthService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/health")
public class HealthController {

    private final HealthService healthService;


    HealthController(HealthService healthService)
    {
        this.healthService = healthService;
    }

    @GetMapping("user/{userId}/health")
    private ResponseEntity<HealthDto> getActivityById(@PathVariable long userId)
    {
        HealthDto activity = healthService.getHealthActivityById(userId);
        return ResponseEntity.ok(activity); // ok 200 status success
    }

    @GetMapping("user/{userId}/activities")
    private ResponseEntity<List<HealthDto>> getAllActivitiesById(@PathVariable long userId)
    {
        List<HealthDto> listOfHealthDto = healthService.getAllHealthActivitiesById(userId);
        return ResponseEntity.ok(listOfHealthDto); // ok 200 status success
    }

    @PostMapping("user/{userId}/activities")
    private ResponseEntity<Void> addActivityById(@PathVariable long userId,@RequestBody HealthDto healthDto)
    {
        healthService.addNewActivity(userId,healthDto);
        return ResponseEntity.status(HttpStatus.CREATED).build(); // 201 created

    }

    @DeleteMapping("user/{userId}/activities/{activityId}")
    private ResponseEntity<Void> deleteActivity(long userId,long activityId)
    {
        healthService.deleteActivityById(userId,activityId);
        return ResponseEntity.noContent().build(); //204 success but  no content
    }



}
