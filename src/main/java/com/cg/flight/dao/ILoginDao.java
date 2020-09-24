package com.cg.flight.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.flight.entity.User;


@Repository
public interface ILoginDao  extends JpaRepository<User, String>{


}