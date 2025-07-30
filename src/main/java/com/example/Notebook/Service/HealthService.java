package com.example.Notebook.Service;

import com.example.Notebook.DTO.HealthDto;
import com.example.Notebook.Entity.Health;
import com.example.Notebook.Entity.User;
import com.example.Notebook.Repository.HealthRepository;
import com.example.Notebook.Repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import com.example.Notebook.Utils.HealthUtil;

import java.util.ArrayList;
import java.util.List;

@Service
public class HealthService {

    private final HealthRepository healthRepository;
    private final UserRepository userRepository;
    HealthService(HealthRepository healthRepository, UserRepository userRepository)
    {
        this.userRepository = userRepository;
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


    public List<HealthDto> getAllHealthActivityById(long userId)
    {
        List<Health> listOfActivitiesByUser = healthRepository.findByUserUserId(userId);
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


    public void addNewActivity(long userId,HealthDto healthDto)
    {

        User user = userRepository.findById(userId).orElseThrow(()-> new EntityNotFoundException("User is not found " + userId));
        Health health = HealthUtil.fromDto(healthDto);
        user.getListOfSportActivities().add(health);

    }


}
