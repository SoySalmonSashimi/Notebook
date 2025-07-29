package com.example.Notebook.DTO;

import com.example.Notebook.Entity.Note;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class UserDto {

    private long userId;
    private String name;
    private int age;
    private String email;
    private String address;
    private String gender;
    private int income;
    private int dependency;
    private String country;
    private int contactNumber;
    private LocalDate birthday;
    private double height;
    private double weight;
    private String jobTitle;
    private List<Note> listOfNotes;
}
