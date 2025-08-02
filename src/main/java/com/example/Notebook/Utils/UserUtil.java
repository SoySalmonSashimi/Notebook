package com.example.Notebook.Utils;

import com.example.Notebook.DTO.UserDto;
import com.example.Notebook.Entity.User;

public class UserUtil {


    public static User fromDto(UserDto userDto)
    {
        User user = new User();
        user.setAge(userDto.getAge());
        user.setUserId(userDto.getUserId());
        user.setAddress(userDto.getAddress());
        user.setCountry(userDto.getCountry());
        user.setJobTitle(userDto.getJobTitle());
        user.setBirthday(userDto.getBirthday());
        user.setContactNumber(userDto.getContactNumber());
        user.setGender(userDto.getGender());
        user.setListOfFinanceTrackingActivities(userDto.getListOfFinanceTrackingActivities());
        user.setListOfSportActivities(userDto.getListOfSportActivities());
        user.setListOfNotes(userDto.getListOfNotes());
        return user;
    }

    public static UserDto toDto(User user)
    {
        UserDto userDto = new UserDto();
        userDto.setAge(user.getAge());
        userDto.setUserId(user.getUserId());
        userDto.setAddress(user.getAddress());
        userDto.setCountry(user.getCountry());
        userDto.setJobTitle(user.getJobTitle());
        userDto.setBirthday(user.getBirthday());
        userDto.setContactNumber(user.getContactNumber());
        userDto.setGender(user.getGender());
        userDto.setListOfFinanceTrackingActivities(user.getListOfFinanceTrackingActivities());
        userDto.setListOfSportActivities(user.getListOfSportActivities());
        userDto.setListOfNotes(user.getListOfNotes());
        return userDto;
    }
}
