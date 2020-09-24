package com.cg.flight.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.flight.entity.User;
@Repository
public interface UserDao extends JpaRepository<User,String>{
@Query("from User where contactNo=:cno")	
	public User viewUser(@Param("cno") String contactNo);
}
