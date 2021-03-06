package com.example.Rest.Swagger.Microservice.model;


import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name = "task")
public class Task {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  private Integer id;
  @Column
  @NotNull
  @Size(min = 1, max = 64)
  private String description;
  @Column
  private boolean completed;
  @Column
  @Min(0)
  @Max(100)
  private Integer completionPercentage;
  @ManyToOne(fetch = FetchType.LAZY)
  private User user;

  public Task() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public boolean isCompleted() {
    return completed;
  }

  public void setCompleted(boolean completed) {
    this.completed = completed;
  }

  public Integer getCompletionPercentage() {
    return completionPercentage;
  }

  public void setCompletionPercentage(Integer completionPercentage) {
    this.completionPercentage = completionPercentage;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}
