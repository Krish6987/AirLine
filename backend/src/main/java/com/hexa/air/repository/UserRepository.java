package com.hexa.air.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexa.air.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
