package com.example.Notebook.Utils;

import com.example.Notebook.Dto.UserDto;
import com.example.Notebook.Entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserUtil {


    public static User fromDto(UserDto userDto)
    {
        User user = new User();
        user.setAge(userDto.getAge());
        user.setUserId(userDto.getUserId());
        user.setName(userDto.getName());
        user.setEmailAddress(userDto.getEmailAddress());
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
        userDto.setName(user.getName());
        userDto.setEmailAddress(user.getEmailAddress());
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

    public static void updateUserFromDto(User existingUser, UserDto dto) {
        existingUser.setName(dto.getName());
        existingUser.setAge(dto.getAge());
        existingUser.setJobTitle(dto.getJobTitle());
        existingUser.setName(dto.getName());
        existingUser.setEmailAddress(dto.getEmailAddress());
        existingUser.setContactNumber(dto.getContactNumber());
        existingUser.setBirthday(dto.getBirthday());
        existingUser.setAddress(dto.getAddress());
        existingUser.setListOfNotes(dto.getListOfNotes());
        existingUser.setListOfFinanceTrackingActivities(dto.getListOfFinanceTrackingActivities());
        existingUser.setListOfSportActivities(dto.getListOfSportActivities());
    }

    public static List<UserDto> toDtoList(List<User> listOfUser)
    {
        List<UserDto> listOfUserDto = new ArrayList<>();
        UserDto userDto = null;
        for(User user: listOfUser)
        {
            userDto = new UserDto();
            listOfUserDto.add(UserUtil.toDto(user));

        }
        return listOfUserDto;

    }
}
