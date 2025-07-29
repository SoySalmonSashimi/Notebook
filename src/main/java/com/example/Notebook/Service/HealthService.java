package com.example.Notebook.Service;

import com.example.Notebook.DTO.HealthDto;
import com.example.Notebook.Entity.Health;
import com.example.Notebook.Repository.HealthRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class HealthService {

    private final HealthRepository healthRepository;

    HealthService(HealthRepository healthRepository)
    {
        this.healthRepository = healthRepository;
    }

    public HealthDto getHealthActivityById(long id)
    {
        Health healthActivity = healthRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Activity was not found :" +id));
        HealthDto healthDto = new HealthDto();
        healthDto.setHealthId(healthActivity.getHealthId());
        healthDto.setWeight(healthActivity.getWeight());
        healthDto.setDistance(healthActivity.getDistance());
        healthDto.setDateTime(healthActivity.getDateTime());
        healthDto.setSportsName(healthActivity.getSportsName());

        return healthDto;
    }
}
