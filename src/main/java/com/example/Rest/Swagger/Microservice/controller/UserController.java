package com.example.Rest.Swagger.Microservice.controller;

import com.example.Rest.Swagger.Microservice.model.dto.UserDTO;
import com.example.Rest.Swagger.Microservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

  @Autowired
  private UserService userService;

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public UserDTO getById(@PathVariable Integer id) {
    return userService.findById(id);
  }

  @RequestMapping(method = RequestMethod.POST)
  public UserDTO create(@Valid @RequestBody UserDTO user) {
    return userService.create(user);
  }

  @RequestMapping(method = RequestMethod.GET)
  public List<UserDTO> findAll() {
    return userService.findAll();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public UserDTO update(@PathVariable Integer id, @RequestBody UserDTO dto) {
    return userService.update(id, dto);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public void delete(@PathVariable Integer id) {
    userService.delete(id);
  }
}
