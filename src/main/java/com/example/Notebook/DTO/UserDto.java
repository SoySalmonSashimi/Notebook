package com.example.Notebook.DTO;

import com.example.Notebook.Entity.Note;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class UserDto {

    long userId;
    String name;
    int age;
    String email;
    String address;
    String gender;
    int income;
    int dependency;
    String country;
    int contactNumber;
    LocalDate birthday;
    double height;
    double weight;
    String jobTitle;
    List<Note> listOfNotes;
}
