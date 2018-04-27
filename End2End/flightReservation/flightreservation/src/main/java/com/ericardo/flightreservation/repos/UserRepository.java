package com.ericardo.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ericardo.flightreservation.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
