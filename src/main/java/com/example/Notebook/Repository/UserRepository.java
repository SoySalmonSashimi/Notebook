package com.example.Notebook.Repository;

import com.example.Notebook.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User,Long> {


}
