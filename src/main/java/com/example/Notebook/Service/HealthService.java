package com.example.Notebook.Service;

import com.example.Notebook.Dto.HealthDto;
import com.example.Notebook.Utils.HealthUtil;
import com.example.Notebook.Entity.Health;
import com.example.Notebook.Entity.User;
import com.example.Notebook.Repository.HealthRepository;
import com.example.Notebook.Repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional(readOnly = true)
    public HealthDto getHealthActivityById(long id)
    {
        Health healthActivity = healthRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Activity was not found :" +id));
        return HealthUtil.toDto(healthActivity);
    }

    @Transactional(readOnly = true)
    public List<HealthDto> getAllHealthActivitiesById(long userId)
    {
        List<Health> listOfActivitiesByUser = healthRepository.findByUserUserId(userId);
        return HealthUtil.toDtoList(listOfActivitiesByUser);
    }

    @Transactional
    public void addNewActivity(long userId,HealthDto healthDto)
    {
        User user = userRepository.findById(userId).orElseThrow(()-> new EntityNotFoundException("User is not found" + userId));
        Health health = HealthUtil.fromDto(healthDto);
        health.setUser(user);
        healthRepository.save(health);
    }

    @Transactional
    public void deleteActivityById(long userId, long activityId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

        Health activityToRemove = user.getListOfSportActivities().stream()
                .filter(activity -> activity.getHealthId() == activityId)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Activity not found with id: " + activityId));

        user.getListOfSportActivities().remove(activityToRemove);
        healthRepository.delete(activityToRemove);
    }

}
