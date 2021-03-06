package com.example.Rest.Swagger.Microservice.repository;

import com.example.Rest.Swagger.Microservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

  User findFirstByOrderByIdAsc();

  User findFirstByOrderByIdDesc();
}
