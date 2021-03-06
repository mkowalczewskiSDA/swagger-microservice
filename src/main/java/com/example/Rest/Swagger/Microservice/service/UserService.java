package com.example.Rest.Swagger.Microservice.service;

import com.example.Rest.Swagger.Microservice.model.dto.UserDTO;

import java.util.List;

public interface UserService {

  List<UserDTO> findAll();

  UserDTO create(UserDTO task);

  UserDTO update(Integer id, UserDTO task);

  void delete(Integer id);

  UserDTO findById(Integer id);

  UserDTO findLast();

}
