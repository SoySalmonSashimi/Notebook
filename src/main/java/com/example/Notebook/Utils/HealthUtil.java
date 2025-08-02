package com.example.Notebook.Utils;

import com.example.Notebook.DTO.HealthDto;
import com.example.Notebook.Entity.Health;

import java.util.ArrayList;
import java.util.List;

public class HealthUtil {

    public static Health fromDto(HealthDto dto) {
        Health health = new Health();
        health.setDateTime(dto.getDateTime());
        health.setDistance(dto.getDistance());
        health.setHeight(dto.getHeight());
        health.setWeight(dto.getWeight());
        health.setSportsName(dto.getSportsName());
        return health;
    }

    public static HealthDto toDto(Health health)
    {
        HealthDto healthDto= new HealthDto();
        healthDto.setHealthId(health.getHealthId());
        healthDto.setWeight(health.getWeight());
        healthDto.setDistance(health.getWeight());
        healthDto.setDateTime(health.getDateTime());
        healthDto.setSportsName(health.getSportsName());
        healthDto.setHeight(health.getHeight());
        return healthDto;
    }

    public static List<HealthDto> toDtoList(List<Health> listOfActivitiesByUser)
    {
        HealthDto healthDto;
        List<HealthDto> listOfHealthDto = new ArrayList<>();
        for(Health health: listOfActivitiesByUser)
        {
            healthDto = null;
            healthDto = new HealthDto();
            healthDto.setHealthId(health.getHealthId());
            healthDto.setHeight(health.getHeight());
            healthDto.setWeight(health.getWeight());
            healthDto.setDistance(health.getDistance());
            healthDto.setSportsName(health.getSportsName());
            healthDto.setDateTime(health.getDateTime());
            listOfHealthDto.add(healthDto);

        }
        return listOfHealthDto;
    }


}
