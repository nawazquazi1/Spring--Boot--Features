package com.nawaz.spring.boot.dao;

import com.javatechie.spring.scheduler.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer>{

}
